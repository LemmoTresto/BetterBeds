package me.max.betterbeds;

import me.max.betterbeds.listeners.PlayerBedEnterListener;
import me.max.betterbeds.listeners.PlayerBedLeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterBeds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            getLogger().info("Enabling listeners..");
            new PlayerBedEnterListener(this);
            new PlayerBedLeaveListener(this);
            getLogger().info("Enabled listeners!");
            getLogger().info("Successfully enabled.");
        } catch (Exception e){
            getLogger().severe("Error enabling listeners!");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
