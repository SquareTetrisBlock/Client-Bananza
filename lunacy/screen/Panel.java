package lunacy.screen;

import lunacy.Client;
import lunacy.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel {

  private float x, y;
  private boolean extended;
  private final Module.Category category;
  private final List<ModulePart> parts = new ArrayList<>();
  private final Minecraft mc = Minecraft.getMinecraft();
  private final FontRenderer fr = mc.fontRendererObj;

  public Panel(Module.Category category, float x, float y) {
    this.category = category;
    this.x = x;
    this.y = y;
    Client.getSingleton().getModuleManager().getModules().stream().filter(module -> module.getCategory() == category)
            .forEach(module -> parts.add(new ModulePart(module))); // state of the art "why"
  }

  public void drawPanel(int mouseX, int mouseY) {
    Gui.drawRect(x, y, x + 100, y + 20, new Color(0xFF111111).brighter().brighter().brighter().getRGB());
    Gui.drawCenteredString(fr, category.getName(), x + 50, y + 6, category.getColor().getRGB());

    int offY = 20;
    for(ModulePart part : parts) {
      part.drawPart(x, y + offY);
      offY+=20;
    }
  }

  public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
    parts.forEach(modulePart -> modulePart.mouseClicked(mouseX, mouseY, mouseButton));
  }

  public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
    parts.forEach(modulePart -> modulePart.mouseReleased(mouseX, mouseY, mouseButton));
  }

}
