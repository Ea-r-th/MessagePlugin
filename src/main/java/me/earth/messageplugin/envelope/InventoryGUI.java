package me.earth.messageplugin.envelope;

import me.earth.messageplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryGUI {

    public static int size = 7 * 9;

    public static Inventory createEnvelope(String inventoryName){

        Inventory inv = Bukkit.createInventory(null, size, inventoryName);

        Utils.createItemByte(inv, 35, 5, 1, 58, "&aSeal Envelope");
        Utils.createItemByte(inv, 35, 14, 1, 60, "&4Delete Envelope");

        return inv;
    }
}
