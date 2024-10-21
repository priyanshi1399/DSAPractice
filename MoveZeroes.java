public class MoveZeroes {

    public static  void moveZeroes(int [] nums){
        int n=nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        for(int i=j+1;i<n;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }


    public static void main(String [] args){
        int []nums={1,0,1};
        moveZeroes(nums);
    }

}
