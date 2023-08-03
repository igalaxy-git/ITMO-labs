public class EmptyCell {
    protected int x;
    protected int y;

    public EmptyCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int Empty() {
        return 0;
    }

    public EmptyCell Next(Field field) {
        EmptyCell[][] table = field.getTable();
        int number = table[x - 1][y - 1].Empty() + table[x - 1][y].Empty() + table[x - 1][y + 1].Empty() +
                 table[x + 1][y - 1].Empty() + table[x + 1][y].Empty() + table[x + 1][y + 1].Empty() +
                 table[x][y - 1].Empty() + table[x][y + 1].Empty();
        if (number == 3)
            return new FullCell(x, y);
        else
            return this;
    }

    public void Print() {
        System.out.print(" ");
    }
}
