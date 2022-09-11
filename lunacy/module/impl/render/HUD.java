package lunacy.module.impl.render;

import javafx.scene.transform.Scale;
import lunacy.Client;
import lunacy.event.Event;
import lunacy.event.impl.EventPlayerUpdate;
import lunacy.event.impl.EventRenderGui;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;

import java.util.Comparator;

@ModInfo(name = "Hud", desc = "Renders a Heads Up Display.", keyCode = Keyboard.KEY_H, category = Module.Category.RENDER)
public class HUD extends Module {

    public HUD() {
        toggle();
    }

    int count = 0; //??????

    @Override
    public void onEvent(Event event) {
        ScaledResolution sr = new ScaledResolution(mc);
        if (event instanceof EventRenderGui) {
            Client.getSingleton().getModuleManager().getModules().sort(Comparator.comparingDouble(module -> fr.getStringWidth(((Module)module).getName())).reversed());
            for(Module module : Client.getSingleton().getModuleManager().getModules()) {
                fr.drawString("Bonanza", 3, 3, -1);
                if(module.isToggled()) {
                    fr.drawStringWithShadow(module.getName(), sr.getScaledWidth() - fr.getStringWidth(module.getName()) - 4, 4 + count*10, -1);
                    count++;
                }
            }
            count = 0;
        }
    }
}
