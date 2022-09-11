package lunacy.util;

import net.minecraft.client.Minecraft;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {

  public static File getLunacyFolder() {
    return new File(Minecraft.getMinecraft().mcDataDir, "Lunacy");
  }

  public static File getFileFromFolder(String folder, String name) {
    File folderFile = new File(getLunacyFolder(), folder);
    File nameFile = new File(folderFile, name);
    folderFile.mkdirs();
    if(!nameFile.exists()) {
      try {
        nameFile.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return nameFile;
  }

  public static void writeToFile(File file, List<String> toWrite) {
    try {
    FileWriter fileWriter = new FileWriter(file);

    for(String str : toWrite) fileWriter.append(str).append("\n");

    fileWriter.close();
    } catch (Exception e) {}
  }

  public static List<String> readFromFile(File file) {
    List<String> toReturn = new ArrayList<>();
    try {
      Scanner scanner = new Scanner(file);

      while (scanner.hasNext()) toReturn.add(scanner.nextLine());

      scanner.close();
    } catch (Exception e) {}
    return toReturn;
  }

}
