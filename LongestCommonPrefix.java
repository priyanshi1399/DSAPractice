public class LongestCommonPrefix {

    public static void main(String [] args){
        String [] strs = {"flower","flow","flight"};
        String ans=longestCommonPrefix(strs);
        System.out.println(ans);
    }

    public static String longestCommonPrefix(String[] strs) {
        String match=strs[0];
        String match1="";
        for(int i=1;i<strs.length;i++){
            match1="";
                for (int j = 0; match.length() > strs[i].length() ? j < strs[i].length() : j < match.length(); j++) {
                    if (match.charAt(j) == strs[i].charAt(j)) {
                        match1 = match1 + strs[i].charAt(j);
                    }
                }
            match=match1;
        }
        return match1;
    }
}
