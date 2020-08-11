package me.earth.messageplugin.commands;

import me.earth.messageplugin.MessagePlugin;
import me.earth.messageplugin.envelope.EnvelopeGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenEnvelope implements CommandExecutor {

    private MessagePlugin plugin;

    public OpenEnvelope(MessagePlugin plugin){
        this.plugin = plugin;

        plugin.getCommand("openenvelope").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            System.out.println("Error: Console cannot open an envelope!");
            return true;
        }

        Player player = (Player) sender;

        player.openInventory(EnvelopeGUI.GUI());
        return false;
    }
}
