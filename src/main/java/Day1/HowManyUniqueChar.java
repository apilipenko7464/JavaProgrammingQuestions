package Day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class HowManyUniqueChar {

    public void printResult(HashMap<Character, Integer> map){
        for (Map.Entry<Character, Integer> each : map.entrySet()){ //iterating through entrySet of key-value pair
            System.out.println(each); //printing each pair
        }
    }

    public HashMap<Character, Integer> howManyEachCharInSent(String input) {

        HashMap<Character, Integer> result = new HashMap<Character, Integer>(); //declare result variable

        input = input.toLowerCase(); //making all characters lower case
        input = input.replace(" ", ""); //deleting spaces

        for (char each : input.toCharArray()) { //traversing through input string
            if (result.containsKey(each)) { //if result HashMap already contains character
                int value = result.get(each); //getting the value stored in Map
                result.put(each, (value + 1));//incrementing value by 1
            } else {
                result.put(each, 1); //else if there is not such a character in result Map - add it
            }
        }

        return result;


    }

    @Test
    public void test001(){
        String string = "The quick brown fox jumps over the lazy dog";
        howManyEachCharInSent(string);
    }

    @Test
    public void test002(){
        String inputString = "abc"; //string using for test

        HashMap<Character, Integer> expectedResult = new HashMap<>(); //declaring variable for expected result
        expectedResult.put('a', 1);
        expectedResult.put('b', 1);
        expectedResult.put('c', 1);//adding values to result

        HashMap<Character, Integer> actualResult = howManyEachCharInSent(inputString); //storing actual result of our method to variable

        Assert.assertEquals(expectedResult, actualResult); //if expectedResult will be not equal actualResult, it throw an exeption

        printResult(actualResult); //use existing method to printout result
    }

}
