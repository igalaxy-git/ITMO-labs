package Moves.Physical;

import ru.ifmo.se.pokemon.*;

public class RockSlide extends PhysicalMove {
    public RockSlide(){
        super(Type.ROCK, 75, 0.9);
    }
    @Override
    protected void applyOppEffects(Pokemon opp){
        if (Math.random() <= 0.3) Effect.flinch(opp);
    }
    @Override
    protected String describe() {
        return "uses Rock Slide";
    }
}