package Day2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.Assert.assertTrue;


public class ExcelSpreadsheat {

    public static final String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static HashMap<Integer, String> hashMap = createMap(alphabet);

    public static HashMap<Integer, String> createMap(String[] array) {

        HashMap<Integer, String> hashMap = new HashMap<>(); //declare HashMap
        int i = 1;

        for (String each : alphabet) { //traversing through array of chars
            hashMap.put(i, each); //putting each char to map with key 1...26
            i++;
        }

        return hashMap;
    }


    public static Stack digitalFormat(int num) throws Exception {

        Stack<Integer> result = new Stack<>();

        int letterNumber;

        if (num > 0) {
            while (num > 0) {
                letterNumber = num % 26; // number of letter equals the remainder of the division

                num = (num - letterNumber) / 26; // after calculation first letter we need to substitute it and devide by 26

                if (letterNumber == 0) { //one of the boundaries,when the remainder of the division equal 0, means that letter is Z
                    letterNumber = 26;
                }

                if (letterNumber == 26) { //another boundary, when remainder equals 26;
                    num = num - 1; //need to subtract 1 to finish iteration
                }

                result.push(letterNumber); //pushing calculated number to result stack
            }
        } else {
            throw new Exception("out of bound");
        }

        return result;

    }

    public static String convertToABC(Stack<Integer> stack) {
        String result = "";
        for (int each : stack) {
            result = hashMap.get(each) + result;
        }

        return result;
    }

    @Test
    public void test000() throws Exception {

        int n = 18877;

        for (int i = 1; i <= n; i++) {
            Stack<Integer> convertedDigit = digitalFormat(i);

            System.out.println((convertedDigit.toString()) + "    " + convertToABC(convertedDigit));
        }
    }

    @Test
    public void test001() throws Exception {

        int n = 1844;

        assertTrue("ERROR", convertToABC(digitalFormat(n)).equals("BRX"));
    }

    @Test
    public void test002() throws Exception {

        int n = 27;

        assertTrue("ERROR", convertToABC(digitalFormat(n)).equals("AA"));
    }

    @Test
    public void test003() throws Exception {

        int n = 703;

        assertTrue("ERROR " + convertToABC(digitalFormat(n)), convertToABC(digitalFormat(n)).equals("AAA"));
    }

    @Test
    public void test004() throws Exception {

        int n = 16384;

        assertTrue("ERROR " + convertToABC(digitalFormat(n)), convertToABC(digitalFormat(n)).equals("XFD"));
    }

    @Test
    public void test005_negative_OutOfBound_zero() {

        int n = 0;

        try {
            convertToABC(digitalFormat(n));
        } catch (Exception e) {
            assertTrue(e.toString().contains("out of bound"));
        }
    }

    @Test
    public void test006_negative_OutOfBound_BelowZero() {

        int n = -100;

        try {
            convertToABC(digitalFormat(n));
        } catch (Exception e) {
            assertTrue(e.toString().contains("out of bound"));
        }
    }
}