public class CircularSentence {

public static void main(String [] args){
    String sentence = "leetcode exercises sound delightful";
    isCircularSentence(sentence);
}

    public static boolean isCircularSentence(String sentence) {
        int n=sentence.length();
        boolean flag=false;

        int i=0;
        int j=-1;
        for(;i<n;i++){
            if(sentence.charAt(i)==' '){
                j=i;
                if(sentence.charAt(j-1)!=sentence.charAt(j+1)){
                    return false;
                }
            }
        }
        if(sentence.charAt(0)==sentence.charAt(n-1)){
            flag=true;
        }

        return flag;
    }
}
