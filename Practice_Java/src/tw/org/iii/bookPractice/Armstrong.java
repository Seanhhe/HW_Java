package tw.org.iii.bookPractice;

import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class Armstrong {
    private static double[][] pows;
    
    public static List<Double> narcissistic(int n) {
    	// 產生陣列, 內有0~9各次方的數(n位數-->n次方)
        pows = new double[n + 1][];
        pows[1] = new double[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int i = 2; i <= n; i++) {
            pows[i] = new double[] {
                0, 1, pows[i - 1][2] * 2, pows[i - 1][3] * 3, 
                pows[i - 1][4] * 4, pows[i - 1][5] * 5, 
                pows[i - 1][6] * 6, pows[i - 1][7] * 7, 
                pows[i - 1][8] * 8, pows[i - 1][9] * 9
            };
            for (double q : pows[i]) {
            	System.out.println(q);
            }
        }
    
        List<Double> armstrongs = new ArrayList<>();
        double bound = pow(10, n < 40 ? n : 39);
        for(double i = 1; i < bound; i++) if(isNarcissistic(i)) {
            armstrongs.add(i);
        }
        return armstrongs;
    }
    
    public static boolean isNarcissistic(double number) {
        List<Integer> digits = new ArrayList<>();
        double num = number;
        while(num != 0) {
            digits.add((int) num  % 10);
            num = floor(num / 10);
        }
        double sum = 0;
        for(Integer d : digits) {
            sum += pows[digits.size()][d];
        }
        return sum == number;
    }
    

    public static void main(String[] args) {
        for(Double d : narcissistic(3)) {
            System.out.printf("%.0f%n", d);
        }
    }
}
