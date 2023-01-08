import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import java.io.*;
public class NewThreadExample {
    public static void main(String[] args) {
        try {
            List<String> listOfStrings = new ArrayList<String>();
            listOfStrings = Files.readAllLines(Paths.get("C:\\Users\\Ravi\\Documents\\file.txt"));
            int halfsize = listOfStrings.size() / 2;
            ReadWriteClass obj = new ReadWriteClass();
            List<String> finalListOfStrings = listOfStrings;



            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    obj.firstHalfFile(finalListOfStrings,halfsize);
                }
            });


            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    obj.secondHalfFile();
                }
            });
            thread1.start();
            thread2.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ReadWriteClass {
    void firstHalfFile(List<String> listOfStrings,int size){
        for (String string : listOfStrings){
            System.out.println(string);
        }

    }

    void secondHalfFile(){

    }

    void writeFile(){

    }
}