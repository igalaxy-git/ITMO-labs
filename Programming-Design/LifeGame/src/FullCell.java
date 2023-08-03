public class FullCell extends EmptyCell{
    public FullCell(int x, int y) {
        super(x, y);
    }

    public int Empty() {
        return 1;
    }

    public EmptyCell Next(Field field) {
        EmptyCell[][] table = field.getTable();
        int number = table[x - 1][y - 1].Empty() + table[x - 1][y].Empty() + table[x - 1][y + 1].Empty() +
                     table[x + 1][y - 1].Empty() + table[x + 1][y].Empty() + table[x + 1][y + 1].Empty() +
                     table[x][y - 1].Empty() + table[x][y + 1].Empty();
        if (number == 2 || number == 3)
            return this;
        else
            return new EmptyCell(x, y);
    }

    public void Print() {
        System.out.print("1");
    }
}
