import java.util.Arrays;
import java.util.List;

interface LambdaExpressions {
//    lambda expressions

}

interface functionalInterface {
    void abstractFun(int x);
}
class Java8features {
    public static void main(String[] args) {
        functionalInterface lambda = (num) -> {
            System.out.println(num);
        };
        lambda.abstractFun(5);

    try {
        List<Integer> al = Arrays.asList(1, 2, 4, 6, 3);
        al.forEach(num -> System.out.println(num));
    }catch (NullPointerException e){
        e.printStackTrace();
    }
    }
}

// zero,one ,two and multiple parameterized functional interface

interface zerofunc {
    boolean zero();
}
interface functionalintr1{
    int add(int x , int y);
}
interface  func2 {
    int multiply(int x,int y);
}
interface func3 {
    String msg(String m);
}

class Test {
    public static void main(String[] args) {


//        zerofunc fob = ()->{
//            System.out.println("it is zero parameter functional interface !!!");
//        };

//        System.out.println(fob.zero());

        functionalintr1 fobj = (x,y) -> {
            return x+y;
        };

        System.out.println(fobj.add(7,8));

        func2 fobj2 = (x,y) -> {
            return x*y;
        };

        System.out.println(fobj2.multiply(10,20));

        func3 fobj3 = (msg) -> {
           return msg;
        };

        System.out.println(fobj3.msg("hai !!! "));



    }
}


interface functionalInter {
    void say();
}

class Test1 {
    public static void main(String[] args){

        functionalInter fob = Test1::saySomething;
        fob.say();
    }

    static void saySomething(){
        System.out.println("static method !!!");
    }
}