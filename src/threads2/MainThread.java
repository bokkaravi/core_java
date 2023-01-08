package threads2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainThread {
    public static void main(String[] args) {
        try {
            ReadingFileByThreads obj = new ReadingFileByThreads();

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        HashMap<String,Integer> wordCount = obj.readingFile();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.readingFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            thread1.start();
            thread2.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

     static void sumMethod(HashMap<String, Integer> wordCount) {

     }
}

class ReadingFileByThreads {
    ArrayList<String> lines = new ArrayList<>();
    BufferedReader bufferedReader = null;
    ReadingFileByThreads(){
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Ravi\\Documents\\textFile.txt"));
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
    HashMap<String,Integer> readingFile() throws IOException {
        HashMap<String,Integer> resultMap = new HashMap<>();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }catch(IOException ex){
            ex.printStackTrace();;
        }finally {
            bufferedReader.close();
        }
        return resultMap;
    }
}

