public class LinkedListDeque<T> {
    private ListNode sentinel;
    private int size;

    public class ListNode {
        public T item;
        public ListNode prev;
        public ListNode next;

        public ListNode() {
            this.item = null;

        }
        public ListNode(T i, ListNode prev, ListNode next) {
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

    public void addFirst(T item) {
        ListNode newNode  = new ListNode(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        ListNode newNode  = new ListNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public void printDeque() {
        ListNode ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.println(ptr.item);
            ptr = ptr.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty())
            return null;

        T toRemove = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return toRemove;

    }

    public T removeLast() {
        if (this.isEmpty())
            return null;

        T toRemove = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return toRemove;
    }

    public T get(int index) {
        ListNode ptr = sentinel.next;
        while (index != 0) {
            ptr = ptr.next;
            index--;
        }
        return ptr.item;
    }
}
