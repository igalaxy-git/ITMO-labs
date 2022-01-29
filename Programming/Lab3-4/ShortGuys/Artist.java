package ShortGuys;

public class Artist extends SecondaryCharacter{
    private final String name = "Смешной коротышка";

    public Artist(){
        super();
    }

    @Override
    public String havingFun(){
        return name + " гримасничал и нелепо дергался в стороны, стараясь уберечь лицо от ударов.";
    }

    public String stand(){
        return name + " стоял на помосте за занавеской, сделанной из обыкновенной простыни.";
    }

    public String head(){
        return name + " просунул голову в круглое отверстие, имевшееся посреди простыни.";
    }
}
