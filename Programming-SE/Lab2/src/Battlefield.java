import Pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Battlefield {
    public static void main(String[] args) {
        Battle b = new Battle();
        Frillish frillish = new Frillish("Suga", 1);
        Gallade gallade = new Gallade("Jimin", 1);
        Jellicent jellicent = new Jellicent("Jungkook", 1);
        Kirlia kirlia = new Kirlia("Taehyung", 2);
        Ralts ralts = new Ralts("Hoseok", 1);
        Rayquaza rayquaza = new Rayquaza("Namjoon", 1);
        b.addAlly(frillish);
        b.addAlly(gallade);
        b.addAlly(jellicent);
        b.addFoe(kirlia);
        b.addFoe(ralts);
        b.addFoe(rayquaza);
        b.go();
    }
}
