public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int reservedSize;
    private int frontPointer;
    private int endPointer;


    private int RESIZE_FACTOR = 2;
    private double USAGE_FACTOR = 0.25;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
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


    /* Resize the array list.
    * 0 1 2 3 4 5 6 7
    *   e     s      */

    private void resize(int newSize, String flag) {
        Item[] newItems = (Item[]) new Object[newSize];
        if (flag.equals("increase")) {
            int startIndex = nextIndex(frontPointer);
            //copy array from startPointer to the end
            int firstLen = this.size - 1 - startIndex + 1;
            System.arraycopy(this.items, startIndex, newItems, 1, firstLen);
            //copy array from 0 to endPointer
            int secondLen = this.endPointer;
            System.arraycopy(this.items, 0, newItems, firstLen + 1, secondLen);
        }
        else if (flag.equals("decrease")) {
            System.arraycopy(this.items, 1, newItems, 1, this.size);
        }

        this.items = newItems;
        this.reservedSize = newSize;
        this.frontPointer = 0;
        this.endPointer = this.size + 1;
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
        int ptr = nextIndex(this.frontPointer);
        int i = 0;
        while (i < this.size) {
            System.out.print(items[ptr] + " ");
            ptr = nextIndex(ptr);
            i++;
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

    private void maintainUsagefactor() {
        if (this.reservedSize >= 16) {
            if ((double)this.size / this.reservedSize < this.USAGE_FACTOR) {
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
