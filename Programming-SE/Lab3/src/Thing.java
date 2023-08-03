public class Thing extends Inanimate{
    Thing(String name){
        super(name);
        System.out.println("Объект " + name + " успешно создан.");
    }

    @Override
    public void addAbility(Abilities ability) {
        super.addAbility(ability);
        System.out.println(getName() + " умеет " + ability + ".");
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
        return "Название объекта - " + this.getName();
    }
}
