import java.util.HashMap;
import java.util.Map;

public class SwitchExample {
    public static void main(String[] args) {
        String line = "my name is ravi and what is your name ?";
        // finding vowels using switch case
        int count = 0;
        for(int index = 0;index < line.length();index++){
            char ch = line.charAt(index);
            switch(ch){
                case 'a' :
                    count++;
                    break;
                case 'e' :
                    count++;
                    break;
                case 'i':
                    count++;
                    break;
                case 'o':
                    count++;
                    break;
                case 'u':
                    count++;
                    break;
                default:
            }
        }
        System.out.println(count);

    }
}

class Book {
    int id;String name;
    Book(int id,String name){
        this.id = id;
        this.name = name;
    }
}
class Test2 {
    public static void main(String[] args) {
        Book b1 = new Book(1,"DS&algo");
        Book b2 = new Book(2,"core Java");

        HashMap<Integer,Book> map = new HashMap<>();

        map.put(1,b1);
        map.put(2,b2);
        for(Map.Entry<Integer,Book> entry : map.entrySet()){
           Book book = entry.getValue();
            System.out.println(book.id+" "+book.name);
        }

    }
}
