package Pokemons;

import Moves.Physical.*;
import Moves.Status.*;
import ru.ifmo.se.pokemon.*;

public class Frillish extends Pokemon {
    public Frillish(String name, int level) {
        super(name, level);
        setData();
    }

    private void setData() {
        setStats(55, 40, 50, 65, 85, 40);
        setType(Type.WATER, Type.GHOST);
        setMove(new Confide(), new RockSlide(), new DoubleTeam());
    }
}