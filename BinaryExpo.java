public class BinaryExpo {

    public static void main(String [] args){
        int a=3;
        int b=12;
        binaryExponent(3,12);
    }

    public static int binaryExponent(int a,int b){
        if(b==0){
            return 1;
        }
        int half=binaryExponent(a,b/2);
        int result=half*half;
        if(b%2==1){
            result=a*result;
        }
        return result;
    }
}
