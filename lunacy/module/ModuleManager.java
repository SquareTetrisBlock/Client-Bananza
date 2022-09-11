package lunacy.module;

import org.reflections.Reflections;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ModuleManager {

  private final List<Module> modules = new CopyOnWriteArrayList<>(); // Thread safe

  public void init() {
    Reflections reflections = new Reflections();
    Set<Class<?>> set = reflections.getTypesAnnotatedWith(ModInfo.class);
    set.forEach(this::addModule);
  }

  private void addModule(Class<?> clazz) {
    try {
      this.modules.add((Module) clazz.newInstance());
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public Module getModule(Class<? extends Module> clazz) {
    return getModules().stream()
        .filter(module -> module.getClass().equals(clazz))
        .collect(Collectors.toList())
        .get(0); // very unsafe XD
  }

  public Module getModule(String name) {
    return getModules().stream()
        .filter(module -> module.getName().equalsIgnoreCase(name))
        .collect(Collectors.toList())
        .get(0); // very unsafe XD
  }

  public List<Module> fromCategory(Module.Category category) {
    return modules.stream().filter(module -> module.getCategory() == category).collect(Collectors.toList());
  }

  public List<Module> getModules() {
    return modules;
  }
}
