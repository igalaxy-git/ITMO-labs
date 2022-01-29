package Things;

public class Sign extends Thing implements Actor{
    public Sign(){
        super("Вывеска с надписью \"Весёлый балаганчик\"");
        act();
    }

    @Override
    public void act(){
        super.setWork("висела");
        super.setPlace("над деревянным помостом");
    }
}
