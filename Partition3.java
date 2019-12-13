import java.util.*;
import java.io.*;

public class Partition3 {
    private static boolean subsetSum(int[] S, int n, int a, int b, int c){
        if (a == 0 && b == 0 && c == 0){
            return true;
        }
        if (n < 0){
            return false;
        }
        boolean A = false;
        if (a - S[n] >= 0){
            A = subsetSum(S, n - 1, a - S[n], b, c);
        }
        boolean B = false;
        if (!A && (b - S[n] >= 0)){
            B = subsetSum(S, n-1,a,b-S[n],c);
        }
        boolean C = false;
        if ((!A && !B) && (c-S[n]>=0)){
            C = subsetSum(S,n-1,a,b,c-S[n]);
        }
        return A||B||C;
    //write your code here
    }

    public static boolean partition(int[] S){
        if (S.length < 3){
            return false;
        }
        int sum = Arrays.stream(S).sum();
        return (sum % 3) == 0 && subsetSum(S, S.length -1, sum/3, sum/3, sum/3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] S = new int[n];
        for (int i = 0; i < n; i++) {
            S[i] = scanner.nextInt();
        }
        if (partition(S)){
            System.out.print(1);
        } else{
            System.out.print(0);
        }
    }
}
