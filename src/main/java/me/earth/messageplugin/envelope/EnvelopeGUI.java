package me.earth.messageplugin.envelope;

import me.earth.messageplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class EnvelopeGUI {

    public static int size = 7 * 9;

    public static Inventory createEnvelope(String inventoryName) {

        Inventory inv = Bukkit.createInventory(null, size, inventoryName);
        Utils.createItem(inv, 4, 34, 1, "&8Test Item", "&2The Greatest Item Ever");
        Utils.createItem(inv, 2, 17, 2, "&1Test Item 2", "&2Something else");
        Utils.createItemByte(inv, 95, 3, 1, 3, "&4Test with specific byte ID", "&2Should be specific color");
        Utils.createItemByte(inv, 35, 5, 1, 58, "&aSeal Envelope");
        Utils.createItemByte(inv, 35, 14, 1, 60, "&4Close");

        return inv;
    }
}
