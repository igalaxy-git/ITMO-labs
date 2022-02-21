package ShortGuys;

public abstract class SecondaryCharacter extends ShortGuy{
    SecondaryCharacter(){
        super();
    }

    public String havingFun(){
        class Fun {
            public static String makeSound(){
                return "веселились";
            }
        }
        return "Коротышки " + Fun.makeSound() + ".";
    }

    public String throwBalls(){
        return "Коротышки кидались мячами, целясь прямо в лицо.";
    }
}
