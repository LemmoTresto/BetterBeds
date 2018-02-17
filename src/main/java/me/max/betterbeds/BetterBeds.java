package me.max.betterbeds;

import me.max.betterbeds.listeners.PlayerBedEnterListener;
import me.max.betterbeds.listeners.PlayerBedLeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterBeds extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            if (getConfig() == null || getConfig().isSet("enable-bypass-permission")) {
                getLogger().info("Reading and writing to config.");
                getConfig().addDefault("enable-bypass-permission", true);
                getConfig().options().copyDefaults(true);
                saveConfig();
            }
        } catch (Exception e){
            getLogger().severe("Reading and writing to config failed!");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

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
}
