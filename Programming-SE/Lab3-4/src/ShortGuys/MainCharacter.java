package ShortGuys;

public class MainCharacter extends ShortGuy{
    private final String name = "Незнайка и Козлик";
    public MainCharacter(){
        super();
    }

    public String getName(){
        return name;
    }

    @Override
    public String walk(){
        return name + " бродили вдоль улиц.";
    }

    @Override
    public String talk(){
        return name + " засмеялись.";
    }
    @Override
    public String watch(){
        return name + " смотрели на коротышек.";
    }

    public String notice(){
        return name + " заметили, что от смеха стало легче.";
    }

    public String envy(){
        return name + " завидовали.";
    }
}
