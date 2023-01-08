import java.io.*;
import java.util.*;

public class Assignemnt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("C:\\Users\\Ravi\\Documents\\assignment.txt");
            bufferedReader = new BufferedReader(new FileReader(file));
            System.out.println(bufferedReader.lines());
            ArrayList<String> lineOfStrings = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lineOfStrings.add(line);
            }
            HashMap<String,Integer> map = new HashMap<>();

            lineOfStrings.forEach(lineOfwords -> {
                String[] arraysOfStrings =  lineOfwords.split(" ");
                List<String> listOfwords = Arrays.asList(arraysOfStrings);
                listOfwords.forEach(word -> {
                    if (map.containsKey(word)) {
                        map.put(word,map.get(word) + 1);
                    }else{
                        map.put(word,1);
                    }
                });
            });
            System.out.println(map);
        } catch (FileNotFoundException  e) {
            e.printStackTrace();
        }finally {
            bufferedReader.close();
        }
    }
}


//            for(String lineOfwords : lineOfStrings){
//                String[] arraysOfStrings =  lineOfwords.split(" ");
//                for(String word : arraysOfStrings){
//                    if (map.containsKey(word)) {
//                        map.put(word,map.get(word) + 1);
//                    }else{
//                        map.put(word,1);
//                    }
//                }
//            }