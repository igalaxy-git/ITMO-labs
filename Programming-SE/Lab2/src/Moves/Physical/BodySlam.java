package Moves.Physical;

import ru.ifmo.se.pokemon.*;

public class BodySlam extends PhysicalMove {
    public BodySlam() {
        super(Type.NORMAL, 85, 1);
    }

    @Override
    protected void applyOppEffects(Pokemon opp) {
        if (Math.random() <= 0.3) Effect.paralyze(opp);
    }

    @Override
    protected String describe() {
        return "uses Body Slam";
    }
}