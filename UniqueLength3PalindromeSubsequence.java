import java.util.*;

public class UniqueLength3PalindromeSubsequence {

    public static void main(String [] args){
        String s="bbcbaba";
        countPalindromicSubsequence(s);

    }
    public static int countPalindromicSubsequence(String s) {

        HashSet<Character> uniqueCharacters=new HashSet<>();
        for(int i=0;i<s.length();i++){
            uniqueCharacters.add(s.charAt(i)); //b c a
        }

        int result=0;
        for(char ch:uniqueCharacters){

            //see for every letter leftMostIdx and rightMostIdx
            int leftMostIdx=-1;
            int rightMostIdx=-1;

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==ch){
                    //find out letter's starting index and rightMostIndex
                    if(leftMostIdx==-1) { //that means we have not seen it
                        leftMostIdx=i;
                    }
                    rightMostIdx=i; //we will keep updating
                }
            }

            //till 0-5 check all and stores in map

            HashSet<Character> set=new HashSet<>();
            for(int middle=leftMostIdx+1;middle<rightMostIdx;middle++){
                set.add(s.charAt(middle));
            }

            result=result+set.size();

        }
        return result;


    }
    }



