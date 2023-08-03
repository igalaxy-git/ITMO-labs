public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        for (int i = 0; i < 14; i++) {
            System.out.println("Шаг " + i);
            field.Print();
            field.Update();
        }
    }
}