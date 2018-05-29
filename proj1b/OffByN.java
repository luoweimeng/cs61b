public class OffByN implements CharacterComparator {
    //the difference between x and y
    private int diff;
    public OffByN(int N) {
        this.diff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == this.diff || y - x == this.diff;
    }

}
