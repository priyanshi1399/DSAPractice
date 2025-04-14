public class DeleteCharactersToMakeFancyString {
    public static void main(String [] args){
        String s = "aaabaaaa";
        String ans=makeFancyString(s);
        System.out.println(ans);

    }

    public static String makeFancyString(String s) {
        StringBuilder s1=new StringBuilder();
        s1.append(s);
        int n=s1.length();
        int count=1;
        int j=0;
        for(int i=1;i<n;i++){
            if(s1.charAt(i)==s1.charAt(i-1)){
                count++;
                if(count>2){
                    s1.deleteCharAt(i);
                    n--;
                    i--;
                }
            }
            else{
                count=1;
            }
        }
        return s1.toString();
    }
}
