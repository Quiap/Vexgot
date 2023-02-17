package com.moonsworkshop.vexgot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public abstract class VexGot extends JavaPlugin {

    protected ConsoleCommandSender console = Bukkit.getConsoleSender();

    public abstract void PluginEnable();

    public abstract void PluginDisable();

    private boolean emergencyStop = false;

    public final void onEnable() {
        if (this.emergencyStop) {
            this.setEnabled(false);
        } else {
            this.console.sendMessage(" ");
            this.console.sendMessage(ChatColor.GREEN + "=============================");
            this.console.sendMessage(String.format("%s%s %s by %sMoonsworkshop LLC!", ChatColor.GRAY, this.getDescription().getName(), this.getDescription().getVersion(), ChatColor.DARK_PURPLE));
            this.console.sendMessage(String.format("%sAction: %s%s%s...", ChatColor.GRAY, ChatColor.GREEN, "Enabling", ChatColor.GRAY));

            try {
                this.PluginEnable();
                if (this.emergencyStop) {
                    this.console.sendMessage(ChatColor.RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    this.console.sendMessage(" ");
                    return;
                }

            } catch (Throwable var2) {
                this.criticalErrorOnPluginStartup(var2);
                this.console.sendMessage(ChatColor.RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                this.console.sendMessage(" ");
                return;
            }

            this.console.sendMessage(ChatColor.GREEN + "=============================");
            this.console.sendMessage(" ");
        }
    }

    public final void onDisable() {
        if (!this.emergencyStop) {
            this.console.sendMessage(" ");
            this.console.sendMessage(ChatColor.GREEN + "=============================");
            this.console.sendMessage(String.format("%s%s %s by %sMoonsworkshop LLC <3!", ChatColor.GRAY, this.getDescription().getName(), this.getDescription().getVersion(), ChatColor.DARK_PURPLE));
            this.console.sendMessage(String.format("%sAction: %s%s%s...", ChatColor.GRAY, ChatColor.RED, "Disabling", ChatColor.GRAY));
            this.PluginDisable();
            this.console.sendMessage(ChatColor.GREEN + "=============================");
            this.console.sendMessage(" ");
        }
    }

    protected void emergencyStop() {
        this.emergencyStop = true;
        Bukkit.getPluginManager().disablePlugin(this);
    }

    protected void criticalErrorOnPluginStartup(Throwable... th) {
        Bukkit.getLogger().log(Level.SEVERE, String.format("Unexpected error while loading %s v%s c%s: Disabling plugin!", this.getDescription().getName(), this.getDescription().getVersion(), Vexcty.getCoreLibraryVersion()), th);
        this.emergencyStop();
    }

    public ConsoleCommandSender getConsole() {
        return this.console;
    }


    protected void shutdownDataManager(DataManagerAbstract dataManager) {
        this.shutdownDataManager(dataManager, 15, TimeUnit.MINUTES.toSeconds(3L));
    }

    protected void shutdownDataManager(DataManagerAbstract dataManager, int reportInterval, long secondsUntilForceShutdown) {
        dataManager.shutdownTaskQueue();

        while(!dataManager.isTaskQueueTerminated() && secondsUntilForceShutdown > 0L) {
            long secondsToWait = Math.min((long)reportInterval, secondsUntilForceShutdown);

            try {
                if (dataManager.waitForShutdown(secondsToWait, TimeUnit.SECONDS)) {
                    break;
                }

                this.getLogger().info(String.format("A DataManager is currently working on %d tasks... We are giving him another %d seconds until we forcefully shut him down (continuing to report in %d second intervals)", dataManager.getTaskQueueSize(), secondsUntilForceShutdown, reportInterval));
            } catch (InterruptedException var11) {
            } finally {
                secondsUntilForceShutdown -= secondsToWait;
            }
        }

        if (!dataManager.isTaskQueueTerminated()) {
            int unfinishedTasks = dataManager.forceShutdownTaskQueue().size();
            if (unfinishedTasks > 0) {
                this.getLogger().log(Level.WARNING, String.format("A DataManager has been forcefully terminated with %d unfinished tasks - This can be a serious problem, please report it to us (Songoda)!", unfinishedTasks));
            }
        }

    }
}
