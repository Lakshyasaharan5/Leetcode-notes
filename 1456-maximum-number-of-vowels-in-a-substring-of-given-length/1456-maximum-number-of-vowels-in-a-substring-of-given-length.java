class Solution {
    public int maxVowels(String s, int k) {
        int curr = 0;

        // Build the first window
        for (int i = 0; i < k; i++) {
            curr += isVowel(s.charAt(i));
        }

        if (curr == k) {
            return k; // Cannot do better
        }

        int best = curr;

        // Slide the window
        for (int right = k; right < s.length(); right++) {
            curr += isVowel(s.charAt(right));
            curr -= isVowel(s.charAt(right - k));

            if (curr > best) {
                best = curr;

                if (best == k) {
                    return k;
                }
            }
        }

        return best;
    }

    private int isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> 1;
            default -> 0;
        };
    }
}