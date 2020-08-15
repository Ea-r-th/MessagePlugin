package me.earth.messageplugin.events;

import me.earth.messageplugin.MessagePlugin;
import me.earth.messageplugin.envelope.Envelope;
import me.earth.messageplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Mailbox implements Listener {

    private MessagePlugin plugin;

    public Mailbox(MessagePlugin plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onMailBoxClick(PlayerInteractEvent e) {
        EquipmentSlot equipmentSlot = e.getHand();
        if (equipmentSlot.equals(EquipmentSlot.HAND)) {
            Player player = e.getPlayer();
            ItemStack inHand = player.getInventory().getItemInMainHand();
            Block block = e.getClickedBlock();
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                Material type = block.getType();
                if (type == Material.SKULL) {
                    if (inHand.getType() == Material.GOLD_HOE) {
                        Envelope itemEnvelope = Envelope.Envelopes.get(inHand.getItemMeta().getLore().get(1));
                        String lore0 = inHand.getItemMeta().getLore().get(0);
                        String lore1 = inHand.getItemMeta().getLore().get(1);
                        if (lore0.equals(Utils.chat("&aSealed, addressed"))) {
                            player.getInventory().remove(inHand);
                            itemEnvelope.setInMailbox(true);
                            Envelope.Envelopes.put(lore1, itemEnvelope);
                            itemEnvelope.setSent(true);
                            System.out.println(Envelope.Envelopes.size());
                        } else {
                            player.sendMessage("You cannot send an unaddressed envelope!");
                        }
                    } else {
                        Inventory mailbox;
                        mailbox = Bukkit.createInventory(null, 45, Utils.chat("&5Mailbox"));

                        for (Envelope envelope:Envelope.sealedEnvelopes) {
                            if (envelope.getAddress().equals(player.getDisplayName()) && envelope.isInMailbox() == true) {
                                mailbox.addItem(envelope.getEnvelopeItem());
                            }
                        }
                        player.openInventory(mailbox);
                    }
                }
            } else if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                ItemStack itemInHand = player.getInventory().getItemInMainHand();
                Envelope itemEnvelope = Envelope.Envelopes.get(itemInHand.getItemMeta().getLore().get(1));
                List<String> lore = itemInHand.getItemMeta().getLore();
                String loreID = lore.get(1);
                if (itemInHand.getType().equals(Material.GOLD_HOE)) {
                    e.setCancelled(true);
                    if(itemEnvelope.getSealed() == false) {
                        player.openInventory(Envelope.Envelopes.get(loreID).getEnvelopeInventory());
                    }
                    else if(itemEnvelope.getSealed() == true){
                        if(itemEnvelope.getAddress().equals(player.getDisplayName())){
                            Inventory inHandInv = Envelope.Envelopes.get(player.getInventory().getItemInMainHand().getItemMeta().getLore().get(1)).getEnvelopeInventory();
                            player.openInventory(inHandInv);
                            inHandInv.setItem(57, null);
                        }
                    }
                }
            }
        }
    }
}
