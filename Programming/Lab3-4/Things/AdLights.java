package Things;

public class AdLights extends Thing implements Light{
    public AdLights(){
        super("Огни реклам");
        makeLight();
    }

    @Override
    public void makeLight() {
        super.setWork("ярко светят");
        super.setPlace("всюду");
    }
}
