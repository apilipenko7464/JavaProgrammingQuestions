package Day1;

import org.junit.Test;


public class PrintTriangle {

    public static void printTriRecursion(int currHeight, int height) {

        if (currHeight == 1) {
            printSpaces(currHeight);
            printDots(height - currHeight);
        } else {

            printSpaces(currHeight);
            printDots(height - currHeight);

            printTriRecursion(currHeight - 1, height);
        }
    }

    public static void printTriangle(int height) {

        for (int i = 0; i < height; i++) { //for each level of triangle
            printSpaces(height - i); // we need first print spaces before "dots"
            printDots(i); // and then print dots // first level has 1 dot, second - 2, etc.
        }
    }

    public static void printSpaces(int height) {
        for (int i = 0; i < height; i++) { //depends on the height value, we printing out amount of spaces
            System.out.print(" ");
        }
    }

    public static void printDots(int dots) {
        for (int i = 0; i <= dots; i++) { ///depends on the dots value,
            System.out.print("* "); //  we printing out amount of dots
        }

        System.out.print("\n"); //after each level of triangle we need to start new line
    }


    @Test
    public void test001() {
        printTriangle(4);
    }

    @Test
    public void test002() {
        printTriRecursion(5, 5);
    }


}


