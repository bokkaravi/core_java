package DataStructures.linkedlist;

public class CLL {
    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.display();
        list.delete(6);
        list.display();
    }


}

class CircularLL {
    Node head;
    Node tail;

    public CircularLL() {
        this.head = null;
        this.tail = null;
    }
    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }
    public void display(){
        Node node = head;
        if(head != null){
            do {
                System.out.print(node.val+" -> ");
                if(node.next != null)
                    node = node.next;
            }while(node != head);
            System.out.print("HEAD");
        }
        System.out.println();
    }

    public void delete(int val){
        Node node = head;
        if(node == null){
            return;
        }
        do {
            Node node1 = node.next;
            if(node1.val == val){
                node.next = node1.next;
                break;
            }
            node = node.next;
        }while(node != null);

    }
}
