package Pokemons;

import Moves.Physical.*;
import Moves.Special.*;
import Moves.Status.*;
import ru.ifmo.se.pokemon.*;

public class Rayquaza extends Pokemon {
    public Rayquaza(String name, int level) {
        super(name, level);
        setData();
    }

    private void setData() {
        setStats(105, 150, 90, 150, 90, 95);
        setType(Type.DRAGON, Type.FLYING);
        setMove(new BodySlam(), new MagicalLeaf(), new SwordsDance(), new RazorLeaf());
    }
}
