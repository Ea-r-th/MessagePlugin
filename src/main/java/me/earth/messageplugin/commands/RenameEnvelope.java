package me.earth.messageplugin.commands;

import me.earth.messageplugin.MessagePlugin;
import me.earth.messageplugin.envelope.Envelope;
import me.earth.messageplugin.utils.EnchantmentGlow;
import me.earth.messageplugin.utils.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RenameEnvelope implements CommandExecutor {

    private MessagePlugin plugin;

    public RenameEnvelope(MessagePlugin plugin){
        this.plugin = plugin;

        plugin.getCommand("addressEnvelope").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            System.out.println("Error: Console cannot set the address of an envelope!");
            return true;
        }

        Player player = (Player) sender;
        ItemStack envelopeItem = player.getInventory().getItemInMainHand();

        if(!envelopeItem.getType().equals(Material.GOLD_HOE)){
            player.sendMessage(Utils.chat("&4You must be holding a golden hoe to address it!"));
            return true;
        }
        if(args[0].equals(null)){
            player.sendMessage(Utils.chat("&4You must provide a sender!"));
            return true;
        }

        ItemMeta envelopeMeta = envelopeItem.getItemMeta();

        List<String> loreList = new ArrayList<>();
        String ID = envelopeMeta.getLore().get(1);

        loreList.add(Utils.chat("&aSealed, addressed"));
        loreList.add(ID);

        Envelope envelope = Envelope.Envelopes.get(ID);

        if(envelope.getEnvelopeItem().getItemMeta().getLore().get(0).equals(Utils.chat("&aSealed, addressed"))){
            player.sendMessage("This is already addressed!");
            return true;
        }

        if(envelope.getSealed()) {

            envelopeMeta.setDisplayName(Utils.chat("&bAddressed to: " + args[0]));
            envelope.setAddress(args[0]);
            envelopeMeta.setLore(loreList);
            envelopeItem.setItemMeta(envelopeMeta);
            envelope.setEnvelopeItem(envelopeItem);
            envelope.setSender(player.getDisplayName());
            envelope.getEnvelopeItem().getItemMeta().setDisplayName(Utils.chat(("&aMail from &b" + envelope.getSender())));

            Envelope.sealedEnvelopes.add(envelope);
        }
        else{
            player.sendMessage("You cannot address an unsealed envelope!");
        }
        return false;
    }
}
