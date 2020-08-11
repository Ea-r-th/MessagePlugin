package me.earth.messageplugin.envelope;

import me.earth.messageplugin.MessagePlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static org.bukkit.Bukkit.getServer;


public class InventoryClick implements Listener {

    private MessagePlugin plugin;

    public InventoryClick(MessagePlugin plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void updateInventory(InventoryClickEvent e){
        Inventory inv = e.getInventory();
        if(e.getInventory().getName().equals(EnvelopeGUI.inventoryName)){
            EnvelopeGUI.setInv(inv);
        }
    }
}
