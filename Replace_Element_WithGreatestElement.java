public class Replace_Element_WithGreatestElement {
    public static int findMax(int k,int [] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=k;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }


    public static int[] replaceElements(int[] arr) {
        int n=arr.length;
        int [] greater=new int [n];
        greater[n-1]=-1;
        for(int i=0;i<n-1;i++){
            greater[i]=findMax(i+1,arr); //i+1 because of right side
        }
        return greater;
    }

    public static void main(String [] args){
        int [] arr = {17,18,5,4,6,1};
       int [] ans= replaceElements(arr);
        System.out.println(ans);
    }
}
