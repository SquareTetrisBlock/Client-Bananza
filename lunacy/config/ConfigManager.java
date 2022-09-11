package lunacy.config;

import lunacy.Client;
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
                toWrite.add(setting.getName() + ":" + setting.getFieldValue());
              });
    });
    FileUtil.writeToFile(file, toWrite);
  }

  public static void loadConfig() {
    
  }

}
