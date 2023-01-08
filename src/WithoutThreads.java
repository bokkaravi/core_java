import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.*;

public class WithoutThreads  extends ReadData {
    static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws IOException {
        long startTs = System.currentTimeMillis();
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Ravi\\Documents\\assignment.txt"));
            String totalData = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                totalData += line;
                totalData += " ";
            }
            String firstHalfData = totalData.substring(0, totalData.trim().length() / 2);
            String secondHalfData = totalData.substring(totalData.trim().length() / 2, totalData.trim().length());

//            // 1. initialising phase
//            ExecutorService executorService = Executors.newFixedThreadPool(2);

            // 2.service phase
//            Future<HashMap<String,Integer>> firstHalfCount = new ReadData(firstHalfData.trim());
//            Future<HashMap<String,Integer>> secondHalfCount = executorService.submit(new executorService.ReadData(secondHalfData.trim()));

            HashMap<String, Integer> firstHalfCount = ReadData.read(firstHalfData.trim());
            HashMap<String, Integer> secondHalfCount = ReadData.read(secondHalfData.trim());

            System.out.println("firstHalfData :: " + firstHalfCount);
            System.out.println("secondHalfData :: " + secondHalfCount);

            readTotalCount(firstHalfCount, secondHalfCount);

            long endTs = System.currentTimeMillis();
            System.out.println("total time ::: " + ((endTs - startTs) / 1000));

            //3.distract phase
//            executorService.shutdown();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
    static void readTotalCount(HashMap<String,Integer> result,HashMap<String,Integer> secondHalfData){

        if(!secondHalfData.isEmpty() && !result.isEmpty()){
            secondHalfData.keySet().forEach(key->{
                if(result.containsKey(key)){
                    result.put(key,result.get(key) + secondHalfData.get(key));
                }else{
                    result.put(key,1);
                }
            });
        }
        System.out.println("result ::: "+result);
    }
}

class ReadData {
    static HashMap<String,Integer> resultMap = new HashMap<>();

    static HashMap<String, Integer> read(String data) throws Exception {
        if(!data.isEmpty()) {
            String[] wordsArray = data.split(" ");
            for (String word : wordsArray) {
                if (resultMap.containsKey(word))
                    resultMap.put(word, resultMap.get(word) + 1);
                else
                    resultMap.put(word, 1);
            }
        }
        return resultMap;
    }

}
