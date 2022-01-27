public class Main {
    public static void main(String[] args){
        Guy noknow = new Guy("Незнайка");
        noknow.addAbility(new Abilities("смотреть", "на коротышек", Environment.RESTAURANT));
        noknow.addEmotion(new Emotions("зависть"));

        Guy goat = new Guy("Козлик");
        goat.addAbility(new Abilities("смотреть", "на коротышек", Environment.RESTAURANT));
        goat.addEmotion(new Emotions("зависть"));

        Guy shorts = new Guy("Коротышки");
        shorts.addAbility(new Abilities("угощаться", "разными вкусными блюдами", Environment.RESTAURANT));

        noknow.addAbility(new Abilities("ходить", Environment.STREET));
        noknow.addAbility(new Abilities("бродить", Environment.STREET));

        Thing mirror = new Thing("Зеркало");
        mirror.addAbility(new Abilities("криво отражать", "физиономии"));

        goat.addEmotion(new Emotions("радость"));
        noknow.addEmotion(new Emotions("счастье"));
    }
}
