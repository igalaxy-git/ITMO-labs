package Pokemons;

import Moves.Status.*;
import ru.ifmo.se.pokemon.*;

public class Gallade extends Kirlia {
    public Gallade(String name, int level) {
        super(name, level);
        setData();
    }

    private void setData() {
        setStats(68, 125, 65, 65, 115, 80);
        setType(Type.PSYCHIC, Type.FIGHTING);
        setMove(new Swagger());
    }
}