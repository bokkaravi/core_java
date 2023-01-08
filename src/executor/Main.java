package executor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Main extends ReadData {
    static String firstHalfData ;
    static String secondHalfData;
    static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Ravi\\Documents\\assignment.txt"));
            String totalData="";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                totalData += line;
                totalData +=" ";
            }
            firstHalfData = totalData.substring(0, totalData.trim().length() / 2);
            secondHalfData = totalData.substring(totalData.trim().length() / 2, totalData.trim().length());
        }catch(FileNotFoundException exception){
            exception.printStackTrace();
        }finally {
            bufferedReader.close();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Set<Callable<HashMap<String,Integer>>> callables = new HashSet<Callable<HashMap<String,Integer>>>();

        callables.add(new Callable<HashMap<String,Integer>>() {
            public HashMap<String,Integer> call() throws Exception {
                HashMap<String,Integer> firstHalfDataCountMap = ReadData.countOfWords(firstHalfData.trim());
                return firstHalfDataCountMap;
            }
        });

        callables.add(new Callable<HashMap<String,Integer>>() {
            public HashMap<String,Integer> call() throws Exception {
                HashMap<String,Integer> secondHalfDataCountMap = ReadData.countOfWords(secondHalfData.trim());
                return secondHalfDataCountMap;
            }
        });

        List<Future<HashMap<String,Integer>>> futures = executorService.invokeAll(callables);
        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();

        for(Future<HashMap<String,Integer>> future : futures){
            HashMap<String,Integer> map = future.get();
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}

class ReadData {
    static HashMap<String,Integer> countOfWords(String halfData){
        HashMap<String,Integer> resultMap = new HashMap<>();
        String[] wordsArray = halfData.split(" ");
        for(String word : wordsArray){
            if (resultMap.containsKey(word)) {
                resultMap.put(word,resultMap.get(word) + 1);
            }else{
                resultMap.put(word,1);
            }
        }
        return resultMap;
    }
}
