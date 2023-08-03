public class Main {
    public static void main(String[] args) {
        // Одномерный массив a типа short, заполненный числами от 1 до 20 включительно в порядке убывания.
        short[] a = new short[20];
        for (int i = 0; i < 20; i++) {
            a[i] = (short) (20 - i);
        }

        // Одномерный массив x типа float, заполненный 16-ю случайными числами в диапазоне от -4.0 до 15.0.
        float[] x = new float[16];
        int begin = -4;
        int end = 15;
        for (int i = 0; i < 16; i++) {
			/* Math.random() возвращает рандомное число от 0.0 до 1.0
			Умножаем это число на длину диапазона и прибавляем к его началу
			 */
            x[i] = (float) (begin + Math.random() * (end - begin));
        }

        // Двумерный массив matrix, заполненный по формулам
        float[][] matrix = new float[20][16];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 16; j++) {
                switch (a[i]) {
                    case 16:
                        matrix[i][j] = (float) Math.cos(Math.cbrt(Math.cos(x[j])));
                        break;
                    case 1:
                    case 3:
                    case 4:
                    case 6:
                    case 8:
                    case 9:
                    case 11:
                    case 17:
                    case 18:
                    case 19:
                        matrix[i][j] = (float) (Math.pow(Math.cos(Math.pow(0.5 * (x[j] - 1), 2)), 2 * Math.pow(2 * (2.0 / 3.0) / (x[j] - 0.5), 2)));
                        break;
                    default:
                        matrix[i][j] = (float) ((Math.log(Math.sqrt((Math.abs(x[j]) + 1) / (Math.abs(x[j]))))) * Math.pow((1.0 / 3.0) + Math.atan(Math.pow(Math.E, Math.cbrt(-Math.pow(Math.cos(x[j]), 2)))), 2));
                        break;
                }
                System.out.printf("%10.5f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
