public class ReverseWordsinaString {

    public static void reverseString(char [] arr,int start,int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    public static String reverseWords(String s) {
        int n=s.length();
        int start=0;
        int end=0;
        int i=0;
        int j=0;
        char [] charArray=s.toCharArray();

        //Task 1-Reverse the whole
        reverseString(charArray,0,n-1);
            //Iterate with j
        while(j<n){
            //this loop is for incrementing the j
            while(j<n && charArray[j]==' '){
                j++;
            }
            start=i;

            //untill the words end
            while(j<n && charArray[j]!=' '){
                charArray[i]=charArray[j];
                i++;j++;
            }
            end=i-1;

            reverseString(charArray,start,end);

            charArray[i++]=' ';
        }
         String s3=new String(charArray).substring(0,end+1).toString();
    return s3;

    }


    public static void main(String [] args){
       // String s="  hello  raj  vikram  ";
        String s="  hello world  ";
        reverseWords(s);
    }
}
