package LinkedList;
import java.util.*;
public class ArmstrongNo {
    public static int CountNum(int n){
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int check,rem;
        double sum = 0;
        check = n;
        while(check!=0){
            rem = check%10;
            sum = sum + (double)Math.pow(rem,CountNum(n));
            check = check/10;
        }
        if(sum==n){
            System.out.println("The no is armstrong" + " "+ n);
        }else{
            System.out.println("Not an armstrong no");
        }
    }
}
