import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Введите текст и нажмите <Enter>: ");
        String text = new Scanner(System.in).nextLine();
        System.out.println("Длина текста: " + text.length());*/

        //Курсовая "Циклы"
        int correctPartCount = 0;
        while(true) {
            System.out.println("Введите путь к файлу: ");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.isFile();
            if(fileExists){
                correctPartCount++;
                System.out.println("Путь указан верно. Это файл номер " + correctPartCount);
            } else {
                System.out.println("Указанный файл не существует или указанный путь является путём к папке");
            }
        }
    }
}
