public class DecompressRunLengthEncodedList {

    public static int [] generateArray(int k,int val,int [] res){
        int [] newArray=new int[res.length+k];
        System.arraycopy(res,0,newArray,0,res.length);
        for(int i=0;i<k;i++){
        newArray[res.length+i]=val;
        }
    return newArray;
    }



    public static int[] decompressRLElist(int[] nums) {
        int res[]=new int[0];
        for(int i=0;i< nums.length;i+=2){
            res=generateArray(nums[i],nums[i+1],res);
        }
        return res;
    }


    public static void main(String [] args){
        int [] nums={1,2,3,4};
       int [] ans= decompressRLElist(nums);
        System.out.println(ans);

    }
}
