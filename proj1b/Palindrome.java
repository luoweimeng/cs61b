public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
//        for (int i = 0; i < word.length(); i++) {
//            res.addLast(word.charAt(i));
//        }
        for (char c : word.toCharArray()) {
            res.addLast(c);
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}