public class LongestRepeatingCharacterReplacement {

    public static void main(String [] args){
        String s="ABBB";
        int k=2;
        characterReplacement(s,k);
    }

    public static int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int end=0;
        int maxLength=0;
        int count=0;
        int right=0;
        while(right<n){
            if(s.charAt(right)==s.charAt(left)){
                maxLength=Math.max(maxLength,right-left+1);
            }
            else if(s.charAt(right)!=s.charAt(left)){
                count++;
            }
            if(count<=k){
                maxLength=Math.max(maxLength,right-left+1);
            }
            while(count>k){
                if(s.charAt(right)==s.charAt(left)){
                    count--;
                }
                left++;
            }
            // maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}
