package Negy.WTF.module;

import Negy.WTF.Event.Event;
import org.lwjgl.input.Keyboard;


public class Module {
	    public String moduleName;
	    private static boolean keyPressed = false;
	    public int moduleKey;
	    public boolean moduleState;
	    public Category category;

	    public Module(String moduleName, int moduleKey, Category category) {
	        this.moduleName = moduleName;
	        this.moduleKey = moduleKey;
	        this.moduleState = false;
	        this.category = category;
	    }

	    public Module getModByName(String name) {
	        for (Module mod : ModuleManager.INSTANCE.getModules()) {
	            if (!mod.moduleName.trim().equalsIgnoreCase(name.trim()) && !mod.toString().trim().equalsIgnoreCase(name.trim())) continue;
	            return mod;
	        }
	        return null;
	    }

	    public Module getInstance() {
	        for (Module mod : ModuleManager.INSTANCE.getModules()) {
	            if (!mod.getClass().equals(this.getClass())) continue;
	            return mod;
	        }
	        return null;
	    }

	    public int getModuleKey() {
	        return this.moduleKey;
	    }

	    public void setModuleKey(int newModuleKey) {
	        this.moduleKey = newModuleKey;
	    }
	    public static void onEventAdd(Event e) {
	        for (Module m : ModuleManager.modules) {
	            if (!m.moduleState) continue;
	            m.onEvent(e);
	        }
	    }
	    public void onEvent(Event event) {
	    }

	    public boolean isEnabled() {
	        return this.moduleState;
	    }

	    public boolean getModuleState() {
	        return this.moduleState;
	    }

	    public void setModuleState(boolean moduleState) {
	        this.moduleState = moduleState;
	        this.onToggled();
	    }

	    public void onEnable() {
	    }

	    public void onDisable() {
	    }

	    public int getKey() {
	        return this.moduleKey;
	    }
	    public void setKey(int Key) {
	        this.moduleKey = Key;
	    }
	    public void setKey(String Key) {
	        this.moduleKey = Keyboard.getKeyIndex(Key);
	    }
	    
	    public static void KeyCheckEvent() {
	        if (Keyboard.getEventKeyState()) {
	            int k = Keyboard.getEventKey();
	            if (!keyPressed) {
	                Module.KeyPress(k);
	                keyPressed = true;
	            }
	        } else {
	            keyPressed = false;
	        }
	    }
	    public static void KeyPress(int key) {
	        for (Module m : ModuleManager.modules) {
	            if (m.getKey() != key) continue;
	            if(m.getKey() == 0)continue;
	            m.toggle();
	        }
	    }

	    public void onToggled() {
	        if (this.moduleState) {
	            this.onEnable();
	        } else {
	            this.onDisable();
	        }
	    }

	    public String getModuleName() {
	        return this.moduleName;
	    }

	    public void toggle() {
	        this.setModuleState(!this.getModuleState());
	        this.onToggled();
	    }
}
