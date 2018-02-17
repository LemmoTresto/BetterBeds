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
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerBedEnterListener implements Listener {

    private BetterBeds betterBeds;

    public PlayerBedEnterListener(BetterBeds betterBeds){
        this.betterBeds = betterBeds;

        betterBeds.getServer().getPluginManager().registerEvents(this, betterBeds);
    }

    @EventHandler
    public void onPlayerBedJoin(PlayerBedEnterEvent event){
        if (event.isCancelled()) return;
        if (betterBeds.getConfig().getBoolean("enable-bypass-permission") && event.getPlayer().hasPermission("betterbeds.bypass")) return;

        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 999999, 999999, false, false));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 1, false, false));
    }
}
