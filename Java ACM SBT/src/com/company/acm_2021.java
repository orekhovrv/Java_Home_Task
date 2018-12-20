import java.util.Scanner;

public class acm_2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int array[] = new int[count];
        int max = 0;

        // Считывание массива
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();

        }

        // 2 раза
        for (int j = 0; j < 2; j++) {
            // Поиск max
            max = 0;
            for (int i = 0; i < count; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            // Деление
            for (int i = 0; i < count; i++) {
                if (array[i] == max) {
                    array[i] /= 2;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
    }
}