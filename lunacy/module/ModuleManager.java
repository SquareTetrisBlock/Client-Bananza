package lunacy.module;

import org.reflections.Reflections;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

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

  public List<Module> getModules() {
    return modules;
  }

}
