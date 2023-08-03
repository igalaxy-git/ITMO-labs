package Test;

interface IFunc{
    int func(int a, int b);
}

public class test{
    public static void main(String[] args){
        IFunc func1 = PlusMinus::Minus;
        System.out.println(func1.func(20, 10));

        PlusMinus pm = new PlusMinus();
        IFunc func2 = pm::Plus;
        System.out.println(func2.func(20, 10));
    }
}