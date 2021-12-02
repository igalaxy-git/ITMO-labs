package Pokemons;

import Moves.Status.*;
import ru.ifmo.se.pokemon.*;

public class Ralts extends Pokemon {
    public Ralts(String name, int level) {
        super(name, level);
        setData();
    }

    private void setData() {
        setStats(28, 25, 25, 45, 35, 40);
        setType(Type.PSYCHIC, Type.FAIRY);
        setMove(new Confide(), new DoubleTeam());
    }
}
