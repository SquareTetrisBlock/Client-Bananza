package lunacy.module.impl.render;

import lunacy.event.Event;
import lunacy.event.impl.EventMotion;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.lwjgl.input.Keyboard;

@ModInfo(
    name = "Fullbright",
    desc = "Makes everything Bright",
    keyCode = 0,
    category = Module.Category.RENDER)
public class FullBright extends Module {

    @Override
    public void onEvent(Event event) {
        if(event instanceof EventMotion) {
            mc.gameSettings.gammaSetting = 1000f;
            mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), (int) 1e159));
        }
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = 1;
        mc.thePlayer.removePotionEffect(Potion.nightVision.getId());
    }
}
