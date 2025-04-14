public class LargestOddNumberInString {
    public static long checkMax(String k,long maxi){
        long k1=(long)(Long.parseLong(k));
        if(k1>maxi && k1%2!=0){
            maxi=k1;
        }
        return maxi;
    }


    public static String largeOddNum(String s) {
        long maxVal=Integer.MIN_VALUE;
        int i=0;
        int j=i+1;
        while(j<s.length()){

            maxVal=checkMax(s.substring(i,j+1),maxVal);
            j++;
        }


        return Long.toString(maxVal);
    }

    public static void main(String [] args){
        String s = "10518744893";
        String str=largeOddNum(s);
        System.out.println(str);
    }
}
