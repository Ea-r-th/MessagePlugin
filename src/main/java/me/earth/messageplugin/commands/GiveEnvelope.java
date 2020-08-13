package me.earth.messageplugin.commands;

import me.earth.messageplugin.MessagePlugin;
import me.earth.messageplugin.envelope.Envelope;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveEnvelope implements CommandExecutor {

    private MessagePlugin plugin;

    public GiveEnvelope(MessagePlugin plugin){
        this.plugin = plugin;

        plugin.getCommand("giveEnvelope").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            System.out.println("Error: Console cannot spawn an envelope");
            return true;
        }

        Player player = (Player) sender;

        Envelope envelope = new Envelope();

        player.getInventory().addItem(envelope.getEnvelopeItem());

        return false;
    }
}
