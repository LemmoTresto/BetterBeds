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
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 999999, 999999, false, false));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, 1, false, false));
    }
}
