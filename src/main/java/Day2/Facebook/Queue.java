package Day2.Facebook;

/**
 * Created by abarabash on 3/3/16.
 */
public class Queue {

    Friend first, last;

    public void enqueue(Friend friend){
        if(first == null)
        {
            first = friend;
            last = first;
        }
        else
            {
                last.next = friend;
                last = friend;
            }
    }

    public Friend dequeue(){
        if(first == null)
        {
            return null;
        }
        else
        {
            Friend temp = new Friend(first.name, first.friends);
            first = first.next;
            return temp;
        }
    }
}
