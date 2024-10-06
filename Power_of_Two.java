public class Power_of_Two {

    /*
    Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:
Input: n = 16
Output: true
Explanation: 24 = 16
     */


    public static void main(String [] args){
        int n = 16;
        boolean a=isPowerOfTwo(n);
        System.out.println(a);
    }

    private static boolean isPowerOfTwo(int n){
        if(n==0)
            return false;
        return (n&(n-1))==0;
    }

    //5 & 4-->0100 & 0101 --0000
    //7 &8-->0111 & 1000-->0000
    //3 & 4-->0011 & 0100-->0000
    //6 & 5=110 & 101
//1______& 01111=0
//n & n-1==0-->n is power of 2
}
