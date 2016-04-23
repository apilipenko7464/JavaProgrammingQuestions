package problems.FindKeyJson;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by abarabash on 3/31/16.
 */
public class FindLongestSequens {
// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
/*Longest increasing sequence in an array
[1,2,3,2,5,6,7,3]
output = 9,10,11,12,13 length = 5
output = 5,6,7 */


    int[] result = {};

    public int[] findSeq(int[] input, int leftIndex, int rightIndex){

            //int[] result = {};

            for(int i = 0; i < input.length - 1; i++){

                if(input[i+1] - input[i] == 1)
                {
                    rightIndex = i+1;

                } else {

                    if ((rightIndex - leftIndex) >= result.length){
                        result = Arrays.copyOfRange(input, leftIndex, rightIndex + 1);
                    }

                    leftIndex = i + 1;
                    rightIndex = leftIndex + 1;
                    findSeq(Arrays.copyOfRange(input, leftIndex , rightIndex), 0, 1) ;
                }
            }
            return result;
        }

        @Test
        public void test001(){

            int[] input = {1,2,3,2,5,6,7,8,5,8,3};

            int[] result = findSeq(input, 0, 1);

            System.out.println(Arrays.toString(result));

        }

}


