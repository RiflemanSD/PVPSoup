package com.pvpsoup.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author RiflemanSD
 */
public class SoupEvent extends Event implements Cancellable {
    private boolean cancel;
    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private ItemStack item;
    private boolean isHealthChange;
    private double amount;
    
    public SoupEvent(Player player, ItemStack item, boolean isHealthChange, double amount) {
        cancel = false;
        this.player = player;
        this.item = item;
        this.isHealthChange = isHealthChange;
        this.amount = amount;
    }
    public double getAmount() {
        return this.amount;
    }
    public boolean isHealthChange() {
        return this.isHealthChange;
    }
    public boolean isFoodChange() {
        return !this.isHealthChange;
    }
    public void makeBowl() {
        item.setType(Material.BOWL);
    }
    public void setPlayerFood(int f) {
        player.setFoodLevel(f);
    }
    public void setPlayerHealth(double h) {
       player.setHealth(h);
    }
    public Player getPlayer() {
        return this.player;
    }
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean c) {
        this.cancel = c;
    }
    
}
