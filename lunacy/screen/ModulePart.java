package lunacy.screen;

import lunacy.module.Module;
import lunacy.util.MouseUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

public class ModulePart {

  private final Module module;
  private float x, y;
  private final Minecraft mc = Minecraft.getMinecraft();
  private final FontRenderer fr = mc.fontRendererObj;

  public ModulePart(Module module) {
    this.module = module;
  }

  public void drawPart(float x, float y) {
    this.x = x;
    this.y = y;
    Gui.drawRect(x, y, x + 100, y + 20, module.isToggled() ? module.getCategory().getColor().getRGB() : 0xFF1C1C1C);
    Gui.drawCenteredString(fr,
        module.getName() + " [" + Keyboard.getKeyName(module.getKeyCode()) + "]", x + 51, y + 6, -1);
  }

  public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
    if(MouseUtil.inInArea(mouseX, mouseY, x, y, 100, 20)) module.toggle();
  }

  public void mouseReleased(int mouseX, int mouseY, int mouseButton) {}
}
