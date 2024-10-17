import java.lang.String;
public class AddBinary {

    public static String addBinary(String a,String b){
        int alen=a.length();
        int bLen=b.length();
        int i=0;
        int carry=0;
        String ans="";

        while(i<alen || i<bLen || carry!=0){
            int x=0;
            if(i<alen && a.charAt(alen-i-1)=='1'){
                x=1;
            }
            int y=0;
            if(i<bLen && b.charAt(bLen-i-1)=='1'){
                y=1;
            }
            ans=Integer.toString((x+y+carry)%2)+ans;
            carry=(x+y+carry)/2;
            i+=1;
        }
        return ans;


    }


    public static void main(String [] args){

        String a="1010";
        String b="1011";
        String res=addBinary(a,b);
        System.out.println(res);
    }
}
