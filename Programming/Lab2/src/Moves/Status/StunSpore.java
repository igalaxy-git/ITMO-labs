package Moves.Status;

import ru.ifmo.se.pokemon.*;

public class StunSpore extends StatusMove {
    public StunSpore(){
        super(Type.GRASS, 0, 75);
    }
    @Override
    protected void applyOppEffects(Pokemon opp){
        Effect.paralyze(opp);
    }
    @Override
    protected String describe(){
        return "uses Stun Spore";
    }
}
