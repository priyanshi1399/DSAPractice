import java.util.*;
public class CustomSort {
    public static void main(String [] args){
        List<Integer> res= Arrays.asList(1,3,5,6,2,3,8);

        List<String> vector= new ArrayList<>();
        vector.add("Hello");
        vector.add("you");
        vector.add("me");
        Collections.sort(res);
      res.sort((a,b)-> {
    int x=(int)a;
    int y=(int)b;
    if(a<b) {
        return 1;
    }
    else if(a>b) {
        return -1;
    }
    else {
        return 0;
    }
      });


    }


}
