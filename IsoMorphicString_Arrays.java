public class IsoMorphicString_Arrays {

public static void main(String [] args){

    String s= "egg";
    String t="add";
    isIsomorphic(s,t);
}

    public static boolean isIsomorphic(String s, String t) {

        int [] s1=new int[200];
        int [] t1=new int[200];

        if(s.length()!=t.length()){
            return false;
        }


        for(int i=0;i<s.length();i++){
            int a=s1[s.charAt(i)];
            int b=t1[t.charAt(i)];
            if(s1[s.charAt(i)]!=t1[t.charAt(i)]){
                return false;
            }
            s1[s.charAt(i)]=i+1;
            t1[t.charAt(i)]=i+1;


        }
        return true;

    }
}
