/*
 * node defined to hold the run-length encoding colors
 * */

public class Node {
    
    public int[] color;
    public Node prev;
    public Node next;
    
    public Node() {
        prev = null;
        next = null;
        
        color = new int[4];
        color[0] = 0;
        color[1] = 0;
        color[2] = 0;
        color[3] = 0;
    }
    
    public Node(int red, int green, int blue, int length) {
        color = new int[4];
        color[0] = red;
        color[1] = green;
        color[2] = blue;
        color[3] = length;
        
        prev = null;
        next = null;
    }
    
}
