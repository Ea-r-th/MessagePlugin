package me.earth.messageplugin.envelope;

import me.earth.messageplugin.MessagePlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EnvelopeItemChecker implements Listener {

    private MessagePlugin plugin;

    public EnvelopeItemChecker(MessagePlugin plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEnvelopeClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if (itemInHand.getType().equals(Material.GOLD_HOE)){
                player.openInventory(Envelope.Envelopes.get(itemInHand).getEnvelopeInventory());
                player.sendMessage("This works");
            }
        }
    }
}
