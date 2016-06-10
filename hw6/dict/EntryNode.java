package dict;

public class EntryNode {
    
    protected Object value;
    protected EntryNode next;
    
    public EntryNode() {
        value = null;
        next = null;
    }
    
    public Object value() {
        return value;
    }
    
    public EntryNode insertAfter(Object value) {
        
        EntryNode new_node = new EntryNode();
        new_node.value = value;
        next = new_node;
        
        return new_node;
    }
    
    
}

