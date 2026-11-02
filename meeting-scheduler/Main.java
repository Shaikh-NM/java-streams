class User{
    String userId;
    String userName;
    Notifier notifier;

    public User(String id, String name){
        this.userId = id;
        this.userName = name;
        this.notifier = new EmailNotifier();
    }

    public void setNotifier(Notifier newNotifier){
        this.notifier = newNotifier;
    }
}

class MeetingRoom{
    String roomId;
    int capacity;

    public MeetingRoom(String id, int limit){
        this.roomId = id;
        this.capacity = limit;
    }
}

class Meeting{
    String meetingId;
    List<User> participants;

    public Meeting(String id, List<User> users){
        this.meetingId = id;
        this.participants = users;
    }
}

interface AssignStrategy{
    public Room assignRoom(int start, int end);
}

class minimumTimeStrategy implements AssignStrategy{
    @Override
    public Room assignRoom(int start, int end){

    }
}

interface Notifier{
    public void notify();
}

class EmailNotifier implements Notifier{
    @Override
    public void notify(){
        System.out.println("Email notification")
    }
}

public class MeetingScheduler{
    private static volatile MeetingScheduler instance;

    private MeetingScheduler(){

    }

    public static MeetingScheduler getInstance(){
        if(instance == null){
            synchronized(MeetingScheduler.class){
                if(instance == null){
                    instance = new MeetingScheduler();
                }
            }
        }
        return instance;
    }
}

public class Main{
    
    public static void main(String[] args){

    }
}  