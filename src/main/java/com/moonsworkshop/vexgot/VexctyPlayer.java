package com.moonsworkshop.vexcty.api.craftbukkit;

import com.moonsworkshop.vexcty.api.util.CC;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.Conversable;
import org.bukkit.entity.HumanEntity;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.scoreboard.Scoreboard;

public interface VexctyPlayer extends HumanEntity, Conversable, CommandSender, OfflinePlayer, PluginMessageRecipient {

    public default void sendTranslated(String msg) { // i just did this manually becuase i cant be botherd to find out
        if (msg.contains("%%red%%")) {
            msg.replace("%%red%%", "");
            sendMessage(CC.RED + msg);
        }
    }

    public default boolean isStaff(boolean isStafff) {

        if (getPlayer().hasPermission("f2erg.vexcty.admin")) {
            isStafff = true;
        } else {
            isStafff = false;
        }
        return isStafff;
    }

    public boolean isSneaking();

    public float getExhaustion();

    void setPlayerListName(String var1);

    public void setExhaustion(float value);

    public float getSaturation();

    public void setSaturation(float value);

    public int getFoodLevel();

    public void setFoodLevel(int value);

    public boolean getAllowFlight();


    public void setAllowFlight(boolean flight);


    public void hidePlayer(VexctyPlayer player);

    public void showPlayer(VexctyPlayer player);


    public boolean canSee(VexctyPlayer player);


    @Deprecated
    public boolean isOnGround();


    public boolean isFlying();

    public void setFlying(boolean value);

    public void setFlySpeed(float value) throws IllegalArgumentException;

    public void setWalkSpeed(float value) throws IllegalArgumentException;

    public float getFlySpeed();

    public float getWalkSpeed();

    @Deprecated
    public void setTexturePack(String url);

    public void setResourcePack(String url);

    public Scoreboard getScoreboard();

    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException;

    public boolean isHealthScaled();


    public void setHealthScaled(boolean scale);


    public void setHealthScale(double scale) throws IllegalArgumentException;


    public double getHealthScale();

    public void kickPlayer(String message);

}
