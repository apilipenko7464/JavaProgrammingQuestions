package Day1;

import org.junit.Test;

import java.util.Arrays;


public class SortArrayOfZerosOnes {


    public void sortArrayOfZeroOnes(int[] inputArray) {

        System.out.println(Arrays.toString(inputArray)); //printing out input array first

        int size = inputArray.length; //storing length
        int sum = 0; // declaring variable for storing summary of "1"
        int[] result = new int[size]; // declaring result variable

        for (int i : inputArray)  //iterating through input array
            sum+=i; //summarizing all array members

        for (int i = 0; i < size-sum; i++)
            result[i] = 0; //adding to result array as many zeroes as in input

        for (int i = size-sum; i < size ; i++)
            result[i] = 1; //adding to result array as many ones as in input

        System.out.println(Arrays.toString(result)); //printing out result array
    }

    @Test
    public void test001(){
        int[] arrayOfInt = {0,1,0,0,1,1,0};

        sortArrayOfZeroOnes(arrayOfInt);
    }


}
