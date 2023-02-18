package com.moonsworkshop.vexgot;

import com.moonsworkshop.vexcty.api.util.CC;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.Conversable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.plugin.messaging.PluginMessageRecipient;
import org.bukkit.scoreboard.Scoreboard;

import java.net.InetSocketAddress;
import java.util.Set;

public interface VexctyPlayer extends HumanEntity, Conversable, CommandSender, OfflinePlayer, PluginMessageRecipient {

    void sendTranslated(String msg);

    boolean isStaff(boolean isStafff);


    String getDisplayName();

    void setDisplayName(String var1);

    String getPlayerListName();

    void setPlayerListName(String var1);

    void setCompassTarget(Location var1);

    Location getCompassTarget();

    InetSocketAddress getAddress();

    void sendRawMessage(String var1);

    void kickPlayer(String var1);

    void chat(String var1);

    boolean performCommand(String var1);

    boolean isSneaking();

    void setSneaking(boolean var1);

    boolean isSprinting();

    void setSprinting(boolean var1);

    void saveData();

    void loadData();

    void setSleepingIgnored(boolean var1);

    boolean isSleepingIgnored();

    /** @deprecated */
    @Deprecated
    void playNote(Location var1, byte var2, byte var3);

    void playNote(Location var1, Instrument var2, Note var3);

    void playSound(Location var1, Sound var2, float var3, float var4);

    void playSound(Location var1, String var2, float var3, float var4);

    /** @deprecated */
    @Deprecated
    void playEffect(Location var1, Effect var2, int var3);

    <T> void playEffect(Location var1, Effect var2, T var3);

    /** @deprecated */
    @Deprecated
    void sendBlockChange(Location var1, Material var2, byte var3);

    /** @deprecated */
    @Deprecated
    boolean sendChunkChange(Location var1, int var2, int var3, int var4, byte[] var5);

    /** @deprecated */
    @Deprecated
    void sendBlockChange(Location var1, int var2, byte var3);

    void sendSignChange(Location var1, String[] var2) throws IllegalArgumentException;

    void updateInventory();

    void awardAchievement(Achievement var1);

    void removeAchievement(Achievement var1);

    boolean hasAchievement(Achievement var1);

    void incrementStatistic(Statistic var1) throws IllegalArgumentException;

    void decrementStatistic(Statistic var1) throws IllegalArgumentException;

    void incrementStatistic(Statistic var1, int var2) throws IllegalArgumentException;

    void decrementStatistic(Statistic var1, int var2) throws IllegalArgumentException;

    void setStatistic(Statistic var1, int var2) throws IllegalArgumentException;

    int getStatistic(Statistic var1) throws IllegalArgumentException;

    void incrementStatistic(Statistic var1, Material var2) throws IllegalArgumentException;

    void decrementStatistic(Statistic var1, Material var2) throws IllegalArgumentException;

    int getStatistic(Statistic var1, Material var2) throws IllegalArgumentException;

    void incrementStatistic(Statistic var1, Material var2, int var3) throws IllegalArgumentException;

    void decrementStatistic(Statistic var1, Material var2, int var3) throws IllegalArgumentException;

    void setStatistic(Statistic var1, Material var2, int var3) throws IllegalArgumentException;

    void incrementStatistic(Statistic var1, EntityType var2) throws IllegalArgumentException;

    void decrementStatistic(Statistic var1, EntityType var2) throws IllegalArgumentException;

    int getStatistic(Statistic var1, EntityType var2) throws IllegalArgumentException;

    void incrementStatistic(Statistic var1, EntityType var2, int var3) throws IllegalArgumentException;

    void decrementStatistic(Statistic var1, EntityType var2, int var3);

    void setStatistic(Statistic var1, EntityType var2, int var3);

    void setPlayerTime(long var1, boolean var3);

    long getPlayerTime();

    long getPlayerTimeOffset();

    boolean isPlayerTimeRelative();

    void resetPlayerTime();

    void setPlayerWeather(WeatherType var1);

    WeatherType getPlayerWeather();

    void resetPlayerWeather();

    void giveExp(int var1);

    void giveExpLevels(int var1);

    float getExp();

    void setExp(float var1);

    int getLevel();

    void setLevel(int var1);

    int getTotalExperience();

    void setTotalExperience(int var1);

    float getExhaustion();

    void setExhaustion(float var1);

    float getSaturation();

    void setSaturation(float var1);

    int getFoodLevel();

    void setFoodLevel(int var1);

    Location getBedSpawnLocation();

    void setBedSpawnLocation(Location var1);

    void setBedSpawnLocation(Location var1, boolean var2);

    boolean getAllowFlight();

    void setAllowFlight(boolean var1);

    void hidePlayer(Player var1);

    void showPlayer(Player var1);

    boolean canSee(Player var1);

    /** @deprecated */
    @Deprecated
    boolean isOnGround();

    boolean isFlying();

    void setFlying(boolean var1);

    void setFlySpeed(float var1) throws IllegalArgumentException;

    void setWalkSpeed(float var1) throws IllegalArgumentException;

    float getFlySpeed();

    float getWalkSpeed();

    /** @deprecated */
    @Deprecated
    void setTexturePack(String var1);

    void setResourcePack(String var1);

    Scoreboard getScoreboard();

    void setScoreboard(Scoreboard var1) throws IllegalArgumentException, IllegalStateException;

    boolean isHealthScaled();

    void setHealthScaled(boolean var1);

    void setHealthScale(double var1) throws IllegalArgumentException;

    double getHealthScale();

    Entity getSpectatorTarget();

    void setSpectatorTarget(Entity var1);

    /** @deprecated */
    @Deprecated
    void sendTitle(String var1, String var2);

    /** @deprecated */
    @Deprecated
    void resetTitle();

    Player.Spigot spigot();

    public static class Spigot extends Entity.Spigot {
        public Spigot() {
        }

        public InetSocketAddress getRawAddress() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void playEffect(Location location, Effect effect, int id, int data, float offsetX, float offsetY, float offsetZ, float speed, int particleCount, int radius) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean getCollidesWithEntities() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void setCollidesWithEntities(boolean collides) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void respawn() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public String getLocale() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Set<Player> getHiddenPlayers() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void sendMessage(BaseComponent component) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void sendMessage(BaseComponent... components) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}
