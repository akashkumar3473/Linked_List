package Linked_List_1;

class SLL{ // user defined data structure
    private Node head;
    Node tail;
    private int size;
    // insert at tail
    void insertAtTail(int val){
        Node temp = new Node(val);
        if(head==null) head = tail = temp;
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    // inset at head
    void insertAtHead(int val){
        Node temp = new Node(val);
        if(head==null) head = tail = temp;
        else{
            temp.next = head;
            head = temp;
        }
        size++;
    }
    // insert method
    void insert(int idx, int val){
        if(idx==0){
            insertAtHead(val);
            return;
        }
        if(idx==size){
            insertAtTail(val);
            return;
        }
        if(idx>size || idx<0){
            System.out.println("Invalid Index");
            return;
        }
        Node temp = new Node(val);
        Node x = head;
        for(int i=1;i<=idx-1;i++){
            x = x.next;
        }
        //insertion
        temp.next = x.next;
        x.next = temp;
        size++;
    }
    // get element method
    int get(int idx) throws Error{
        if(idx==size-1) return tail.val;
        if(idx>=size || idx<0){
            throw new Error("Hi error");
        }
        Node temp = head;
        for(int i=1;i<=idx;i++){
            temp = temp.next;
        }
        return temp.val;
    }
    // set element method
    void set(int idx, int val) throws Error{
        if(idx==size-1) {
            tail.val = val;
        }
        if(idx>=size || idx<0){
            throw new Error("Hi error");
        }
        Node temp = head;
        for(int i=1;i<=idx;i++){
            temp = temp.next;
        }
        temp.val = val;
    }
    // delete at head
    void deleteAtHead() throws Error{
        if(head==null) throw new Error("List is Empty");
        head = head.next;
        size--;
    }
    // delete at tail
    void delete(int idx) throws Error{
        if(idx==0){
            deleteAtHead();
            return;
        }
        if(idx<0 || idx>=size)
            throw new Error("Invalid Index");
        Node temp = head;
        for(int i=1;i<=idx-1;i++){
            temp = temp.next;
        }
        if(temp.next==tail) tail = temp; // check tail
        temp.next = temp.next.next;
        size--;
    }
    // display
    void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    // size
    void size(){
        System.out.println("size : " + size);
    }
}
public class implementationLL {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.size();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.display();

        list.insertAtTail(40);
        list.display();

        list.insertAtHead(50);
        list.display();
        list.insert(4,80);
        list.display();
        list.insert(10,23);
        list.display();

        System.out.println(list.get(3));
        //System.out.println(list.get(-1));
        list.display();
        list.set(2,90);
        list.display();

        list.deleteAtHead();
        list.display();
        list.size();

        list.delete(2);
        list.display();
        list.size();

        list.delete(3);
        list.display();
        list.size();
        System.out.println(list.tail.val);


    }
}
