package Realization;

public class Main {
    public static void main(String[] args) {
        ListString ls = new ListString("012345678901234567890123456789");
        System.out.println(ls);
        ls.insert(16, "string");
        System.out.println(ls);
        ListString sub = ls.substring(14, 30);
        System.out.println(sub);
        ListString ls2 = new ListString();
        ls.append(ls2);
        System.out.println(ls);
    }
}