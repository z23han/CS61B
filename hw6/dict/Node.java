package dict;

public class Node {
    protected EntryNode pointer;
    
    public Node() {
        pointer = new EntryNode();
    }
    
    public EntryNode pointer() {
        return pointer;
    }
}


