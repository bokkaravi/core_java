package DataStructures.linkedlist;



public class Linkedlist {
    Node head;
    Node tail;
    int size;
    Linkedlist(){
        size = 0;
    }

    private class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
        Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    void insertFst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int value){
        if(tail == null){
            insertFst(value);
            return;
        }

        Node node = new Node(value);
        tail = node;
        tail.next = null;
        size ++;

    }

    public void insertAtPosition(int val,int position){
        if(position == 0){
            insertFst(val);
            return;
        }
        if(position == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i = 1;i< position;i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;

    }

    public int deleteFst(){
           int deleteVal = head.value;
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
        return deleteVal;
    }

    public int deleteLast(){
        if (size <= 1) {
            return deleteFst();
        }
        int val = tail.value;
        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    // get the node by given position
    public Node get(int position){
        Node temp = head;
        for(int i = 0;i < position;i++){
            temp = temp.next;
        }
        return temp;

    }

    public int deleteAtPosition(int position){
        if(position == 0){
            return deleteFst();
        }
        if(position == size - 1){
            return deleteLast();
        }
        Node previousNode = get(position-1);
        int deletedVal = previousNode.next.value;
        previousNode.next = previousNode.next.next;
        return deletedVal;
    }

    public Node find(int value){
        Node tmp = head;
        while(tmp != null){
            if(tmp.value == value){
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void displayLL(){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.value+" -> ");
            tmp = tmp.next;
        }
        System.out.print("END");
    }
}

