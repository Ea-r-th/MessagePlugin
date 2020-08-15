package me.earth.messageplugin;

import me.earth.messageplugin.commands.GiveEnvelope;
import me.earth.messageplugin.commands.RenameEnvelope;
import me.earth.messageplugin.events.InventoryClick;
import me.earth.messageplugin.events.Mailbox;
import me.earth.messageplugin.events.PlayerLogon;
import me.earth.messageplugin.utils.EnchantmentGlow;
import org.bukkit.plugin.java.JavaPlugin;

public final class MessagePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        EnchantmentGlow.registerGlow();
        new PlayerLogon(this);
        new Mailbox(this);
        new RenameEnvelope(this);
        new GiveEnvelope(this);
        new InventoryClick(this);
    }
}
