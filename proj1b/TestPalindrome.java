import static org.junit.Assert.*;

import org.junit.Test;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    OffByOne cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        //Cool tests written by myself!

        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));

    }

    @Test
    public void testIsPalindrome2() {
        //Cool tests written by myself!

        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("level"));

    }

    @Test
    public void testIsPalindrome3() {
        //Cool tests written by myself!

        assertFalse(palindrome.isPalindrome("marasy8"));
        assertFalse(palindrome.isPalindrome("animenz"));
        assertFalse(palindrome.isPalindrome("furina"));

    }

    @Test
    public void testIsPalindrome4() {
        //Cool tests written by myself!

        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("cattac"));

    }

    //Here we use Off-By-One to reload IsPalindrome Function!

    @Test
    public void testIsPalindromecc() {
        //Cool tests written by myself!

        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));

    }

    @Test
    public void testIsPalindromecc2() {
        //Cool tests written by myself!

        assertTrue(palindrome.isPalindrome("radecbs", cc));
        assertTrue(palindrome.isPalindrome("levdk", cc));

    }

    @Test
    public void testIsPalindromecc3() {
        //Cool tests written by myself!

        assertFalse(palindrome.isPalindrome("marasy8", cc));
        assertFalse(palindrome.isPalindrome("animenz", cc));
        assertFalse(palindrome.isPalindrome("furina", cc));

    }

    @Test
    public void testIsPalindromecc4() {
        //Cool tests written by myself!

        assertTrue(palindrome.isPalindrome("abcb", cc));
        assertTrue(palindrome.isPalindrome("catsbb", cc));

    }
}

