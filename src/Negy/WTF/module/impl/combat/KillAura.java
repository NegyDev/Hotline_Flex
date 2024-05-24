package Negy.WTF.module.impl.combat;

import Negy.WTF.Event.Event;
import Negy.WTF.Event.impl.MotionEvent;
import Negy.WTF.Mappings.Minecraft;
import Negy.WTF.module.Category;
import Negy.WTF.module.Module;
import net.minecraft.B5;
import net.minecraft.DN;
import net.minecraft.bY;
import net.minecraft.hv;
import net.minecraft.ba;
import org.lwjgl.input.Keyboard;

public class KillAura extends Module {
    private long lastAttackTime = 0L;
    private long attackCooldown = 360;
    public KillAura() {
        super("KillAura", Keyboard.KEY_R, Category.Combat);
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof MotionEvent){
            for(DN entity: Minecraft.getWorld().P){
                if(entity == Minecraft.getPlayer())continue;
                if(entity==null)continue;
                if(entity instanceof net.minecraft.DZ){
                    float distance = Minecraft.getPlayer().T(entity);
                    if(distance <= 3.6f){
                        Attack(entity);
                    }
                }
            }
        }
    }

    public void Attack(DN Entity){
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAttackTime >= attackCooldown) {
            float distance = Minecraft.getPlayer().T(Entity);
            if(distance <= 3.6f){
                faceEntity(Entity);
                Minecraft.getMinecraft().N.O(Minecraft.getPlayer(),Entity);
                Minecraft.getPlayer().YU.A(new net.minecraft.fz());
            }
            lastAttackTime = currentTime;
        }
    }
    public static synchronized void faceEntity(DN entity) {
        final float[] rotations = getRotationsNeeded(entity);
        Minecraft.getPlayer().YU.A(new ba(rotations[0],rotations[1],true));
    }
    public static float[] getRotationsNeeded(DN entity) {
        double deltaX = entity.l -Minecraft.getPlayer().l;
        double deltaY = entity.ph - Minecraft.getPlayer().ph;
        double deltaZ = entity.p6 - Minecraft.getPlayer().p6;

        double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

        float yaw = (float) Math.toDegrees(-Math.atan2(deltaX, deltaZ));
        float pitch = (float) Math.toDegrees(-Math.atan2(deltaY, distance));

        return new float[]{yaw, pitch};
    }
}
