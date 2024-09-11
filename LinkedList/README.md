# LinkedLists

## About LinkedList 
A Linked List is a linear data structure where elements (called nodes) are stored in a sequence, but unlike arrays, they are not stored in contiguous memory locations
(stored in heap memory location). 
Each node contains two parts:
  1. Data: The value or information stored in the node.
  2. Next Pointer: A reference or pointer to the next node in the list.

A basic representation of a Linked List node looks like this:

    class Node {
      int data;
      Node next;
      
      Node(int data) {
        this.data = data;
        this.next = null;
        }

        Node(int new_data,Node new_next){
          this.data = new_data;
          this.next = new_next;
        }
    }

    class LL {
      psvm(){
        int[] a = {1,2,3,4}
        // to create a new node with value 1
        
        Node newNode = new Node(arr[0]);
        // sysout(newNode.data);
        
      }
    }

** The head of the linked list points to the first node, and the list ends when the next pointer of a node is null(known as tail of linkedlist).

## Types Of LinkedLists -:

1. Singly Linked List: Each node points to the next node.
2. Doubly Linked List: Each node contains a pointer to both the next and previous nodes.
3. Circular Linked List: The last node points back to the first node, forming a loop.

## LinkedLists Vs Arrays

1. Dynamic Size:

   Array: Arrays have a fixed size. Once declared, their size cannot be changed without creating a new array.
   Linked List: The size of a linked list is dynamic. Nodes can be added or removed at any time without resizing or c
   opying the entire list.

   This ensures minimal wastage of memory 

2. Efficient Insertions and Deletions:

    Array: Inserting or deleting an element in an array requires shifting elements to maintain the order, which takes O(n) time.
    Linked List: Inserting or deleting a node in a linked list can be done in O(1) time if you have a
    reference to the node to be added/removed.

 ####  LinkedList is primarily used in stack and queue implementation , also used in browser searching (2-d linkedlists)
 #### We store the data and the pointer to the next location(Node , a self defined data-type) in a linked list.

## LinkedList Methods

### Converting an array to LinkedList (and Returning its head) , O(N)
#### ** temp is always of type Node 

    class Node {
      int data;
      Node next;

      Node(int data) {
        this.data = data;
        this.next = null;
      }

      Node(int new_data,Node new_next){
      this.data = new_data;
      this.next = new_next;
      }
    }

    public class Main {
      static Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
          Node temp = new Node(arr[i]);
          mover.next = temp;
          mover = temp;
        }
      return head;
    }
  
    public static void main(String[] args) {
   
        int [] arr = {1,2,3,4};
        Node head = convertArrayToLL(arr);
        System.out.println(head.data);
      }
    }
#### * Mover points initially to current node and then is set to the newly created next node ,temp is the initial location where new node is created , also never change the head of LL

### Traversal In LinkedList O(N)

    class Node {
      int data;
      Node next;

      Node(int data) {
        this.data = data;
        this.next = null;
      }

      Node(int new_data,Node new_next){
      this.data = new_data;
      this.next = new_next;
      }
    }

    
    public class Main {
      static Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
          Node temp = new Node(arr[i]);
          mover.next = temp;
          mover = temp;
        }  
      return head;
    }  
  
    public static void main(String[] args) {
   
      int [] arr = {1,2,3,4};
      Node head = convertArrayToLL(arr);
      Node temp = head; // initally 
      while(temp!=null){
        System.out.println(temp.data + " ");
        temp = temp.next;
        }
     }
    }

### Length Of LinkedList -: O(N)

    class Node {
      int data;
      Node next;

    Node(int data) {
    this.data = data;
    this.next = null;
    }

    Node(int new_data,Node new_next){
      this.data = new_data;
      this.next = new_next;
      }
    }

    public class Main {
      static Node convertArrayToLL(int[] arr){ // not present in codeing rounds 
      Node head = new Node(arr[0]);
      Node mover = head;
      for(int i = 1; i < arr.length; i++){
        Node temp = new Node(arr[i]);
        mover.next = temp;
      mover = temp;
    }
    return head;
    }

    static int LengthOfLL(Node head){
      int count = 0;
      Node temp = head;
      while(temp != null){
        temp = temp.next;
        count++;
      }
      return count;
    }
  
    public static void main(String[] args) {
   
    int [] arr = {1,2,3,4};
    Node head = convertArrayToLL(arr);
    System.out.print(LengthOfLL(head));
      }
    }

### Search in A LinkedList O(N)

    class Node {
      int data;
      Node next;

    Node(int data) {
    this.data = data;
    this.next = null;
    }

    Node(int new_data,Node new_next){
      this.data = new_data;
      this.next = new_next;
      }
    }

    public class Solution {
      public static int searchInLinkedList(Node head, int k){        
        Node temp = head;
        while(temp != null){
            if(temp.data == k){
                return 1; // return true
            }
            temp = temp.next;
        }
        return 0; // return false
     }
    }

### ** Deletion Of Node in LL

#### Deletion of the head 

    class Node {
      int data;
      Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }

    Node(int new_data,Node new_next){
      this.data = new_data;
      this.next = new_next;
      }
    }
    public class Main {
      static Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
          Node temp = new Node(arr[i]);
          mover.next = temp;
          mover = temp;
        }  
      return head;
    }  

    //**
    static Node removeHead(Node head){
      if(head == null){
      return null;
    }
    return head.next;
     }

    public static void main(String[] args) {

    int [] arr = {1,2,3,4};
    Node head = convertArrayToLL(arr);
    System.out.println("Original Head : "+head.data);
    head = removeHead(head);
    System.out.println("New Head : "+head.data);
     }
    }

#### Deletion of tail 

     class Node {
      int data;
      Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }

    Node(int new_data,Node new_next){
      this.data = new_data;
      this.next = new_next;
    }
    }
    public class Main {
      static Node convertArrayToLL(int[] arr){
      Node head = new Node(arr[0]);
      Node mover = head;
        for(int i = 1; i < arr.length; i++){
        Node temp = new Node(arr[i]);
        mover.next = temp;
        mover = temp;
      }  
    return head;
    }  

    static Node removeTail(Node head){
    if(head == null || head.next == null){
      return null;
    } // size of LL is 0 or 1
    
    Node temp = head;
    while(temp.next.next != null){
      temp = temp.next;
    }
    temp.next = null;
    return head;
    }

    public static void main(String[] args) {

    int [] arr = {1,2,3,4};
    Node head = convertArrayToLL(arr);
    Node temp = head;
    while(temp!=null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    
    head = removeTail(head);
    Node newTemp = head;
    while(newTemp!=null){
      System.out.print(newTemp.data + " ");
        newTemp = newTemp.next;
      }
     }  
    }
#### Delete kth element/position of LinkedList O(k)

    public class Main {
      static Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
          Node temp = new Node(arr[i]);
          mover.next = temp;
        mover = temp;
      }  
    return head;
    }  
  
    static Node removePosition(Node head,int k){
      if(head==null) return head;

      if(k==1){ // deleting the head
        Node temp = head;
        head = head.next;
        return head;
      }

    // for a no k 
    int count = 0;
    Node temp = head;
    Node previous = null;
    while(temp!=null && count < k){
      previous = temp;
      count++;
      if(count == k){
        previous.next = previous.next.next;
        break;
      }
      temp = temp.next;
    }
    return head;
    }

    public static void main(String[] args) {

      int [] arr = {1,2,3,4};
      Node head = convertArrayToLL(arr);
    
      head = removePosition(head,1);
      Node newTemp = head;
      while(newTemp!=null){
        System.out.println(newTemp.data + " ");
        newTemp = newTemp.next;
    }
    }
    }

#### Delete a value of LinkedList O(k)

in the above code do the following changes 

     static Node removeValue(Node head,int value){
        if(head==null) return head;

    if(head.data == value){ ad
      Node temp = head;
      head = head.next;
      return head;
    }

    // for a no k 
    Node temp = head;
    Node previous = null;
    while(temp!=null){
      previous = temp;
      if(temp.data == value){
        previous.next = previous.next.next;
        return head;
      }
      temp = temp.next;
    }
    return head;
    }

### Insertion 

#### Inserting New Head -: O(1)


     static Node InsertHead(Node head , int val){
        return new Node(val,head);
      }
  
    public static void main(String[] args) {

    int [] arr = {1,2,3,4};
    Node head = convertArrayToLL(arr);
    
    head = InsertHead(head,100);
    
    Node newTemp = head;
    while(newTemp!=null){
      System.out.println(newTemp.data + " ");
        newTemp = newTemp.next;
      }
    }  

#### Inserting at the last/tail -: 

    static Node InsertTail(Node head , int val){
      Node temp = head;
      if(head == null) return new Node(val);
    
      while(temp.next != null){
        temp = temp.next;
      }
    // currently head is at last element 
    
      Node newNode = new Node(val);
      temp.next = newNode;
      return head;
    }
  
    public static void main(String[] args) {

    int [] arr = {1,2,3,4};
    Node head = convertArrayToLL(arr);
    
    //head = InsertHead(head,100);
    head = InsertTail(head,100);
    
    Node newTemp = head;
    while(newTemp!=null){
      System.out.println(newTemp.data + " ");
        newTemp = newTemp.next;
      }
    }


#### Inserting at a given position/element -: O(N) 

    static Node InsertAtAPosition(Node head ,int position, int val){
      Node temp = head;
      if(head == null) return new Node(val);

      if(position == 1){
         return new Node(val,head);
       }

      int count = 0;
      while(temp != null){
        count++;
        if(count == position-1){
          Node newNode = new Node(val);
          newNode.next = temp.next;
          temp.next = newNode;
          break;
        }
        temp =temp.next;
      }  
      return head;
    }
  
    public static void main(String[] args) {

    int [] arr = {1,2,3,4};
    Node head = convertArrayToLL(arr);
    
    head = InsertAtAPosition(head,1,100);
    
    Node newTemp = head;
    while(newTemp!=null){
      System.out.println(newTemp.data + " ");
        newTemp = newTemp.next;
      }
    }

#### Inserting an value before the value x 

    static Node InsertBeforeAValue(Node head ,int given_value, int val){
      Node temp = head;
      if(head == null) return null;

      if(head.data == given_value) return new Node(val,head);

      while(temp.next!=null){
        if(temp.next.data == given_value){
          Node newNode = new Node(val,temp.next);
          temp.next = newNode;
          break;
        }
      }
      return head;
    }
  
    public static void main(String[] args) {

    int [] arr = {1,2,3,4};
    Node head = convertArrayToLL(arr);
    
    head = InsertBeforeAValue(head,2,10); // insert 10 before 2 
    
    Node newTemp = head;
    while(newTemp!=null){
      System.out.println(newTemp.data + " ");
        newTemp = newTemp.next;
      }
    }
