public enum Environment {
    EVERYWHERE ("везде"),
    STREET ("на улице"),
    RESTAURANT ("в ресторане");

    private String title = "";
    private final String type;

    Environment(String type){
        this.type = type;
    }

    Environment(String type, String title) {
        this(type);
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int uniqueNumber() {
        return (type + title).hashCode();
    }

    @Override
    public String toString(){
        return type + " " + title;
    }

    public Boolean equals(Environment somewhere) {
        return somewhere.uniqueNumber() == this.uniqueNumber();
    }
}
