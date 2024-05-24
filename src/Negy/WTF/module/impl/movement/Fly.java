package Negy.WTF.module.impl.movement;

import Negy.WTF.Mappings.Minecraft;
import Negy.WTF.module.Category;
import Negy.WTF.module.Module;
import net.minecraft.DT;
import org.lwjgl.input.Keyboard;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Fly extends Module {
    public Fly() {
        super("Flight", Keyboard.KEY_G, Category.Movement);
    }

    @Override
    public void onEnable() {
        Minecraft.getPlayer().FD.S.T(true);
        Minecraft.getPlayer().FD.V.T(true);
    }

    @Override
    public void onDisable() {
        Minecraft.getPlayer().FD.S.T(false);
        Minecraft.getPlayer().FD.V.T(false);
    }
}
