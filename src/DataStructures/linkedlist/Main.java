package DataStructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.insertFst(5);
        list.insertFst(6);
        list.insertFst(7);
        list.insertFst(8);

        list.insertAtPosition(99,2);

        list.insertLast(10);

//        System.out.println("deleted value from list :: "+list.deleteFst());

        System.out.println("delete last ele :: "+ list.deleteLast());

        list.displayLL();
        System.out.println();

        System.out.println("deleted at given position :: "+list.deleteAtPosition(2));

        list.displayLL();

    }

}

