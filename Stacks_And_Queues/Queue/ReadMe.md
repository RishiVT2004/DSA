## Queue 

follows an fifo operartion instead of lifo used in stack
 
### Methods 
1. Enque -> Add
2. Dequeue -> Remove
3. Front -> Peek

front -> index 0
rear -> last index
initally front,rear = -1 => empty queue

## Queue using Arrays 

Not implemented usually as arrays have fixed size<br>
add/peak -> O(1)
remove -> O(n)


public class queue {
```
    @SuppressWarnings("unused")
    static class newQueue{
        static int[] arr;
        static int size;
        static int rear = -1;

        newQueue(int size){
            this.size = size;
            arr = new int[size];
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        public static void add(int data){ // enqueue
            if(rear == size - 1){
               System.out.println("full queue"); // full queue
            }else{
                rear++;
                arr[rear] = data;
            }
        }

        public static int remove(){
            if(isEmpty()) return -1;
            int front = arr[0]; // store initial front here
            
            for(int i = 0;i<rear;i++){ // update the queue by pushing 1 element forward
                arr[i] = arr[i+1];
            }
            rear--; // update rear
            return front;
        }

        public static int peek(){
            if(isEmpty()) return -1;
            return arr[0];
        }
        
    }
    public static void main(String[] args) {
        newQueue Q = new newQueue(10);
        System.out.println(Q.isEmpty());
        Q.add(1);
        System.out.println(Q.remove());
        System.out.println(Q.isEmpty());
        Q.add(2);
        System.out.println(Q.peek());
    }
  }
```

## Circular Queue using Arrays 

 to update rear -> rear = (rear+1)%size
 if (rear+1)%size == front -> queue is filled 


```

public class queue {

    @SuppressWarnings("unused")
    static class newQueue{
        static int[] arr;
        static int size;
        static int rear = -1;
        static int front = -1;

        newQueue(int size){
            this.size = size;
            arr = new int[size];
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        public static void add(int data){ // enqueue
            if(isFull()){
               System.out.println("full queue"); // full queue
            }else{
                rear = (rear+1)%size;
                if(front == -1){
                    front++;
                } 
                arr[rear] = data;
            }
        }

        public static int remove(){
            if(isEmpty()) return -1;
            int result = arr[front]; // store initial front here
            if(rear == front){ // single element
                rear = -1;
                front = -1;
            }else{
                front = (front+1)%size; // increase front 
            }
            
            return result;
        }

        public static int peek(){
            if(isEmpty()) return -1;
            return arr[front];
        }
        
    }
    public static void main(String[] args) {
        newQueue Q = new newQueue(3);
        Q.add(10);
        Q.add(20);
        Q.add(30);

        Q.remove();
        Q.add(40);
        
        while(!Q.isEmpty()){
            System.out.println(Q.peek());
            Q.remove();
        }
        // new queue => 20 -> 30 -> 40 
    }
}


```

## Queue using LinkedLists
