package me.earth.messageplugin.envelope;

import me.earth.messageplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class EnvelopeGUI {

    public static Inventory inv;
    public static String inventoryName;
    public static int size = 5 * 9;

    public static void init() {
        inventoryName = Utils.chat("&bEnvelope");

        inv = Bukkit.createInventory(null, size);
        Utils.createItem(inv, 4, 34, 1, "&8Test Item", "&2The Greatest Item Ever");
        Utils.createItem(inv, 2, 17, 2, "&1Test Item 2", "&2Something else");
        Utils.createItemByte(inv, 95, 1, 3, 3, "&ATest with specific byte ID", "&2Should be specific color");
    }

    public static Inventory GUI() {
        Inventory returnInv = Bukkit.createInventory(null, size, inventoryName);

        returnInv.setContents(inv.getContents());
        return returnInv;
    }

    public static void setInv(Inventory inv) {
        EnvelopeGUI.inv = inv;
    }
}
