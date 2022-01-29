package Things;

public class Thing {
    private final String type;
    private String work;
    private String place;

    Thing(){
        this.type = "Nothingness";
    }

    public Thing(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setPlace(String place){
        this.place = place;
    }

    public void setWork(String work){
        this.work = work;
    }

    public String getPlace(){
        return place;
    }

    public String getWork(){
        return work;
    }

    public String printInformation(){
        return getType() + " " + getWork() + " " + getPlace() + ".";
    }


    @Override
    public int hashCode() {
        return this.getType().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString(){
        return getType();
    }
}
