import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        createDir("D:\\Jv\\src");
        createDir("D:\\Jv\\res");
        createDir("D:\\Jv\\savegames");
        createDir("D:\\Jv\\temp");
        createDir("D:\\Jv\\src\\main");
        createDir("D:\\Jv\\src\\test");
        createDir("D:\\Jv\\res\\drawables");
        createDir("D:\\Jv\\res\\vectors");
        createDir("D:\\Jv\\res\\icons");
        createFile("D:\\Jv\\src\\main\\Main.java");
        createFile("D:\\Jv\\src\\main\\Utils.java");
        createFile("D:\\Jv\\temp\\temp.txt");
        writeFile("D:\\Jv\\temp\\temp.txt");
        List<String> pathList = new ArrayList<>();
        pathList.add("D:\\Jv\\savegames\\save1.dat");
        pathList.add("D:\\Jv\\savegames\\save2.dat");
        pathList.add("D:\\Jv\\savegames\\save3.dat");
        GameProgress game1 = new GameProgress(1, 1, 1, 1);
        GameProgress game2 = new GameProgress(2, 2, 2, 2);
        GameProgress game3 = new GameProgress(3, 3, 3, 3);
        GameProgress.saveGame("D:\\Jv\\savegames\\save1.dat", game1);
        GameProgress.saveGame("D:\\Jv\\savegames\\save2.dat", game2);
        GameProgress.saveGame("D:\\Jv\\savegames\\save3.dat", game3);
        GameProgress.zipFiles("D:\\Jv\\savegames\\zip_saves.zip", pathList);
        //GameProgress.openZip(("D:\\Jv\\savegames\\zip_saves.zip"), "D:\\Jv\\savegames");
    }

    public static void createDir(String path) {
        File file = new File(path);
        file.mkdir();
        stringBuilder.append(path + " was created\n");
    }

    public static void createFile(String path) {
        try {
            File file = new File(path);
            file.createNewFile();
            stringBuilder.append(path + " was created\n");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void writeFile(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.append(stringBuilder);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}