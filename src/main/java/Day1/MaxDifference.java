package Day1;

import org.junit.Test;

/**
 
 * Given an array of integer elements,
 * return the maximum difference of any pair
 * of numbers such that the larger number of
 * the pair occurs at a higher index than the smaller.
 */
public class MaxDifference {

    static int maxDifference(int[] arrayOfIntegers) {
        int result = 0;

        if(arrayOfIntegers.length == 0){ //if input array is empty = result 0
            result = 0;
        }

        if(arrayOfIntegers.length == 1){ //if array consist of 1 element = result is one element
            result = arrayOfIntegers[0];
        }

        if(arrayOfIntegers.length > 1){
            int indexOfMax = findIndexOfMax(arrayOfIntegers); // first need to find the index of max element

            int minBeforeMax = findMinBeforeMax(arrayOfIntegers, indexOfMax); //then need to find the mix element which has index less then index of max
            result = arrayOfIntegers[indexOfMax] - minBeforeMax; //find the difference between max and mix element
        }

        return result;
    }

    private static int findMinBeforeMax(int[] arr, int indexOfMax){
        int min = arr[0];

        for(int i = 0; i < indexOfMax; i++){ //iterating through array from first to max element
            if(arr[i] < min){ //if current element less then min
                min = arr[i]; //store this element to min variable
            }
        }

        return min;

    }

    private static int findIndexOfMax(int[] arr) {
        int indexOfmax = 0;
        int max = arr[0];

        for(int i = 0; i < arr.length; i++){  //iterating through array
            if(arr[i] > max) { //if current element bigger then max
                max = arr[i]; //store this element to max variable
                indexOfmax = i; //find index of max element
            }
        }
        return indexOfmax;
    }

    @Test
    public void test001(){
        int[] arr = {7,2,3,10,2,4,8,1};

        System.out.println(maxDifference(arr));
    }

    @Test
    public void test002(){
        int[] arr = {6,7,9,5,6,3,2};

        System.out.println(maxDifference(arr));
    }

}
