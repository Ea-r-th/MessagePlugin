package me.earth.messageplugin.envelope;

import me.earth.messageplugin.MessagePlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryClick implements Listener {

    private MessagePlugin plugin;

    public InventoryClick(MessagePlugin plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void updateInventory(InventoryClickEvent e){
        Inventory inv = e.getInventory();
        Player player = (Player) e.getWhoClicked();
        if(inv.getName().equals("&5Envelope")){
            e.setCancelled(true);
            if(e.getSlot() == 59){
                player.closeInventory();
            }
        }
    }
}
