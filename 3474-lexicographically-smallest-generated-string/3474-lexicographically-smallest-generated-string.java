class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] word = new char[n + m - 1];

        for (int i = 0; i < word.length; i++) word[i] = '?';

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }

        for (int i = 0; i < word.length; i++) {
            if (word[i] == '?') word[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean changed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;
                        if (canChange(idx, str1, m)) {
                            word[idx] = (word[idx] == 'a') ? 'b' : 'a';
                            changed = true;
                            break;
                        }
                    }
                    if (!changed) return "";
                }
            }
        }

        return new String(word);
    }

    private boolean canChange(int idx, String str1, int m) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == 'T') {
                if (idx >= i && idx < i + m) return false;
            }
        }
        return true;
    }
}