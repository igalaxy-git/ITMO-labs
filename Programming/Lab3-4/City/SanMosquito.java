package City;

import Things.Thing;

import java.util.ArrayList;

public class SanMosquito implements MoonCity{
    private final String name = "Сан-Комарик";

    public static class Stuff{
        static ArrayList<Thing> CityStuff = new ArrayList<Thing>();
        public static void addStuff(Thing thing){
            CityStuff.add(thing);
        }
        public static String viewStuff(){
            return CityStuff.toString().replace("[", "").replace("]", "");
        }
    }

    @Override
    public String filledWith(){
        return Stuff.viewStuff() + " заполнили " + name + ".";
    }

    @Override
    public String differentiate(){
        return name + " ничем не отличается от других больших лунных городов.";
    }
}
