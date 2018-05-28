public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int reservedSize;
    private int frontPointer;
    private int endPointer;


    private int RESIZE_FACTOR = 2;
    private double USAGE_FACTOR = 0.25;

    public ArrayDeque() {
        items = (Item[]) new Object();
        size = 0;
        reservedSize = 8;
        frontPointer = 0;
        endPointer = 1;
    }

    private int prevIndex(int index) {
        int prevIdx = index - 1;
        if (prevIdx < 0)
            prevIdx += this.reservedSize;
        return prevIdx;
    }

    private int nextIndex(int index) {
        int nextIdx = index + 1;
        if (nextIdx == this.reservedSize)
            nextIdx -= this.reservedSize;
        return nextIdx;
    }

    /* Judge whether the array list is full */
    private boolean isfull() {
        return this.reservedSize == this.size;
    }

    /* Resize the arrah list. */
    public void resize(int newSize, String flag) {

    }

    public void addFirst(Item item) {
        if (isfull()) {
            int newSize = this.reservedSize * RESIZE_FACTOR;
            resize(newSize, "increase");
        }

        this.items[this.frontPointer] = item;
        this.frontPointer = prevIndex(frontPointer);
        this.size++;
    }

    public void addLast(Item item) {
        if (isfull()) {
            int newSize = this.reservedSize * RESIZE_FACTOR;
            resize(newSize, "increase");
        }

        this.items[this.endPointer] = item;
        this.endPointer = nextIndex(endPointer);
        this.size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int ptr = nextIndex(frontPointer);
        while (size-- > 0) {
            System.out.print(items[ptr] + " ");
            ptr = nextIndex(ptr);
        }
    }

    public Item removeFirst() {
        Item first = get(0);
        
        this.set(0, null);
        this.frontPointer = nextIndex(frontPointer);
        this.size--;
        maintainUsagefactor();

        return first;
    }

    public Item removeLast() {
        Item last = get(this.size - 1);

        this.set(this.size - 1, null);
        this.endPointer = prevIndex(endPointer);
        this.size--;
        maintainUsagefactor();

        return last;
    }

    public void maintainUsagefactor() {
        if (this.reservedSize >= 16) {
            if (double(this.size) / this.reservedSize < this.USAGE_FACTOR) {
                int newSize = this.reservedSize / this.RESIZE_FACTOR;
                this.resize(newSize, "decrease");
            }
        }
    }

    public Item get(int index) {
        return this.items[this.getTrueIndex(index)];
    }

    private int getTrueIndex(int index) {
        return (this.frontPointer + 1 + index) % this.reservedSize;
    }

    private void set(int index, Item item) {
        this.items[this.getTrueIndex(index)] = item;
    }

}
