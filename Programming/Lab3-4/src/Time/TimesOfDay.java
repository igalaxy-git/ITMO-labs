package Time;

public enum TimesOfDay {
    Midnight("полночь"),
    Noon("полдень"),
    Morning("утро"),
    Evening("вечер"),
    Night("ночь"),
    Dawn("рассвет"),
    Twilight("сумерки");

    private final String title;
    TimesOfDay(String title){this.title = title;}

    public String getTitle() {
        return title;
    }

    private String chooseVerb(TimesOfDay time){
        switch (time) {
            case Midnight:
            case Night:
                return "Наступила " + time.title + ".";
            case Twilight:
                return "Наступили " + time.title + ".";
            case Noon:
            case Evening:
            case Dawn:
                return "Наступил " + time.title + ".";
            case Morning:
                return "Наступило " + time.title + ".";
            default:
                return "Наступило какое-то время суток.";
        }
    }

    @Override
    public String toString(){
        return chooseVerb(this);
    }
}
