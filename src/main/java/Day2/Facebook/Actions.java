package Day2.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abarabash on 3/3/16.
 */
public class Actions {

    public static void makeFriends(Friend friend1, Friend friend2){
        friend1.friends.add(friend2);
        friend2.friends.add(friend1);
    }

    public static void unFriend(Friend friend1, Friend friend2){

        friend1.friends.remove(friend2);
        friend2.friends.remove(friend1);
    }

    public static Boolean areFriends(Friend friend1, Friend friend2){
        Boolean result1 = false;
        Boolean result2 = false;

        for(Friend each : friend1.friends){
            result1 = each == friend2;
        }

        for (Friend each : friend2.friends){
            result2 = each == friend1;
        }

        return result1&&result2;
    }

    public static List<String> directFriends(Friend friend){
        List<String> result= new ArrayList<String>();

        for(Friend each:friend.friends){
            result.add(each.name);
        }

        return result;
    }

    public static List<String> breathFirstSearch(Friend root){

        List<String> result = new ArrayList<String>();

        Queue queue = new Queue();
        root.visited = true;
        queue.enqueue(root);

        while(queue.first != null){
            Friend c = (Friend) queue.dequeue();
            for(Friend each: c.friends){

                if(!each.visited){
                    result.add(each.name);

                    each.visited = true;
                    queue.enqueue(each);
                }
            }
        }

        return result;

    }

    public static List<String> inDirectFriends(Friend friend){

        return breathFirstSearch(friend);
    }
}
