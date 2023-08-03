public class Field {
    private EmptyCell[][] table1;
    private EmptyCell[][] table2;
    private final int actual_size = 15;
    private final int size = actual_size + 2;

    public Field() {
        table1 = new EmptyCell[size][size];
        table2 = new EmptyCell[size][size];
        Initialize();
    }

    void Initialize() {
        for (int i = 0; i<size; i++)
            for (int j = 0; j<size; j++) {
                table1[i][j] = new EmptyCell(i, j);
                table2[i][j] = new EmptyCell(i, j);
            }
        // заполненные клетки (по условию)
        int[][] filled_cells = { {3, 8}, {4, 7}, {5, 7}, {5, 8}, {5, 9}, {10, 7}, {10, 8}, {10, 9}, {11, 7},
                {12, 8}, {3, 2}, {4, 3}, {5, 1}, {5, 2}, {5, 3}, {9, 1}, {9, 2}, {9, 3}, {10, 3}, {11, 2} };
        for (int i = 0; i < 20; i++) {
            table1[filled_cells[i][0]][filled_cells[i][1]] = new FullCell(filled_cells[i][0],filled_cells[i][1]);
            table2[filled_cells[i][0]][filled_cells[i][1]] = new FullCell(filled_cells[i][0],filled_cells[i][1]);
        }
    }

    void Update() {
        for (int i = 1; i <= actual_size; i++) {
            for (int j = 1; j <= actual_size; j++) {
                table2[i][j] = table1[i][j].Next(this);
            }
        }

        EmptyCell[][] swap = table1;
        table1 = table2;
        table2 = swap;
    }

    void Print() {
        for (int i = 1; i <= actual_size; i++) {
            for (int j = 1; j <= actual_size; j++)
                table1[i][j].Print();
            System.out.println();
        }
        System.out.println();
    }

    EmptyCell[][] getTable() {
        return table1;
    }
}
