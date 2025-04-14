public class MaximumSubarraywithequalProducts {

    public static void main(String [] args){
    int [] nums={2,3,4,5,6};
    maxLength(nums);

    }

    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,(a%b));
        }
    }


    public static  int lcm(int a,int b){
        return (a/gcd(a,b))*b;
    }


    public static int maxLength(int[] nums) {
        int maxLength=0;
        for(int i=0;i<nums.length;i++){
            int prod=1;
            int calgcd=nums[i];
            int callcm=nums[i];

            for(int j=i;j<nums.length;j++){
                prod=prod*nums[j];
                calgcd=gcd(calgcd,nums[j]);
                callcm=lcm(callcm,nums[j]);

                if(prod==calgcd*callcm){
                    maxLength=Math.max(maxLength,j-i+1);
                }



            }
        }
        return maxLength;

    }
}
