public class LinkedListDeque<Item> implements Deque<Item> {
    private ListNode sentinel;
    private int size;

    public class ListNode {
        public Item item;
        public ListNode prev;
        public ListNode next;

        public ListNode() {
            this.item = null;

        }
        public ListNode(Item i, ListNode prev, ListNode next) {
            this.item = i;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        sentinel = new ListNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public void addFirst(Item item) {
        ListNode newNode  = new ListNode(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(Item item) {
        ListNode newNode  = new ListNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        ListNode ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.println(ptr.item);
            ptr = ptr.next;
        }
    }

    @Override
    public Item removeFirst() {
        if (this.isEmpty())
            return null;

        Item toRemove = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return toRemove;

    }

    @Override
    public Item removeLast() {
        if (this.isEmpty())
            return null;

        Item toRemove = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return toRemove;
    }

    @Override
    public Item get(int index) {
        ListNode ptr = sentinel.next;
        while (index != 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr.item;
    }
}