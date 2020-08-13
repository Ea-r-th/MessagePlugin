package me.earth.messageplugin;

import me.earth.messageplugin.commands.GiveEnvelope;
import me.earth.messageplugin.commands.RenameEnvelope;
import me.earth.messageplugin.envelope.EnvelopeItemChecker;
import me.earth.messageplugin.envelope.InventoryClick;
import me.earth.messageplugin.utils.EnchantmentGlow;
import org.bukkit.plugin.java.JavaPlugin;

public final class MessagePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        EnchantmentGlow.registerGlow();
        new RenameEnvelope(this);
        new GiveEnvelope(this);
        new EnvelopeItemChecker(this);
        new InventoryClick(this);
    }
}
