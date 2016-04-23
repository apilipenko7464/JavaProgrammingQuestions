import org.junit.Assert;
import org.junit.Test;

/**
 * Created by abarabash on 4/6/16.
 */
public class SummarNumbers {

    public static int sumOfNumbers2(String inputString){
        int sum = 0;
        String digit = "";

        int length = inputString.length();

        for(int i = 0; i < length; i++)
        {
            char each = inputString.charAt(i);

            if(Character.isDigit(each) || each == '-'){
                digit += each;
            } else {
                if (!digit.isEmpty()) {
                    sum+= Integer.parseInt(digit);
                    digit = "";
                }
            }
        }

        if (!digit.isEmpty()) {
            sum+= Integer.parseInt(digit);
        }

        return sum;
    }


    public static int sumOfNumbers(String inputString){

       // inputString = inputString.replaceAll("\\W", " ");

        int sum = 0;


        String[] arrayOfStrings = inputString.split("(?:(?!-))\\D");//split("[^\\d.]");

        for(String each: arrayOfStrings){
            if(!each.equals("") && each != null) {
                sum+=Integer.parseInt(each);
            }
        }

        return sum;
    }


    @Test
    public void test0001(){

       String inputString = "1a2b3c";

        Assert.assertEquals(6, sumOfNumbers2(inputString));
    }

    @Test
    public void test0002(){

        String inputString = "123ab!45c";

        Assert.assertEquals(168, sumOfNumbers2(inputString));
    }

    @Test
    public void test0003(){

        String inputSting = "abcdef";

        Assert.assertEquals(0, sumOfNumbers2(inputSting));
    }

    @Test
    public void test0004(){

        String inputSting = "0123.4";

        Assert.assertEquals(127, sumOfNumbers2(inputSting));
    }

    @Test
    public void test0005(){

        String inputSting = "dFD$#23+++12@#T1234;/.,10";

        Assert.assertEquals(1279, sumOfNumbers2(inputSting));
    }

    @Test
    public void test0006(){

        String inputSting = "125a-5";

        Assert.assertEquals(120, sumOfNumbers2(inputSting));
    }
}
