import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public static void saveGame(String path, GameProgress save) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream ous = new ObjectOutputStream(fos)) {
            ous.writeObject(save);

        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    public static void zipFiles(String path, List<String> list) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            for (int i = 0; i < list.size(); i++) {
                String file = list.get(i);
                FileInputStream fis = new FileInputStream(file);
                ZipEntry entry = new ZipEntry(file);
                zout.putNextEntry(entry);
                byte[] asd = new byte[fis.available()];
                fis.read(asd);
                zout.write(asd);
                zout.closeEntry();
                fis.close();
                File sas = new File(file);
                sas.delete();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void openZip(String file, String place) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);

                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}