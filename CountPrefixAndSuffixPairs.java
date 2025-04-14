public class CountPrefixAndSuffixPairs {

    public static void main (String [] args){
     String [] words  = {"a","abb"};
     countPrefixSuffixPairs(words);
    }

    public static  void computeLPS(String pattern, int [] LPS, int m){

        int len=0;
        int i=1;
        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                LPS[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=LPS[len-1];
                }
                else{
                    LPS[i]=0;
                    i++;
                }
            }
        }
    }

    public static  boolean KMP(String pat,String txt){
        int n=txt.length();
        int m=pat.length();
        int [] LPS=new int [m];

        computeLPS(pat,LPS,m);

        int i=0;
        int j=0;
        while(i<n){
            if(j<m && txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==m && m==1){

                return false;
            }
            if(j==m){
                return true;
            }
            else if(i<n && txt.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j=LPS[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return false;
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(KMP(words[i],words[j])){
                    count++;
                }
            }
        }
        return count;
    }

}
