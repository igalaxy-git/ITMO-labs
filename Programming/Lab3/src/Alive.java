import java.util.ArrayList;

public abstract class Alive extends Inanimate{
    private final ArrayList<Emotions> emotions = new ArrayList<>();

    Alive(String name){
        super(name);
    }

    public ArrayList<Emotions> getEmotions(){
        return emotions;
    }

    public void addEmotion(Emotions emotion){
        emotions.add(emotion);
    }
}
