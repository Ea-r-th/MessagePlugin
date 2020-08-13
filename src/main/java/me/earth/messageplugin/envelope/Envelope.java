package me.earth.messageplugin.envelope;

import me.earth.messageplugin.utils.Utils;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Envelope{

    public static HashMap<ItemStack, Envelope> Envelopes = new HashMap<>();

    private Inventory envelopeInventory;
    private ItemStack envelopeItem;
    private String address;

    public Envelope(){
        this.envelopeInventory = EnvelopeGUI.createEnvelope(Utils.chat("&5Envelope"));
        this.envelopeItem = Utils.createItemStack(294,1,Utils.chat("&6Envelope"),"Unsealed");
        this.address = null;
        Envelopes.put(this.envelopeItem, this);
    }

    public Inventory getEnvelopeInventory() {
        return envelopeInventory;
    }

    public ItemStack getEnvelopeItem() {
        return envelopeItem;
    }

    public String getAddress() {
        return address;
    }

    public void setEnvelopeInventory(Inventory inventory) {
        this.envelopeInventory = inventory;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
