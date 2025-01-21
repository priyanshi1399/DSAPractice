public class AddBinary_Bit {

    public static void main(String [] args){
       String  a = "11";
       String b = "1";
       addBinary(a,b);
    }

    public static  String addBinary(String a, String b) {
        int a1=a.length();
        int b1=b.length();
        int i=0;
        int carry=0;
        int x=0,y=0;
        String ans="";
        while(i<a1 || i<b1 || carry!=0){
            if(a1-i-1>=0 && a.charAt(a1-i-1)=='1'){
                x=1;
            }
            else{
                x=0;
            }

            if(b1-i-1>=0 &&  b.charAt(b1-i-1)=='1'){
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
