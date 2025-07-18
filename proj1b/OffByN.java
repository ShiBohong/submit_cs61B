public class OffByN implements CharacterComparator{

    private int para;

    public OffByN(int N){
        para=N;
    }

    @Override
    public boolean equalChars(char x, char y){
        int diff=x-y;
        if(diff==para||diff==-para){
            return true;
        }
        return false;
    }
}
