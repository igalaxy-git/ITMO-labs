// класс для работы с колодой карт

import java.util.Random;

public class Deck {
    private int n; // размер колоды
    private Card[] cards; // массив карт

    public Deck(int n){
        this.n = n;
        cards = new Card[n];
        for (int i = 0; i < n; i++){
            cards[i] = new Card(i, -1);
        }
    }

    // доступ к колоде
    public Card[] getCards(){
        return cards;
    }

    // вывод колоды осуществляется через вывод карты
    public void printDeck(){
        for (Card card : cards) card.printCard(); // вывод карты
        System.out.print("\n"); // переход на новую строку
    }

    // перемешиваем карты: меняем местами каждую карту со случайной
    public void shuffle(){
        Random random = new Random();
        Card temp;
        for (int i = 0; i < n; i++){
            int k = random.nextInt(n);
            temp = cards[i];
            cards[i] = cards[k];
            cards[k] = temp;
        }
    }

    // раздача карт игрокам
    public void giveCards(Player player1, Player player2){
        // меняем значения next колоды
        for (int i = 0; i < cards.length; i += 2){
            cards[i].setNext(i);
            player1.addCard(cards[i]);
            cards[i+1].setNext(i + 1);
            player2.addCard(cards[i+1]);
        }
    }
}
