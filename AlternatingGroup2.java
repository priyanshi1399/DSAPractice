public class AlternatingGroup2 {

    public static void main(String [] args){
        int [] colors={0,1,0,0,1,0,1};
        int k = 6;
        numberOfAlternatingGroups(colors,k);
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n=colors.length;
        int [] extended=new int[n+k-1];
        System.arraycopy(colors,0,extended,0,n);
        for(int i=0;i<k-1;i++){
            extended[n+i]=colors[i];
        }

        int count=0;
        int i=0;
        int j=1;
        while(j<extended.length){
            if(extended[j]==extended[j-1]){
                i=j;
            }

            if(j-i+1==k){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
