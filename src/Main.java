import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Введите текст и нажмите <Enter>: ");
        String text = new Scanner(System.in).nextLine();
        System.out.println("Длина текста: " + text.length());*/


        int correctPartCount = 0;
        while (true) {
            System.out.println("Введите путь к файлу: ");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.isFile();
            if (fileExists) {
                correctPartCount++;
                System.out.println("Путь указан верно. Это файл номер " + correctPartCount);
                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;
                    int lineCount=0;
                    int maxLine = 0;
                    int minLine = reader.readLine().length();
                    if (minLine > 1024) throw new OutMaxLengthOfLineException("Lines length more than 1024");
                    lineCount++;
                    while ((line = reader.readLine()) != null) {
                        int length = line.length();
                        if (length > 1024) throw new OutMaxLengthOfLineException("Lines length more than 1024");
                        if (length>maxLine) maxLine = length;
                        if (length<minLine) minLine = length;
                        System.out.println(length);
                        lineCount++;
                    }
                    System.out.println("Общие количество строк: " + lineCount);
                    System.out.println("Самая длинная строка в файле: " + maxLine);
                    System.out.println("Самая короткая строка в файле: " + minLine);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Указанный файл не существует или указанный путь является путём к папке");

            }
        }
    }
}
