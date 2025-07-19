public class Palindrome {

    //Task2
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> trans = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            trans.addLast(word.charAt(i));
        }
        return trans;
    }

    //Task3
    private boolean isPalindromeHelper(String word, int index) {
        Deque<Character> dequeWord = wordToDeque(word.substring(index, word.length() - index));

        if (dequeWord.isEmpty() || dequeWord.size() == 1) {
            return true;
        }

        if (dequeWord.removeFirst() == dequeWord.removeLast() && index <= word.length() / 2) {
            return isPalindromeHelper(word, index + 1);
        }

        return false;
    }

    public boolean isPalindrome(String word) {
        return isPalindromeHelper(word, 0);
    }

    //Task4
    private boolean isPalindromeHelper(String word,
                                       int index, CharacterComparator cc) {
        Deque<Character> dequeWord = wordToDeque(word.substring(index, word.length() - index));

        if (dequeWord.isEmpty() || dequeWord.size() == 1) {
            return true;
        }

        if (cc.equalChars(dequeWord.removeFirst(), dequeWord.removeLast())
                && index <= word.length() / 2) {
            return isPalindromeHelper(word, index + 1, cc);
        }

        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper(word, 0, cc);
    }


}
