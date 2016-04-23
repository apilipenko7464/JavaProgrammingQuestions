package Day1;

import org.junit.Assert;
import org.junit.Test;


public class CheckIfPolyndrom {

    private boolean isPolyndromRecursion(String string) {
        if (string.length() == 0 || string.length() == 1)
            return true;

        if (string.charAt(0) == string.charAt(string.length() - 1))
            return isPolyndromRecursion(string.substring(1, string.length() - 1));

        return false;
    }

    public static String reverse(String string){
        //declare empty string for storing result
        String result =  "";

        //iterating through string starting from last character to first
        for(int i = string.length() - 1; i >= 0; i--){

            result+=string.charAt(i); //adding each character to result
        }
        return result; //giving result back
    }

    public static Boolean isPolyndrom(String string){

        String reversed = reverse(string); //using existing method "reverse" and storing result in variable
        Boolean result = string.equals(reversed); //if "equals" return "true", result will be "true"

        return result; //giving result back
    }

    @Test
    public void test001(){
        String first = "123454321";
        Assert.assertTrue(isPolyndrom(first));
    }

    @Test
    public void test002(){
        String first = "12345431";
        Assert.assertTrue(isPolyndrom(first));
    }

}
