class University {
    static class Department {
        void display(){
            System.out.println("instance method inside static class !!! ");
        }
        static void show(){
            System.out.println("static method insode static class !!! ");
        }
    }
}

class innerClassDemo {
    public static void main(String[] args) {
        University.Department cse = new University.Department();
        cse.show();// or one more way also we can call show method bcz it is static
        University.Department.show();// we can call show method directly by department obj bcz it is static
        cse.display();
    }
}
