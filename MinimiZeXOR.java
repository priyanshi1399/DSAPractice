import java.util.*;
public class MinimiZeXOR {

    public static void main(String [] args){
        int num1 = 1;
        int num2 = 12;
        minimizeXor(num1,num2);
    }
    public static boolean isSetBit(int number, int bit){
        return ((number & (1<<bit))!=0);
    }


    public static int minimizeXor(int num1, int num2) {
        int x=0;
        int requiredBitCount=Integer.bitCount(num2);
        System.out.println(requiredBitCount);
        for(int bit=31;bit>=0;bit--){
            if(isSetBit(num1,bit)){
                x=x|(1<<bit);
                requiredBitCount--;
                System.out.println(requiredBitCount);
                if(requiredBitCount==0){
                    return x;
                }
            }
        }
        for(int bit=0;bit<32;bit++){
            if(!isSetBit(num1,bit)){
                x=x|(1<<bit);
                requiredBitCount--;
                if(requiredBitCount==0){
                    break;
                }
            }
        }
        return x;
    }
}
