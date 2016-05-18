/*
 * Doubly Linkedlist 
 * it is used for holding the information of colors and lengths
 *
 * */

public class DoublyLinkedList {
    
    public Node head;
    
    public DoublyLinkedList() {
        this.head = null;
    }
    
    public void insert(int red, int green, int blue, int length) {
        if (this.head == null) {
            this.head = new Node(red, green, blue, length);
            return;
        }
        
        Node curNode = this.head;
        
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        Node newNode = new Node(red, green, blue, length);
        curNode.next = newNode;
        newNode.prev = curNode;
        
        return;
    }
    
}

