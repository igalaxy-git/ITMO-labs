public class Guy extends Alive{
    Guy(String name){
        super(name);
        System.out.println(name + " успешно создан.");
    }

    @Override
    public void addAbility(Abilities ability) {
        super.addAbility(ability);
        System.out.println(getName() + " умеет " + ability + ".");
    }

    @Override
    public void addEmotion(Emotions emotion) {
        super.addEmotion(emotion);
        System.out.println(getName() + " чувствует " + emotion + ".");
    }

    @Override
    public int hashCode() {
        return super.hashCode()+this.getName().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }
    @Override
    public String toString() {
        return "Имя - " + this.getName();
    }
}
