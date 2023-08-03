package Moves.Physical;

import ru.ifmo.se.pokemon.*;

public class RazorLeaf extends PhysicalMove {
    public RazorLeaf(){
        super(Type.GRASS, 55, 0.95);
    }
    @Override
    protected double calcCriticalHit(Pokemon opp, Pokemon self){
        return 1 >> 3;
    }
    @Override
    protected String describe(){
        return "uses Razor Leaf";
    }
}
