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

package me.max.betterbeds.listeners;

import me.max.betterbeds.BetterBeds;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerBedLeaveListener implements Listener{

    private BetterBeds betterBeds;

    public PlayerBedLeaveListener(BetterBeds betterBeds){
        this.betterBeds = betterBeds;

        this.betterBeds.getServer().getPluginManager().registerEvents(this, betterBeds);
    }

    @EventHandler
    public void onBedExit(PlayerBedLeaveEvent event){
        if (betterBeds.getConfig().getBoolean("enable-bypass-permission") && event.getPlayer().hasPermission("betterbeds.bypass")) return;

        event.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
        event.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 10 * 20, 3, false, false));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10 * 20, 1, false, false));
        event.getPlayer().setBedSpawnLocation(null);
    }
}
