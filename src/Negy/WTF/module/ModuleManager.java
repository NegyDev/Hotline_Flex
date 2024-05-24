package Negy.WTF.module;

import Negy.WTF.module.impl.combat.KillAura;
import Negy.WTF.module.impl.movement.Clip;
import Negy.WTF.module.impl.movement.Fly;

import java.util.ArrayList;
import java.util.List;


public enum ModuleManager {
	 INSTANCE;
	 public static List<Module> modules = new ArrayList<Module>();
	 
	 public void initialize() {
		 modules.add(new KillAura());
		 modules.add(new Clip());
		 modules.add(new Fly());
	 }
	 public Module getModule(Class<?> clazz) {
	        if (clazz != null) {
	            for (Module mod : this.getModules()) {
	                if (mod.getClass() != clazz) continue;
	                return mod;
	            }
	        }
	        return null;
	    }

	    public boolean isToggled(Class<?> clazz) {
	        if (clazz != null) {
	            for (Module mod : this.getModules()) {
	                if (mod.getClass() != clazz || !mod.isEnabled()) continue;
	                return true;
	            }
	        }
	        return false;
	    }

	    public List<Module> getModules() {
	        return this.modules;
	    }

}
