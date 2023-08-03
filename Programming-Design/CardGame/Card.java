// класс, реализующий одну карту (ее значение и вывод)

public class Card {
    private int val;
    private int next;

    public Card(int val, int next){
        this.val = val;
        this.next = next;
    }

    public int getVal(){
        return val;
    }

    public int getNext(){
        return next;
    }

    public void setNext(int next){
        this.next = next;
    }


    public void printCard(){
        int value = val / 4 + 6;
        int suit = val % 4;

        switch (value) {
            case 10 -> System.out.print(10);
            case 11 -> System.out.print(" В");
            case 12 -> System.out.print(" Д");
            case 13 -> System.out.print(" К");
            case 14 -> System.out.print(" Т");
            default -> System.out.print(" " + value);
        }

        switch (suit) {
            case 0 -> System.out.print("♠ ");
            case 1 -> System.out.print("♥ ");
            case 2 -> System.out.print("♦ ");
            case 3 -> System.out.print("♣ ");
        }
    }
}
