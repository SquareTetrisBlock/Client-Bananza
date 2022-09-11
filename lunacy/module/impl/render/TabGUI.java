package lunacy.module.impl.render;

import lunacy.Client;
import lunacy.event.Event;
import lunacy.event.impl.EventKey;
import lunacy.event.impl.EventRenderGui;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import lunacy.module.ModuleManager;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

@ModInfo(name = "TabGUI", desc = "Tabbing GUI (with tabs)", category = Module.Category.RENDER, keyCode = 0)
public class TabGUI extends Module {

  private final ModuleManager MODULE_MANAGER = Client.getSingleton().getModuleManager();
  private int catIndex, modIndex;
  private boolean extended;

  @Override
  public void onEvent(Event event) {
    if(event instanceof EventRenderGui) {
      Category cat = Category.values()[catIndex];
      Gui.drawRect(5, 25, 75, 25 + (15 * Category.values().length), 0xAA000000);

      Gui.drawRect(8, 27 + (15 * catIndex), 9, 38 + (15 * catIndex), cat.getColor().getRGB());

      int itr = 0;
      for(Category category : Category.values()) {
        fr.drawStringWithShadow(category.getName(), 13, 30 + (itr*15), category.getColor().getRGB());
        itr++;
      }

      itr = 0;
      if(extended) {
        Gui.drawRect(77, 25, 137, 25 + (15 * MODULE_MANAGER.fromCategory(cat).size()), 0xAA000000);
        Gui.drawRect(78, 27 + (15 * modIndex), 79, 38 + (15 * modIndex), cat.getColor().getRGB());
        for(Module module : MODULE_MANAGER.fromCategory(Category.values()[catIndex])) {
          fr.drawStringWithShadow(module.getName(), 84, 29 + (itr * 15), module.getCategory().getColor().getRGB());
          itr++;
        }
      }

    } else if(event instanceof EventKey) {
      EventKey eventKey = (EventKey) event;
      switch (eventKey.getKeyCode()) {
        case Keyboard.KEY_UP:
          if(extended) {
            modIndex--;
            if(modIndex < 0) modIndex = MODULE_MANAGER.fromCategory(Category.values()[catIndex]).size()-1;
            return;
          }
          catIndex--;
          if(catIndex < 0) catIndex = Category.values().length-1;
          break;
        case Keyboard.KEY_DOWN:
          if(extended) {
            modIndex++;
            if(modIndex > MODULE_MANAGER.fromCategory(Category.values()[catIndex]).size()-1) modIndex = 0;
            return;
          }
          catIndex++;
          if(catIndex > Category.values().length-1) catIndex = 0;
          break;
        case Keyboard.KEY_RIGHT:
          if(extended) {
            MODULE_MANAGER.fromCategory(Category.values()[catIndex]).get(modIndex).toggle();
            return;
          }
          if(MODULE_MANAGER.fromCategory(Category.values()[catIndex]).size() == 0) extended = false;
          else extended = true;
          break;
        case Keyboard.KEY_LEFT:
          extended = false;
      }
    }
  }
}