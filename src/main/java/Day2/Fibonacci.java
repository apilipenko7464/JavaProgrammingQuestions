package Day2;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;


public class Fibonacci {

    private static BigInteger fibonacciRecFwd(BigInteger f1, BigInteger f2, Integer currIndex, Integer index){

        if (currIndex != index){
            if (index == 1){
                return BigInteger.valueOf(1);
            }
            if (index == 2){
                return BigInteger.valueOf(1);
            }
            else
                return fibonacciRecFwd(f2, f1.add(f2), currIndex + 1, index);
        }

        else {
            return f2;
        }


    }

    private int fibonacciRec(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return  1;
        }
        else
            return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    private long fibonacciSimple(int n) {
        int f1 = 0;
        f1 = 1;
        if (n == 1) {
            return f1;
        }

        int f2 = 1;

        if (n == 2) {
            return f2;
        }

        int f3 = 1;

        for( int i = 3; i <=n; i ++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;

    }

    @Test
    public void test004(){
        for (int i = 1; i <100; i++) {
            System.out.println(fibonacciRecFwd(BigInteger.valueOf(1), BigInteger.valueOf(1), 3, i));
        }
    }

    @Test
    public void test001(){

        int expected = 8;

        Assert.assertTrue(fibonacciRec(6) == expected);

    }

    @Test
    public void test002(){
        for (int i = 1; i < 60; i++){
            System.out.println(fibonacciRec(i));
        }
    }

    @Test
    public void test003(){
        for (int i = 1; i < 1000; i++){
            System.out.println(fibonacciSimple(i));
        }
    }
}
