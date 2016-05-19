package list;

public class LockDList extends DList {
    
    public void lockNode(DListNode node) {
        ((LockDListNode)node).isLocked = true;
    }
    
    protected DListNode newNode(Object item, DListNode prev, DListNode next) {
        return new LockDListNode(item, prev, next);
    }
    
    public void remove(DListNode node) {
        
        if (node == null) {
            return;
        }
        
        System.out.println(node.item.toString());
        System.out.println(((LockDListNode)node).isLocked);
        
        if (((LockDListNode)node).isLocked) {
            return;
        } else {
            super.remove(node);
        }
    }
}
