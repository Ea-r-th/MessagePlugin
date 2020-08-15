package me.earth.messageplugin.events;

import me.earth.messageplugin.MessagePlugin;
import me.earth.messageplugin.envelope.Envelope;
import me.earth.messageplugin.utils.EnchantmentGlow;
import me.earth.messageplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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

        if(inv.getName().equals(Utils.chat("&5Mailbox"))){
            if(e.getRawSlot() > 44){
                e.setCancelled(true);
                player.updateInventory();
            }
            if(e.getCurrentItem().getItemMeta().getLore().get(0).equals(Utils.chat("&aSealed, addressed"))){
                Envelope.Envelopes.get(e.getCurrentItem().getItemMeta().getLore().get(1)).setInMailbox(false);
            }
        }
        if(e.getInventory().getName().equals(Utils.chat("&5Envelope"))) {

            String lore1 = player.getInventory().getItemInMainHand().getItemMeta().getLore().get(0);
            if (lore1.equals(Utils.chat("&3Unsealed")) || lore1.equals("&aSealed, not addressed") || lore1.equals(Utils.chat("&aSealed, addressed"))) {
                ItemStack item = player.getInventory().getItemInMainHand();

                Envelope itemEnvelope = Envelope.Envelopes.get(item.getItemMeta().getLore().get(1));

                
                ItemMeta meta = item.getItemMeta();
                if (e.getSlot() == 59) {
                    e.setCancelled(true);
                    player.closeInventory();
                    player.getInventory().remove(player.getInventory().getItemInMainHand());
                    Envelope.sealedEnvelopes.remove(Envelope.Envelopes.get(player.getItemOnCursor().getItemMeta().getLore().get(1)));
                    Envelope.Envelopes.remove(player.getItemOnCursor().getItemMeta().getLore().get(1));
                }
                if (e.getSlot() == 57 && !lore1.equals(Utils.chat("&aSealed, addressed"))) {
                    e.setCancelled(true);
                    EnchantmentGlow glow = new EnchantmentGlow(70);
                    List<String> lore = new ArrayList<>();

                    lore.add(Utils.chat("&aSealed, not addressed"));
                    lore.add(meta.getLore().get(1));

                    meta.addEnchant(glow, 1, true);
                    meta.setLore(lore);
                    itemEnvelope.setSealed(true);
                    item.setItemMeta(meta);
                    player.updateInventory();
                    player.closeInventory();
                }
            }
        }
    }
}
