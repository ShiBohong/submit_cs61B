import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    OffByOne obo = new OffByOne();

    @Test
    public void OffByOneTest(){
        assertTrue(obo.equalChars('a','b'));
        assertTrue(obo.equalChars('r', 'q'));
    }

    @Test
    public void OffByOneTest2(){
        assertFalse(obo.equalChars('a', 'e'));
        assertFalse(obo.equalChars('z', 'a'));
        assertFalse(obo.equalChars('a', 'a'));
    }

    @Test
    public void OffByOneTest3(){
        assertTrue(obo.equalChars('&', '%'));
        assertFalse(obo.equalChars('a', 'A'));
        assertFalse(obo.equalChars(' ', '/'));
    }


}
