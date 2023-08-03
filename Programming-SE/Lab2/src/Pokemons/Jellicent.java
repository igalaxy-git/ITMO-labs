package Pokemons;

import Moves.Physical.*;
import Moves.Special.*;
import Moves.Status.*;
import ru.ifmo.se.pokemon.*;

public class Jellicent extends Frillish {
    public Jellicent(String name, int level) {
        super(name, level);
        setData();
    }

    private void setData() {
        setStats(100, 60, 70, 85, 105, 60);
        setType(Type.WATER, Type.GHOST);
        setMove(new IceBeam());
    }
}