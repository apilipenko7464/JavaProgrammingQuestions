package Day2.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abarabash on 3/3/16.
 */
public class Friend {

    String name;

    Friend next;
    boolean visited;
    List<Friend> friends = new ArrayList<>();

    Friend(String friendName){
        name = friendName;
    }

    Friend(String friendName, List<Friend> friendsList){
        name = friendName;
        friends = friendsList;
    }





}
