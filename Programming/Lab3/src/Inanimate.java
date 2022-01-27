import java.util.ArrayList;

public abstract class Inanimate implements Stuff {
    private String name;
    private final ArrayList<Abilities> abilities = new ArrayList<>();

    public Inanimate(){
    }

    public Inanimate(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Abilities> getAbilities(){
        return abilities;
    }

    public void addAbility(Abilities ability){
        abilities.add(ability);
    }
}
