package lunacy.config;

import lunacy.Client;
import lunacy.module.Module;
import lunacy.module.ModuleManager;
import lunacy.setting.SettingManager;
import lunacy.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

  private static final ModuleManager MODULE_MANAGER = Client.getSingleton().getModuleManager();
  private static final SettingManager SETTING_MANAGER = Client.getSingleton().getSettingManager();

  public static void saveConfig(String fileName, boolean render) {
    File file = FileUtil.getFileFromFolder("config", fileName);
    List<String> toWrite = new ArrayList<>();
    MODULE_MANAGER.getModules().forEach(module -> {
      toWrite.add(module.getName() + ":toggled:" + module.isToggled());
      SETTING_MANAGER.getSettingsFromObject(module)
              .forEach(setting -> {
                toWrite.add(module.getName() + ":" + setting.getName() + ":" + setting.getFieldValue());
              });
    });
    FileUtil.writeToFile(file, toWrite);
  }

  public static void loadConfig(String fileName) {
    File file = FileUtil.getFileFromFolder("config", fileName);
    for (String s : FileUtil.readFromFile(file)) {
      String[] args = s.split(":");
      Module module = MODULE_MANAGER.getModule(args[0]);
      if (args[1].equalsIgnoreCase("toggled")) {
        module.setToggled(Boolean.parseBoolean(args[2]));
        continue;
      }
      SETTING_MANAGER.getSetting(module, args[1]).loadValue(args[2]);
    }
  }
}
