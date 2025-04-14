import java.util.*;
public class SubStringWithconcatenationOfAllWords {

    public static void main(String [] args){
    String s="barfoothefoobarman";
    String [] words = {"foo","bar"};
    findSubstring(s,words);
    }

    public static  void swap(int x,int y,String [] words){
        String temp=words[x];
        words[x]=words[y];
        words[y]=temp;
    }

    public  static void solve(int idx,String [] words,int n,List<List<String>> result){
        List<String> ds=new ArrayList<>();
        if(idx==n){
            for(int i=0;i<words.length;i++){
                ds.add(words[i]);
            }
            result.add(ds);
        }
        for(int i=idx;i<n;i++){
            swap(i,idx,words);
            solve(idx+1,words,n,result);
            swap(i,idx,words);

        }
    }

    public static List<List<String>> combinations(String [] words){
        int n=words.length;
        List<List<String>> result=new ArrayList<>();

        solve(0,words,n,result);
        return result;
    }

    public static List<Integer> KMP(String pat,String txt,List<Integer> res){
        int n=txt.length();
        int m=pat.length();
        int [] LPS=new int[m+1];
        computeLPS(pat,LPS,m);
        int i=0;
        int j=0;

        while(i<n){
            if(j<m && txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if(j==m){
                res.add(i-m);
                j=LPS[j-1];
            }
            else if(i<n && txt.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j=LPS[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return res;

    }

    public static void computeLPS(String pattern , int [] LPS,int m){
        int i=1;
        int len=0;
        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                LPS[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=LPS[len-1];
                }
                else{
                    i++;
                }
            }
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {

        List<List<String>> ans=combinations(words);
        List<String> combined=new ArrayList<>();
        for(List<String> concat: ans){
            String val="";
            for(int i=0;i<concat.size();i++){
                val=val+(concat.get(i));
            }
            combined.add(val);
        }
        List<Integer> indexList=new ArrayList<>();
        for(int i=0;i<combined.size();i++){
            String pat=combined.get(i);
            indexList=KMP(pat,s,indexList);

        }

        return indexList;
    }


}
