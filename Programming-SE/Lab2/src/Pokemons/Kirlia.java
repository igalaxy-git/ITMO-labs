package Pokemons;

import Moves.Status.*;
import ru.ifmo.se.pokemon.*;

public class Kirlia extends Ralts {
    public Kirlia(String name, int level) {
        super(name, level);
        setData();
    }

    private void setData() {
        setStats(38, 35, 35, 65, 55, 50);
        setType(Type.PSYCHIC, Type.FAIRY);
        setMove(new StunSpore());
    }
}