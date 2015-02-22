package com.pvpsoup.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
/**
 *
 * @author RiflemanSD
 */
public class Listeners  implements Listener {
    
    public Listeners() {}
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
	Player player = event.getPlayer();
        
        if (!player.hasPermission("pvpsoup.use")) return;
        
        ItemStack item = player.getItemInHand();
        if (item.getType().compareTo(Material.MUSHROOM_SOUP) == 0) {
            if (event.getAction().compareTo(Action.RIGHT_CLICK_AIR) == 0 || event.getAction().compareTo(Action.RIGHT_CLICK_BLOCK) == 0) {
                
                double h = player.getHealth();
                double mh = player.getMaxHealth();
                int f = player.getFoodLevel();
                
                if (h == mh) {
                    if (f != 20) {
                        int fToAdd = f + 7;
                        if (fToAdd > 20) fToAdd = 20;
                        SoupEvent sevent = new SoupEvent(player, item, false, fToAdd - f);
                        Bukkit.getServer().getPluginManager().callEvent(sevent);
                
                        if (!sevent.isCancelled()) {
                            sevent.setPlayerFood(fToAdd);
                            sevent.makeBowl();
                        }
                    }
                }
                else {
                    double hToAdd = h + 7;
                    if (hToAdd > mh) hToAdd = mh;
                    SoupEvent sevent = new SoupEvent(player, item, true, hToAdd - h);
                    Bukkit.getServer().getPluginManager().callEvent(sevent);
                
                    if (!sevent.isCancelled()) {
                        sevent.setPlayerHealth(hToAdd);
                        sevent.makeBowl();
                    }
                }
            }
        }
        
    }
}
