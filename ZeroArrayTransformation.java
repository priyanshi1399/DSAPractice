public class ZeroArrayTransformation {
    public static void main(String [] args) {
        //int[] nums = {2, 0, 2};
        //int[][] queries = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};
        int[] nums = {2};
        int [][] queries={{0,0,3},{0,0,3},{0,0,4},{0,0,1},{0,0,2},{0,0,5},{0,0,4},{0,0,5}};
        minZeroArray(nums,queries);
    }

    private static boolean AlreadyZeroPresent(int [] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                return false;
            }
        }
        return true;
    }
    private static boolean DiffreneceArrayTechnique(int [] nums,int [][] queries,int k){
        int n=nums.length;
        int [] diff=new int[n];
        for(int i=0;i<=k;i++){
            int L=queries[i][0];
            int R=queries[i][1];
            int x=queries[i][2];

            diff[L]+=x;
            if(R+1<n)
                diff[R+1]-=x;
        }

        int cumuSum=0; //cumuSum
        for(int i=0;i<n;i++){
            cumuSum+=diff[i];
            diff[i]=cumuSum;

            if(nums[i]-diff[i]>0){
                return false;
            }
        }
        return true;

    }
    public static int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;

        if(AlreadyZeroPresent(nums)){
            return 0;
        }

        int l=0;
        int r=q-1;
        int k=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(DiffreneceArrayTechnique(nums,queries,mid)){
                k=mid+1; //possible answer
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return k;
    }
}
