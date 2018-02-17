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
        event.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
        event.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 10, 3, false, false));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 1, false, false));
        event.getPlayer().setBedSpawnLocation(null);
    }
}
