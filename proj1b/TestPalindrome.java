import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome(){

        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("aaaaaaaAa"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("raceecar"));
    }
    @Test
    public void testIsPalindromeNew(){
        OffByOne offByOne=new OffByOne();
        assertTrue(palindrome.isPalindrome("",offByOne));
        assertTrue(palindrome.isPalindrome("a",offByOne));
        assertTrue(palindrome.isPalindrome("flake",offByOne));
        assertTrue(palindrome.isPalindrome("%&",offByOne));
        assertFalse(palindrome.isPalindrome("flakE",offByOne));
        assertFalse(palindrome.isPalindrome("raceecar",offByOne));

        OffByN offByN=new OffByN(5);

        assertTrue(palindrome.isPalindrome("fafa",offByN));
        assertFalse(palindrome.isPalindrome("faaf",offByN));
    }
}
