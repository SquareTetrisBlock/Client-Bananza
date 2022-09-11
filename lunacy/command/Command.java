package lunacy.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

  private String name;
  private String desc;
  private List<String> aliases;

  public Command() {
    CommandInfo commandInfo = getClass().getAnnotation(CommandInfo.class);
    this.name = commandInfo.name();
    this.desc = commandInfo.desc();
    this.aliases = new ArrayList<>(Arrays.asList(commandInfo.aliases()));
  }

  public void onCommand(String[] args) {

  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

  public List<String> getAliases() {
    return aliases;
  }

}
