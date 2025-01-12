import java.util.*;
public class RankTeamByVotes {

    public static void main(String [] args){
        String [] votes={"WXYZ", "XYZW", "WZXY", "XYWZ", "YZXW"};
        rankTeams(votes);
    }
    public static String rankTeams(String[] votes) {
        int n=votes[0].length();
        int [][] arr=new int [26][n+1];
        for(int i=0;i<26;i++){
            arr[i][n]=i;
        }

        for(int i=0;i<votes.length;i++){
            String s=votes[i];
            for(int j=0;j<n;j++){
                arr[s.charAt(j)-'A'][j]++; // 22nd row 0 th posiotion
            }
        }

        Arrays.sort(arr, (a,b)->{
            for(int i=0;i<n;i++){
                if(a[i]!=b[i]){
                    return Integer.compare(b[i],a[i]); //bigger will come first
                }
            }
            return Integer.compare(a[n],b[n]);
        });

        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            // System.out.println(str.append((char)(arr[i][n]+'A')));
            str.append((char)(arr[i][n]+'A'));
        }

        return str.toString();


    }
}
