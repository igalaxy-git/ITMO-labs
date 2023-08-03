public class Abilities implements Qualities{
    private final String action;
    private Environment place = Environment.EVERYWHERE;
    private String extra = "";

    public Abilities(String ability) {
        this.action = ability;
    }

    public Abilities(String ability, String extra) {
        this(ability);
        this.extra = extra;
    }

    public Abilities(String ability, Environment place) {
        this(ability);
        this.place = place;
    }

    public Abilities(String ability, String extra, Environment place) {
        this(ability, extra);
        this.place = place;
    }

    public String getAction(){
        return action;
    }

    public Environment getPlace(){
        return place;
    }

    public String getAdditionalInformation(){
        return extra + " " + place;
    }

    public String toString(){
        if (place.equals(Environment.EVERYWHERE)) {
            return action + " " + extra;
        } else {
            return action + " " + extra + " " + place;
        }
    }
}
