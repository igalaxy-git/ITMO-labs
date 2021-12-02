package Moves.Special;

import ru.ifmo.se.pokemon.*;

public class IceBeam extends SpecialMove {
    public IceBeam(){
        super(Type.ICE, 90, 1);
    }
    @Override
    protected void applyOppEffects(Pokemon opp){
        if (Math.random() <= 0.1) Effect.freeze(opp);
    }
    @Override
    protected String describe(){
        return "uses Ice Beam";
    }
}