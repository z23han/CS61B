package list;

public class Test {
    
    public static void main(String[] args) {
        DList list = new LockDList();
        list.insertFront(1);
        list.insertFront(10);
        list.insertBack(5);
        System.out.println(list.front().item);
        System.out.println(list.back().item);
        System.out.println(list.toString());
        
        DListNode firstNode = list.front();
        list.insertAfter(3, firstNode);
        DListNode lastNode = list.back();
        list.insertBefore(11, lastNode);
        System.out.println(list.toString());
        list.front().item = 100;
        System.out.println(list.toString());

        list.remove(firstNode.next);
        System.out.println(list.toString());
        
        //LockDList listWithLock = (LockDList)list;
        ((LockDList)list).lockNode(list.front());
        //listWithLock.lockNode(list.front());
        //System.out.println(listWithLock.toString());
    }
}

