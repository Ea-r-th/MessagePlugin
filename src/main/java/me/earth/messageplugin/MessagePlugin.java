package me.earth.messageplugin;

import me.earth.messageplugin.commands.OpenEnvelope;
import me.earth.messageplugin.envelope.EnvelopeGUI;
import me.earth.messageplugin.envelope.InventoryClick;
import org.bukkit.plugin.java.JavaPlugin;

public final class MessagePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new OpenEnvelope(this);
        new InventoryClick(this);
        EnvelopeGUI.init();
    }
}
