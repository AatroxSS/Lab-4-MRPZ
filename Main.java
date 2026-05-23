import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============= ЛАБОРАТОРНА РОБОТА №4 =============");

        System.out.print("Введіть шлях до вхідного файлу (з кодом Java): ");
        String inputFilePath = scanner.nextLine().trim();

        System.out.print("Введіть шлях до вихідного файлу (для результату): ");
        String outputFilePath = scanner.nextLine().trim();

        System.out.println("\n[ІНФО] Починаємо обробку даних...");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            System.out.println("[ІНФО] Вхідний файл успішно відкрито для читання.");
            System.out.println("[ІНФО] Вихідний файл створено/відкрито для запису.");

            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null)
            {
                String reversedLine = new StringBuilder(line).reverse().toString();
                writer.write(reversedLine);
                writer.newLine();

                lineCount++;
            }

            System.out.println("[ІНФО] Читання та інвертування рядків завершено.");
            System.out.println("[ІНФО] Усього опрацьовано рядків: " + lineCount);
            System.out.println("[УСПІХ] Результат успішно збережено у файл: " + outputFilePath);

        } catch (IOException e)
        {
            System.out.println("❌ [ПОМИЛКА] Виникла проблема під час роботи з файлами!");
            System.out.println("Деталі: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("=================================================");
        }
    }
}
