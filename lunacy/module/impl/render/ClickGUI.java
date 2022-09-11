package lunacy.module.impl.render;

import lunacy.module.ModInfo;
import lunacy.module.Module;
import org.lwjgl.input.Keyboard;

@ModInfo(name = "ClickGUI", desc = "Displays da ClickGUI", keyCode = Keyboard.KEY_RSHIFT, category = Module.Category.RENDER)
public class ClickGUI extends Module {

  @Override
  public void onEnable() {
    mc.displayGuiScreen(new lunacy.screen.ClickGUI());
    toggle();
  }
}
