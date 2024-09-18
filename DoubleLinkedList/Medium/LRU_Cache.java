class LRUCache {
    /*
    
    // keep track of least recently used nodes, recently used -> moves to front 
    // deletes LRU if a new cache is to be added and sized is maximized(new cache added at front)
    // if a cache is inserted and has the same key value , update prev value with new value

    */
    class Node{
        Node next;
        Node prev;
        int key;
        int value;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    final int capacity;
    final Node head;
    final Node tail;
    final HashMap<Integer,Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity); // create new hashmap<int , node> of size == capacity
        head = new Node(-1,-1); // dummy head 
        tail = new Node(-1,-1); // dummy tail
        head.next = tail;
        tail.prev = head;
    }   
    
    // move new Node right after head;
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        insertToFront(node); // remove currently called node and inset it to front
        return node.value;
    }
    
    // insert new Node right after head;
    // if capacity is full and new node is inserted , delete LRU (tail.prev) node and create a new node
    public void put(int key, int value) {
       
        if(cache.containsKey(key)) remove(cache.get(key));

        if(cache.size() == capacity) remove(tail.prev);

        Node node = new Node(key,value);
        insertToFront(node);
    }

  // removes the curr node from the hashmap and updates the linkedlist
    void remove(Node node){
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

// inserts new node to the front of the Linked List 
    void insertToFront(Node node){
        cache.put(node.key , node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

