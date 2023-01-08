package threads;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


class ReadAndWriteFile {
        File file = null;
        FileInputStream inputStream = null;
        String fileData;
        List<String> data = new ArrayList<>();
        FileWriter writer = null;
        ReadAndWriteFile() throws FileNotFoundException {
            try{
                file = new File("C:\\Users\\Ravi\\Documents\\textFile.txt");
                inputStream = new FileInputStream(file);
                writer = new FileWriter("C:\\Users\\Ravi\\Documents\\output.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        synchronized void readAndWrite() throws IOException {
            try {
                byte[] chunk = new byte[(int) file.length() / 2];
                int chunkLen = 0;
                while ((chunkLen = inputStream.read(chunk)) != -1) {
                    fileData = new String(chunk, StandardCharsets.UTF_8);
                    writer.write(fileData);
                }
            }catch(IOException exception){
                exception.printStackTrace();
            }finally {
                writer.close();
            }
        }
}
