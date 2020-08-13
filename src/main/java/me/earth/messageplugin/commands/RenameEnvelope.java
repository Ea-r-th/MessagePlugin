package me.earth.messageplugin.commands;

import me.earth.messageplugin.MessagePlugin;
import me.earth.messageplugin.utils.EnchantmentGlow;
import me.earth.messageplugin.utils.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        ItemStack envelope = player.getInventory().getItemInMainHand();

        if(!envelope.getType().equals(Material.GOLD_HOE)){
            player.sendMessage(Utils.chat("&4You must be holding a golden hoe to address it!"));
            return true;
        }
        if(args[0] == null){
            player.sendMessage(Utils.chat("&4You must provide a sender!"));
            return true;
        }

        ItemMeta envelopeMeta = envelope.getItemMeta();

        EnchantmentGlow glow = new EnchantmentGlow(70);

        envelopeMeta.addEnchant(glow, 1, true);
        envelopeMeta.setDisplayName(Utils.chat("&b" + args[0]));
        envelope.setItemMeta(envelopeMeta);
        return false;
    }
}
