public class Emotions implements Qualities{
    String action = "";
    String extra = "";

    Emotions(String action){
        this.action = action;
    }

    Emotions(String action, String extra){
        this(action);
        this.extra = extra;
    }

    public String getAction(){
        return action;
    }

    public String getAdditionalInformation(){
        return extra;
    }

    public String toString(){
        return action + " " + extra;
    }
}
