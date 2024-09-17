 class Node {
  int data;
  Node next;
  Node prev;

  Node() {
      this.data = 0;
      this.next = null;
      this.prev = null;
  }

  Node(int data) {
      this.data = data;
      this.next = null;
      this.prev = null;
  }

  Node(int data, Node next, Node prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
  }
}

// Deleting the Head of Doubly LL

private static Node deleteHead(Node head){
    if(head == null || head.next == null) return null;
    Node prevHead = head;
    head = head.next;
    head.prev = null;
    prevHead.next = null;
    return head;
}

// deleting tail of Doubly LL 

private static Node deleteTail(Node head){
    if(head == null || head.next == null) return null;
    Node currTail = head; // goes till last element
    while(currTail.next != null){
      currTail = currTail.next;
    }
    Node newTail = currTail.prev; // new tail 
    currTail.prev = null;
    newTail.next = null;
    return head;
  }

// delete node at position pos

static Node deleteNode(Node head, int pos) {
        if (head == null) return null;

        Node currHead = head;
        int count = 0;

        while (currHead != null && count < pos) {
            currHead = currHead.next;
            count++;
        }

        if (currHead == null) {
            return head;
        }

        Node prevNode = currHead.prev;
        Node nextNode = currHead.next;

        if (prevNode == null) { // removing head
            head = nextNode;
            if (head != null) {
                head.prev = null;
            }
        } else { // removing pos or tail
            prevNode.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }
        }

        currHead.next = null;
        currHead.prev = null;

        return head;
    }
