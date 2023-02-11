import java.util.Arrays;

public class MinWindowSubstring {
        // s = aa
        // t = aa
        // o/p = "aa"

        // hasFound[] = {A-1, B-1, C-1},
        // needToFind[] = {a-1, b-1, c-1}


        public String minWindow(String s, String t) {

            int min = Integer.MAX_VALUE;
            int begin = 0;
            int globalBegin = -1;
            int count = 0;

            int[] needToFind = new int[256];
            int[] hasFound = new int[256];

            Arrays.fill(needToFind, 0);
            Arrays.fill(hasFound, 0);

            for(int i = 0 ; i< t.length(); i++) {
                int c = (int) t.charAt(i);
                needToFind[c]++;
            }

            //System.out.println("needToFind: " + needToFind);

            for(int i = 0 ; i< s.length(); i++) {
                int c = (int) s.charAt(i);
                if(needToFind[c] == 0) {
                    continue;
                }

                hasFound[c]++;

                if(hasFound[c] <= needToFind[c]) {
                    count++;
                }

                //System.out.println("Count: " + count);
                if(count == t.length()) {
                    while(needToFind[(int) s.charAt(begin)] == 0 ||
                            hasFound[(int) s.charAt(begin)] > needToFind[(int) s.charAt(begin)]) {
                        if(hasFound[(int) s.charAt(begin)] != 0) {
                            hasFound[(int) s.charAt(begin)]--;
                        }
                        begin++;
                    }
                    if(i-begin < min) {
                        min = i-begin;
                        globalBegin = begin;
                    }
                }
            }

            if(globalBegin == -1) {
                return "";
            } else {
                return s.substring(globalBegin, globalBegin+min+1);
            }
        }

}
