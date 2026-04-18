class ListNode {
    int val;
    ListNode next;

    // Construcrtor that sets 'next' to null by default
    public ListNode(int val) {
        this(val, null);
    }

    // Constructor that accepts both value and next node
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;

    // Constructor
    public LinkedList() {
        // Init the list with a dummy node
        // This is to remove a node from the beginning of list easier.
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        ListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            if (curr == null) {
                return -1;
            }
            curr = curr.next;
        }

        if (curr == null ){
            return -1;
        }
        return curr.val;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        if (index < 0) {
            return false;
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            if (curr == null) {
                return false;
            }
            curr = curr.next;
        }
        
        // Remove the node ahead of curr
        if (curr != null && curr.next != null) {
            if (curr.next == this.tail){
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = this.head.next;
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}