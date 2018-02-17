/*
 *
 *  *
 *  *  * BetterBeds - Making beds more exciting!
 *  *  * Copyright (C) 2018 Max Berkelmans AKA LemmoTresto
 *  *  *
 *  *  * This program is free software: you can redistribute it and/or modify
 *  *  * it under the terms of the GNU General Public License as published by
 *  *  * the Free Software Foundation, either version 3 of the License, or
 *  *  * (at your option) any later version.
 *  *  *
 *  *  * This program is distributed in the hope that it will be useful,
 *  *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  *  * GNU General Public License for more details.
 *  *  *
 *  *  * You should have received a copy of the GNU General Public License
 *  *  * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *  *
 *
 */

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
