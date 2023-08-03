// класс, реализующий последовательность карт (у игрока или на столе)

public class Player {
    private int start; // индекс первой карты последовательности
    private static Card[] linked_cards;

    public Player(int start){
        this.start = start;
    }

    public static void setLinkedCards(Deck deck){
        linked_cards = deck.getCards();
    }


    public void printSet(){
        int i = start;
        while (i != -1) {
            linked_cards[i].printCard();
            i = linked_cards[i].getNext();
        }
        System.out.print("\n");
    }

    // если в последовательности нет карт, то просто меняем значение старта
    // иначе находим последнюю карту в последовательности и меняем значение next
    public void connectCards(int card_index){
        if (start == -1){
            start = card_index;
        } else {
            int i = start;
            int last = start;
            while (i != -1) {
                last = i;
                i = linked_cards[i].getNext();
            }
            linked_cards[last].setNext(card_index);
        }
    }

    // добавить карту в последовательность
    public void addCard(Card card){
        int card_index = card.getNext();
        connectCards(card_index);
        linked_cards[card_index].setNext(-1);
    }

    // добавить последовательность карт
    public void addCards(Player sequence){
        int card_index = sequence.start;
        connectCards(card_index);
        sequence.start = -1;
    }


    // получить первую карту
    public Card getCard(){
        Card first_card = linked_cards[start];
        int new_first = first_card.getNext();
        first_card.setNext(start);
        start = new_first;
        return first_card;
    }
}
