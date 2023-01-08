import java.io.*;


class EmployeeInfo implements  Serializable{
    String name;
    int id;

    public EmployeeInfo(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
class SerializationAndDeserialization
{
    public static void main(String[] args )
    {
        try {
            EmployeeInfo emp = new EmployeeInfo("ravi",1060);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Ravi\\Documents\\starting\\emp.txt"));
            out.writeObject(emp);
            out.flush();
            out.close();
            System.out.println("file got generated !!!! ");


            ObjectInputStream input = new ObjectInputStream(new FileInputStream("C:\\Users\\Ravi\\Documents\\starting\\emp.txt"));
            EmployeeInfo obj = (EmployeeInfo) input.readObject();

            System.out.println(obj.name+"  "+obj.id);


        }catch (Exception e){
            e.printStackTrace();
        }
        }
}

