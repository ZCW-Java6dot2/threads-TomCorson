public class EventListener extends Thread{



    private String messageToListenFor;
    private String messageToReplyWith;
    private Tracker eventTracker;

    public EventListener(String message, String reply) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = EventTracker.getInstance();
    }

    public EventListener(String message, String reply, Tracker tracker) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = tracker;
    }
    public String getMessageToListenFor() {
        return messageToListenFor;
    }
    public String getMessageToReplyWith() {
        return messageToReplyWith;
    }
    public void run() {
    }

    public Boolean readyToQuit() {
        return true;
    }

    public Boolean shouldReply() {
        return true;
    }

    public void reply() {
        eventTracker.handle(messageToListenFor,() -> {});
    }
}