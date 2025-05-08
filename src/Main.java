import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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
                    double lineCount=0;
                    double googleBots =0;
                    double yandexBots =0;
                    while ((line = reader.readLine()) != null) {
                        int length = line.length();
                        if (length > 1024) throw new OutMaxLengthOfLineException("Lines length more than 1024");
                        lineCount++;
                        String bot = getBot(getUserAgent(line));
                        if(bot.equals("Googlebot")) googleBots++;
                        if(bot.equals("YandexBot")) yandexBots++;
                    }
                    System.out.println("Общие количество строк: " + (int) lineCount);
                    System.out.println("Доля запроса от YandexBot: " + getBotsProportion(lineCount, yandexBots));
                    System.out.println("Доля запроса от Googlebot: " + getBotsProportion(lineCount, googleBots));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Указанный файл не существует или указанный путь является путём к папке");

            }
        }
    }
    static String getUserAgent(String line){
        String[] fragments = line.split(" ", 12);
        return fragments [11];
    }

    static String getBot (String userAgent) {
        String[] parts = userAgent.split(";");
        if (parts.length >= 2) {
            String botInfo = parts[1];
            String[] bot = botInfo.split("/");
            return bot[0].substring(1);
        }
        return " ";
    }

    static double getBotsProportion (double lineCount, double bots) {
        return (bots/lineCount) * 100;
    }

}
