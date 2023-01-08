import java.lang.reflect.Constructor;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String dept;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Employee() {

    }

    public static void main(String[] args)  {
        try {
            Constructor<Employee> constructor = Employee.class.getDeclaredConstructor();
            Employee emp1 = constructor.newInstance();

            emp1.setName("RituRaj ");
            emp1.setId(1063);
            emp1.setDept("principle s/w");
            emp1.setSalary(4000000);

            Employee emp2 = constructor.newInstance();
            emp2.setName("Ravi");
            emp2.setId(1060);
            emp2.setDept("s/w");
            emp2.setSalary(1100000);

            Employee emp3 = constructor.newInstance();
            emp3.setName("prasanna");
            emp3.setId(1059);
            emp3.setDept("s/w");
            emp3.setSalary(1300000);

            System.out.println(emp1.getName()+"  "+emp1.getId()+" "+emp1.getDept()+" "+emp1.getSalary());
            System.out.println(emp2.getName()+"  "+emp2.getId()+" "+emp2.getDept()+" "+emp2.getSalary());
            System.out.println(emp3.getName()+"  "+emp3.getId()+" "+emp3.getDept()+" "+emp3.getSalary());






        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
