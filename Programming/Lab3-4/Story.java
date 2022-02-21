import City.SanMosquito;
import Time.TimesOfDay;
import ShortGuys.*;
import Things.*;
import Throwable.*;

public class Story {
    public static void main(String[] args) throws PermissionException, NamingException{
        try {
            StoryOutput theStory = new StoryOutput() {
                @Override
                public void printStory() {
                    System.out.println(TimesOfDay.Evening);
                    System.out.println(new AdLights().printInformation());
                    SanMosquito city = new SanMosquito();
                    try {
                        SanMosquito.Stuff.addStuff(new Thing("Электрический свет"));
                        SanMosquito.Stuff.addStuff(new Thing("веселье и музыка"));
                        SanMosquito.Stuff.addStuff(new Thing("гуляющие и танцующие коротышки"));
                        SanMosquito.Stuff.addStuff(new Thing("скрипение качелей"));
                        SanMosquito.Stuff.addStuff(new Thing("вертящиеся карусели"));
                        SanMosquito.Stuff.addStuff(new Thing("чертовы колеса и другие приспособления для веселого времяпрепровождения"));
                    } catch (PermissionException ex){
                        System.out.println("PermissionException catched: " + ex.getMessage());
                    }
                    System.out.println(city.filledWith());
                    System.out.println(city.differentiate());
                    System.out.println(new MainCharacter().watch());
                    System.out.println(new Extra().eat());
                    System.out.println(new MainCharacter().envy());
                    System.out.println(new MainCharacter().walk());
                    System.out.println(new FalseMirror().printInformation());
                    System.out.println(new MainCharacter().talk());
                    System.out.println(new MainCharacter().notice());
                    System.out.println(new MainCharacter().watch());
                    System.out.println(new Extra().crowd());
                    System.out.println(new Sign().printInformation());
                    System.out.println(new Artist().stand());
                    System.out.println(new Artist().head());
                    System.out.println(new Extra().throwBalls());
                    System.out.println(new Artist().havingFun());
                    System.out.println(new Extra().havingFun());
                }
            };
            StoryOutput theEnding = new StoryOutput() {
                @Override
                public void printStory() {
                    System.out.println("Конец!");
                }
            };
            theStory.printStory();
            theEnding.printStory();
        }
        catch(NamingException ex){
            System.out.println("NamingException catched: " + ex.getMessage());
        }

    }
}
