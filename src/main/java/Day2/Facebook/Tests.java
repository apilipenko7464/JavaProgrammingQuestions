package Day2.Facebook;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static Day2.Facebook.Actions.*;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by abarabash on 3/3/16.
 */
public class Tests {

    @Test
    public void testGetDirectFriends(){

        Friend aaron = new Friend("Aaron");
        Friend bella = new Friend("Bella");

        System.out.println("running testGetDirectFriends()");


        makeFriends(aaron, bella);
        List<String> directFriends = directFriends(aaron);

        ArrayList<String> expectedFriends = new ArrayList<String>();
        expectedFriends.add("Bella");
        assertListEquivalent(expectedFriends, directFriends);

        System.out.println("testGetDirectFriends() passed successfully");
    }

    @Test
    public void testGetInDirectFriends() {
        Friend aaron = new Friend("Aaron");
        Friend bella = new Friend("Bella");
        Friend asad = new Friend("Asad");
        Friend alex = new Friend("Alex");

        ArrayList<String> expectedFriends = new ArrayList<String>();
        expectedFriends.add("Bella");
        expectedFriends.add("Asad");
        expectedFriends.add("Alex");

        System.out.println("running testGetInDirectFriends()");

        makeFriends(aaron, bella);
        makeFriends(bella, asad);
        makeFriends(asad, alex);

        List<String> directFriends = inDirectFriends(aaron);

        assertListEquivalent(expectedFriends, directFriends);

        System.out.println("testGetInDirectFriends() passed successfully");
    }

    @Test
    public void testUnfriends() {
        Friend asad = new Friend("Asad");
        Friend alex = new Friend("Alex");

        makeFriends(asad, alex);

        ArrayList<String> expectedFriends = new ArrayList<String>();
        expectedFriends.add("Alex");

        List<String> result = directFriends(asad);


        assertListEquivalent(expectedFriends, result );

        unFriend(asad, alex);

        expectedFriends = new ArrayList<String>();


        result = directFriends(asad);

        assertListEquivalent(expectedFriends, result);

    }

    //HELPER METHODS
    private void assertListEquivalent(List<String> expected, List<String> actual) {
        HashSet<String> expectedSet = new HashSet<String>(expected);
        HashSet<String> actualSet = new HashSet<String>(actual);

        assertEquals("expected list and actual list are not of the same size\n" +
                        "expected list: " + toString(expected) + "\n" +
                        "actual list: " + toString(actual),
                expectedSet.size(), actualSet.size());

        for (String expectedSetItem : expectedSet) {
            TestCase.assertTrue("expected list item " + expectedSetItem + " does not exist in actual list\n" +
                            "expected list: " + toString(expected) + "\n" +
                            "actual list: " + toString(actual),
                    actualSet.contains(expectedSetItem));
        }
    }

    private String toString(List<String> names) {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name + ", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        } else {
            return "[empty list]";
        }
        return sb.toString();
    }






}
