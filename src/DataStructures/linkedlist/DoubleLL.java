package DataStructures.linkedlist;

class DLL {

    Node head;
    Node tail;
    int size;

    public DLL(){
        size = 0;
    }

    private class Node {
        private Node next;
        private Node previous;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node next, Node previous, int value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    }

    public void insertFst(int value){
        Node node = new Node(value);
        node.next = head;
        node.previous = null;
        if(head != null){
            head.previous = node;
        }
        head = node;

        if(tail == null){
            tail = head;
        }
    }

    public void insertLast(int value){
        if(head == null){
            insertFst(value);
            return;
        }
        Node node = new Node(value);
        node.next = null;
        node.previous = tail;
        tail.next = node;
        tail = node;
    }

    public void insertAfterThePerticularValue(int afterVal,int val){
        Node previousNode = getNode(afterVal);
        if(previousNode == null){
            System.out.println("node doesn't exist");
            return;
        }

        Node node = new Node(val);

        node.previous = previousNode;
        node.next = previousNode.next;
        previousNode.next = node;

        if(node.next != null){
            node.next.previous = node;
        }


    }

    public Node getNode(int val){
        Node temp = head;
        if(temp == null){
            return null;
        }
        while(temp != null){
            if(temp.value == val){
                return temp;
            }
            temp = temp.next;
        }
        return null
                ;

    }

    public void display(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.value+" -> ");
            tmp = tmp.next;
        }
        System.out.print("END");
        System.out.println();

    }

    public void displayReverse(){
        Node tmp = head;
        Node last = null;
        // coming to last node
        while(tmp != null){
           last = tmp;
           tmp = tmp.next;
        }

        while(last != null){
            System.out.print(last.value+" -> ");
            last = last.previous;
        }
        System.out.print("START");
        System.out.println();

    }

}

public class DoubleLL {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFst(5);
        list.insertFst(6);
        list.insertFst(7);
        list.insertFst(8);

        list.display();
        list.displayReverse();

        list.insertLast(100);
        list.display();

        list.insertAfterThePerticularValue(7,9999);
        list.display();
    }
}