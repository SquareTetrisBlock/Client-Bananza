package lunacy.command.impl;

import lunacy.Client;
import lunacy.command.Command;
import lunacy.command.CommandInfo;
import lunacy.module.Module;
import org.lwjgl.input.Keyboard;

@CommandInfo(name = "Bind", desc = "Binds the module given to a specific key.", aliases = {"b"})
public class CommandBind extends Command {

    @Override
    public void onCommand(String[] args) {
        try {
            Module module = Client.getSingleton().getModuleManager().getModule(args[1]);
            module.setKeyCode(Keyboard.getKeyIndex(args[2].toUpperCase()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
