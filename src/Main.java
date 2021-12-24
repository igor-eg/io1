import java.io.FileOutputStream;
//import java.util.*;
import java.io.File;
import java.io.IOException;
import java.time.*;

public class Main {
    public static StringBuilder sb = new StringBuilder("Логи:\n");

    public static void main(String[] args) {
        // В папке Games создаем несколько директорий: src, res, savegames, temp
        directoryCreation("H://JAVA/Games/src");
        directoryCreation("H://JAVA/Games/res");
        directoryCreation("H://JAVA/Games/savegames");
        directoryCreation("H://JAVA/Games/temp");

        //В каталоге src создаем две директории: main, test.
        directoryCreation("H://JAVA/Games/src/main");
        directoryCreation("H://JAVA/Games/src/test");

        //В подкаталоге main создаем два файла: Main.java, Utils.java.
        fileCreation("H://JAVA/Games/src/main/Main.java");
        fileCreation("H://JAVA/Games/src/main/Utils.java");

        //В каталог res создаем три директории: drawables, vectors, icons.
        directoryCreation("H://JAVA/Games/res/drawables");
        directoryCreation("H://JAVA/Games/res/vectors");
        directoryCreation("H://JAVA/Games/res/icons");

        //В директории temp создаем файл temp.txt.
        fileCreation("H://JAVA/Games/temp/temp.txt");

        //Запись логов в файл temp.txt
        writingToFile(sb);
        //System.out.println(sb);


    }

    public static void directoryCreation(String directoryName) {

        // определяем объект для каталога
        File dir = new File(directoryName);
        // пробуем создать каталог

        if (dir.mkdir()) {
            sb
                    .append("Каталог ")
                    .append(directoryName)
                    .append(" создан в -->")
                    .append(LocalDateTime.now())
                    .append("\n");

        } else {
            sb
                    .append("Каталог ")
                    .append(directoryName)
                    .append(" не создан, время попытки создания: ")
                    .append(LocalDateTime.now())
                    .append("\n");
        }

    }


    public static void fileCreation(String fileName) {
        // определяем объект для файла
        File myFile = new File(fileName);
        // создадим новый файл
        try {
            if (myFile.createNewFile()) {

                sb
                        .append("Файл ")
                        .append(fileName)
                        .append(" создан в -->")
                        .append(LocalDateTime.now())
                        .append("\n");

            } else {
                sb
                        .append("Файл ")
                        .append(fileName)
                        .append(" не создан, время попытки создания: ")
                        .append(LocalDateTime.now())
                        .append("\n");
            }


        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static <bytes> void writingToFile(StringBuilder sb) {
        // откроем байтовый поток записи в файл
        try (FileOutputStream fos = new FileOutputStream("H://JAVA/Games/temp/temp.txt", true)) {
            // перевод строки в массив байтов
            byte[] bytes = sb.toString().getBytes();
            // запись байтов в файл
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


}

