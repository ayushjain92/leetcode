import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }


        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        hash.put(s.charAt(0), 0);

        int maxLength = 1;
        int curLength = 1;
        // pwwkelpew
        // p - 0, w - 1, max = 2, curr = 2
        // p - 0, w - 2, curr = 1,
        // p - 0, w - 2, k - 3, e - 4 , curr = 3,
        // p - 0, w - 2, k - 3, e - 4 , l - 5, curr = 4, i = 6

        // au
        // a - 0,
        for (int i = 1; i < s.length(); i++) {
            char currentLetter = s.charAt(i);

            if (!hash.containsKey(currentLetter)) {
                curLength++;
            } else {
                if (hash.get(currentLetter) < i - curLength) {
                    curLength++;
                } else {
                    maxLength = Math.max(maxLength, curLength);
                    curLength = i - hash.get(currentLetter);
                }
            }

            hash.put(currentLetter, i);
        }

        return Math.max(maxLength, curLength);
    }
}
