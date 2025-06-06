public class CreateTargetArrayFromGivenA {

    public static void main(String [] args){
        int [] nums={0,1,2,3,4};
                int [] index={0,1,2,2,1};
                createTargetArray(nums,index);
    }

    public static  void insertIntoArray(int indexVal,int [] target, int targetValue){
        int t=target.length;
        for(int i=t-2;i>=indexVal;i--){
            target[i+1]=target[i];
        }

        target[indexVal]=targetValue;
        //System.out.println(targetVal);
    }
    public  static int[] createTargetArray(int[] nums, int[] index) {
        int n=nums.length;
        int [] target=new int[n];
        for(int i=0;i<n;i++){
            insertIntoArray(index[i],target,nums[i]);
        }

        return target;
    }
}
