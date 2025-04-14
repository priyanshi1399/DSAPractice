import java.util.*;
public class sortStackUsingRecusrion {

    public static void main(String [] args){

        Stack<Integer> s=new Stack<>();
        /*s.push(6);
        s.push(7);
        s.push(1);
        s.push(2);
        s.push(3);*

         */
        s.push(7);
        s.push(5);
        s.push(4);

        reverse(s);
    }
    static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty()){
            return;
        }
        int temp=s.pop();
        reverse(s);
        emptyStack(s,temp);
    }

    public static void emptyStack(Stack<Integer> s,int temp){
        if(s.isEmpty()){
            s.push(temp);
            return;
        }

        int val=s.pop();
        emptyStack(s,temp);
        s.push(val);

    }
}
