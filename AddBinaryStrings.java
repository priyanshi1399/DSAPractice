public class AddBinaryStrings {
    public static void main(String [] args){
        String s1="01001001";
        String s2="0110101";
        addBinary(s1,s2);
    }

    public static  String addBinary(String s1, String s2) {
        int s1Len=s1.length();
        int s2Len=s2.length();
        int i=0;
        int carry=0;
        String ans="";
        int x=0,y=0;
        int sum=0;
        while(i<s1Len || i<s2Len || carry!=0){

            if(s1Len-i-1>=0 && s1.charAt(s1Len-i-1)=='1'){
                x=1;
            }
            else{
                x=0;
            }


            if(s2Len-i-1>=0 && s2.charAt(s2Len-i-1)=='1'){
                y=1;
            }
            else{
                y=0;
            }
            ans=Integer.toString((x+y+carry)%2)+ans;
            carry=(x+y+carry)/2;


            i++;
        }
        return ans;
    }
}
