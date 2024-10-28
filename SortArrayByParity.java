public class SortArrayByParity {

    public static  int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int [] res=new int [n];
        int j=0;
        int k=n-1;
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0){
                res[k]=nums[i];
                k--;
            }
            else{
                res[j]=nums[i];
                j++;
            }
        }
        return res;
    }

    public static  void main(String [] args){
        int [] nums= {0,1};
       int [] ans= sortArrayByParity(nums);
        System.out.println(ans);
    }
}
