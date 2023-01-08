package thread;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainThread extends ReadData {
    static String firstHalfData ;
    static String secondHalfData;

    static HashMap<String,Integer> resultMap = new HashMap<>();
    static BufferedReader bufferedReader = null;

    static HashMap<String,Integer> firstHalfDataCountMap = new HashMap<>();

    static HashMap<String,Integer> secondHalfDataCountMap = new HashMap<>();



    public static void main(String[] args) throws IOException {
        long startTs = System.currentTimeMillis();
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Ravi\\Documents\\assignment.txt"));
            String totalData="";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
              totalData += line;
              totalData +=" ";
            }
            firstHalfData = totalData.substring(0, totalData.trim().length() / 2);
            System.out.println(firstHalfData.length());
            secondHalfData = totalData.substring(totalData.trim().length() / 2, totalData.trim().length());
            System.out.println("time for reading and divide"+(System.currentTimeMillis() - startTs));
        }catch(FileNotFoundException exception){
            exception.printStackTrace();
        }finally {
            bufferedReader.close();
        }


       Thread thread1 = new Thread(new Runnable() {
           @Override
           public void run() {
               HashMap<String,Integer> firstHalfDataCountMap = ReadData.countOfWords(firstHalfData.trim());
               System.out.println("first half data :: word vs count map ::  "+firstHalfDataCountMap);
               readDataCount(firstHalfDataCountMap);
               System.out.println("first thread ending the task :: "+(System.currentTimeMillis() - startTs));

           }
       });


       Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                HashMap<String, Integer> secondHalfDataCountMap = ReadData.countOfWords(secondHalfData.trim());
                System.out.println("second half data :: word vs count map ::  "+secondHalfDataCountMap);
                readDataCount(secondHalfDataCountMap);
                System.out.println("second thread ending the task :: "+(System.currentTimeMillis() - startTs));

            }
        });

       thread1.start();
       thread2.start();
        System.out.println("total time in main thread ending :: "+(System.currentTimeMillis() - startTs));




    }
    synchronized static void readDataCount(HashMap<String, Integer> wordVsCount) {
            if(resultMap.isEmpty()){
                for(Map.Entry<String,Integer> entry : wordVsCount.entrySet()){
                    resultMap.put(entry.getKey(), entry.getValue());
                }
            }else {
                for (Map.Entry<String, Integer> entry : wordVsCount.entrySet()) {
                    if (resultMap.containsKey(entry.getKey())) {
                        resultMap.put(entry.getKey(), entry.getValue() + resultMap.get(entry.getKey()));
                    } else {
                        resultMap.put(entry.getKey(), 1);
                    }
                }
                System.out.println("total count :: resultMap :: "+resultMap);
            }
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