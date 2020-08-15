package me.earth.messageplugin.events;

import me.earth.messageplugin.MessagePlugin;
import me.earth.messageplugin.envelope.Envelope;
import me.earth.messageplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerLogon implements Listener {

    private MessagePlugin plugin;

    public PlayerLogon(MessagePlugin plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerLogon(PlayerJoinEvent e){
        Player player = e.getPlayer();
        boolean hasMail = false;
        for (Envelope envelope:Envelope.sealedEnvelopes) {
            if(!hasMail){
                if (envelope.getAddress().equals(player.getDisplayName()) && envelope.isInMailbox() == true) {
                    hasMail = true;
                }
            }
        }
        if(hasMail){
            player.sendMessage(Utils.chat("&aYou have mail!"));
        }
    }
}
