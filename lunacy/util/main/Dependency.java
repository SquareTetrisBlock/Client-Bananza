package lunacy.util.main;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class Dependency {

  protected static final Minecraft mc = Minecraft.getMinecraft();

  public static void addToChat(String text) {
    mc.thePlayer.addChatMessage(new ChatComponentText("[bonanza] " + text));
  }
}
