package me.earth.messageplugin.envelope;

import me.earth.messageplugin.utils.Utils;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Envelope{

    public static HashMap<String, Envelope> Envelopes = new HashMap<>();
    public static List<Envelope> sealedEnvelopes= new ArrayList<>();
    Random random = new Random();

    private Inventory envelopeInventory;
    private ItemStack envelopeItem;
    private String address;
    private boolean isSealed;
    private boolean isSent;
    private boolean isInMailbox;
    private String sender;

    public Envelope(){
        int ID = random.nextInt(100000);
        while(Envelopes.keySet().contains(ID)) {
            ID = random.nextInt(100000);
        }
        this.envelopeInventory = InventoryGUI.createEnvelope(Utils.chat("&5Envelope"));
        this.envelopeItem = Utils.createItemStack(294,1,Utils.chat("&6Envelope"), Utils.chat("&3Unsealed"), "ID# " + ID);
        this.address = null;
        this.isSealed = false;
        this.isSent = false;
        this.isInMailbox = false;
        this.sender = null;
        List<String> lore = envelopeItem.getItemMeta().getLore();

        Envelopes.put(lore.get(1), this);
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

    public void setEnvelopeItem(ItemStack envelopeItem) {
        this.envelopeItem = envelopeItem;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public boolean isInMailbox() {
        return isInMailbox;
    }

    public void setInMailbox(boolean inMailbox) {
        isInMailbox = inMailbox;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSealed(boolean canOpen) {
        this.isSealed = canOpen;
    }

    public boolean getSealed() {
        return isSealed;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
