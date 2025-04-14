public class StringofSizewithThreedistinctCharacter {

    public static void main(String[] args) {
        String s = "xyzzaz";
        countGoodSubstrings(s);
    }

    public static int countGoodSubstrings(String s) {
        int count = 0;
        int dup = 0;

        if (s.length() < 3) return 0;

        int[] freq = new int[26]; // Frequency array for lowercase letters

        for (int i = 0; i < s.length(); i++) {

     freq[s.charAt(i) - 'a']++;

            if (freq[s.charAt(i) - 'a'] == 2) {
                dup++;
            }

            if (i < 2) {
                continue;
            }
            if (dup == 0) {
                count++;
            }

            // Shift the window: decrease frequency of the (i-2)th character
            freq[s.charAt(i - 2) - 'a']--;

            if (freq[s.charAt(i - 2) - 'a'] == 1) {
                dup--;
            }

        }
        return count;

    }
}

