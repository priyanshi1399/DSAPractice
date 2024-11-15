public class DuplicateZeroes {
    public static void duplicatingAndShifting(int [] arr,int val,int index){
        int n=arr.length;
        if(index!=n) {
            for (int i = n - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
        }
        arr[index]=val;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }


    public static void duplicateZeros(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                duplicatingAndShifting(arr,arr[i],i+1);
                System.out.println("The value of i "+i);
                i++;
            }
        }
    }

    public static void main(String [] args){
        //int [] arr = {1,0,2,3,0,4,5,0};
       // int [] arr = { 0,0,0,0,0,0,0};
        int [] arr={8,4,5,0,0,0,0,7};
        duplicateZeros(arr);
    }
}
