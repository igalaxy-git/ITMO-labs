package ShortGuys;

public class Extra extends SecondaryCharacter{
    private final String name = "Коротышки";

    public Extra(){
        super();
    }

    @Override
    public String eat(){
        return name + " наслаждались вкусными блюдами.";
    }

    public String crowd(){
        return name + " собрались толпой.";
    }
}
