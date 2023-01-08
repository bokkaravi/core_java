package executorService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ReadData implements Callable<HashMap<String,Integer>> {
    HashMap<String,Integer> resultMap = new HashMap<>();
    String data ;
    ReadData(String data){
            this.data = data;
    }
    @Override
    public HashMap<String, Integer> call() throws Exception {
        try {
            String[] wordsArray = data.split(" ");
            for (String word : wordsArray) {
                if (resultMap.containsKey(word.trim()))
                    resultMap.put(word.trim(), resultMap.get(word.trim()) + 1);
                else
                    resultMap.put(word.trim(), 1);
            }
        }catch (NullPointerException exception){
           exception.printStackTrace();
        }

        return resultMap;
    }
}

public class Main {

    static FileInputStream inputStream = null;
    static File file = null;
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        long startTs = System.currentTimeMillis();
        try {
//            file = new File("C:\\Users\\Ravi\\Documents\\testing.txt");
//            inputStream = new FileInputStream(file);
//            byte[] chunk = new byte[ (int)file.length()];//values inside
//            System.out.println(file.length()+"  "+(int)file.length());
//            inputStream.read(chunk);//it will values inside the chunk
//            String totalData = new String(chunk, StandardCharsets.UTF_8);
//            String firstHalfData = totalData.substring(0, totalData.length() / 2);
//            String secondHalfData = totalData.substring(totalData.length() / 2, totalData.length());
//            System.out.println("taking time in millis for reading file and divide it's into 2 half files :: "+(System.currentTimeMillis()-startTs)+" milli-seconds");

//            Stream<String> data = Files.lines(Paths.get("C:\\Users\\Ravi\\Documents\\assignment.txt"));
//            List<String[]> data1 = data.map(line -> line.split(" ")).filter(word -> !word.equals("")).collect(Collectors.toList());
//            data1.forEach(System.out::println);

            HashMap<String,Integer> resultMap = new HashMap<>();
            List<String> list = Files.lines(Paths.get("C:\\Users\\Ravi\\Documents\\assignment.txt")).collect(Collectors.toList());
            List<String[]> allwords = list.stream().map(line -> line.split(" ")).collect(Collectors.toList());
            allwords.stream().forEach(arrWords->{
               for(String word : arrWords){
                   if(resultMap.containsKey(word))
                       resultMap.put(word,resultMap.get(word) + 1);
                   else
                       resultMap.put(word,1);
               }
           });
            System.out.println(resultMap);


//            ExecutorService executorService = Executors.newFixedThreadPool(2);
//            Future<HashMap<String,Integer>> firstHalfCount = executorService.submit(new ReadData(firstHalfData.trim()));
//            Future<HashMap<String,Integer>> secondHalfCount = executorService.submit(new ReadData(secondHalfData.trim()));
//            readTotalCount(firstHalfCount.get(),secondHalfCount.get());
//
//            System.out.println("total time ::: "+(System.currentTimeMillis() - startTs)+" milli seconds");
//
//            executorService.shutdown();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();

        }
    }


    static void readTotalCount(HashMap<String,Integer> result,HashMap<String,Integer> secondHalfData){
        try {
            secondHalfData.keySet().forEach(key -> {
                result.compute(key, (k, v) -> (v == null) ? 1 : v + secondHalfData.get(key));
            });
        }catch(NullPointerException ex){
            ex.printStackTrace();
        }
        System.out.println("result ::: "+result);
    }
}
