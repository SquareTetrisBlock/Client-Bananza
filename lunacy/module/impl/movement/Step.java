package lunacy.module.impl.movement;

import lunacy.event.Event;
import lunacy.event.impl.EventMotion;
import lunacy.module.ModInfo;
import lunacy.module.Module;
import org.lwjgl.input.Keyboard;

@ModInfo(
        name = "Step",
        desc = "Step Up Blocks.",
        keyCode = 0,
        category = Module.Category.MOVEMENT)
public class Step extends Module {

    private float stepHeight;

    @Override
    public void onEnable() {
        stepHeight = mc.thePlayer.stepHeight;
        mc.thePlayer.stepHeight = 2;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        mc.thePlayer.stepHeight = stepHeight;
        super.onDisable();
    }

}
