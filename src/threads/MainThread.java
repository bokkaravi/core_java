package threads;
import java.io.*;

public class MainThread {
    public static void main(String[] args) {
        try {
            ReadAndWriteFile obj = new ReadAndWriteFile();

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.readAndWrite();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        obj.readAndWrite();
                    } catch (IOException e) {
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
}


