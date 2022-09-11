package lunacy.screen;

import lunacy.module.Module;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClickGUI extends GuiScreen {

  private final List<Panel> panelList = new ArrayList<>();

  public ClickGUI() {
    int i = 0;
    for(Module.Category category : Module.Category.values()) {
      panelList.add(new Panel(category, i * 150 + 50, 50));
      i++;
    }
  }

  @Override
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    panelList.forEach(panel -> panel.drawPanel(mouseX, mouseY));
  }

  @Override
  protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
    panelList.forEach(panel -> panel.mouseClicked(mouseX, mouseY, mouseButton));
  }

  @Override
  protected void mouseReleased(int mouseX, int mouseY, int state) {
    panelList.forEach(panel -> panel.mouseReleased(mouseX, mouseY, state));
  }
}
