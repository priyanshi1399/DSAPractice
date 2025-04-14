public class ContsructLexicographicallySmallestDIString {

    public static void main(String [] args){
        String pattern="IIIDIDDD";
        smallestNumber(pattern);
    }

    public static boolean matchingPattern(String pattern, String num){
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i)=='I' && num.charAt(i)>num.charAt(i+1) ||
                    pattern.charAt(i)=='D' && num.charAt(i)<num.charAt(i+1)){
                return false;
            }
        }
        return true;

    }

    public  static void nextPermutation(char [] num){
        int n=num.length;
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(num[i]<num[i+1]){
                index=i;
                break;
            }
        }

        if(index==-1){
            reverse(num,0,n-1);
            return;
        }

        for(int i=n-1;i>=index;i--){
            if(num[i]>num[index]){
                swap(num,i,index);
                break;
            }
        }

        reverse(num,index+1,n-1);
    }

    public  static void reverse(char [] num, int start,int end){
        while(start<end){
            swap(num,start,end);
            start++;
            end--;
        }
    }


    public static void swap(char [] num,int x,int y){
        char temp=num[x];
        num[x]=num[y];
        num[y]=temp;

    }

    public static  String smallestNumber(String pattern) {
        int n=pattern.length();
        char [] num=new char[n+1];
        for(int i=0;i<=n;i++){
            num[i]=(char)('1'+i); //49+0=49 converts back to 1

        }
        while(!matchingPattern(pattern,new String(num))){
            nextPermutation(num);
        }
        return new String(num);
    }
}
