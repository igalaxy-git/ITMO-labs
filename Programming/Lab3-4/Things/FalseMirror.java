package Things;

public class FalseMirror extends Thing implements Actor{
    public FalseMirror(){
        super("Кривое зеркало");
        act();
    }

    @Override
    public void act(){
        super.setWork("исказило физиономии смотрящих");
        super.setPlace("у краев тротуара");
    }
}
