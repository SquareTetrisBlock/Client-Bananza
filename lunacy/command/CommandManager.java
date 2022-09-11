package lunacy.command;

import lunacy.util.main.Dependency;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CommandManager {

  private final List<Command> commandList = new ArrayList<>();

  public void init() {
    Reflections reflections = new Reflections();
    Set<Class<?>> set = reflections.getTypesAnnotatedWith(CommandInfo.class);
    set.forEach(this::addCommand);
  }

  public void onCommand(String message) {
    String[] args = message.substring(1).split(" ");
    commandList.forEach(command -> {
      if(command.getName().equalsIgnoreCase(args[0]) || command.getAliases().contains(args[0])) {
        command.onCommand(args);
        Dependency.addToChat("Ran command " + command.getName() + " with args " + Arrays.toString(args));
      }
    });
  }

  private void addCommand(Class<?> clazz) {
    try {
      this.commandList.add((Command) clazz.newInstance());
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
