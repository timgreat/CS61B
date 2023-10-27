public class OffByN implements CharacterComparator{
    private int N;
    public OffByN(int N){
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff = y-x;
        if(Math.abs(diff)==N) return true;
        return false;
    }
}
