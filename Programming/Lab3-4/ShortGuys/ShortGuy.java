package ShortGuys;

public abstract class ShortGuy {
    ShortGuy(){}
    public String walk(){
        return "Коротышка идёт.";
    }
    public String eat(){
        return "Коротышка ест.";
    }
    public String watch(){
        return "Коротышка смотрит.";
    }
    public String talk(){
        return "Коротышка говорит.";
    }
}
