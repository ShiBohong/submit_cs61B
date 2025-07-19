import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created
    your CharacterComparator interface and OffByOne class. **/

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void offByOneTest() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
    }

    @Test
    public void offByOneTest2() {
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
    }

    @Test
    public void offByOneTest3() {
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars(' ', '/'));
    }


}
