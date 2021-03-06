package me.earth.messageplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String chat(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public static ItemStack createItem(Inventory inv, int materialID, int amount, int invSlot, String displayName, String... loreString){

        ItemStack item;
        List<String> lore = new ArrayList<>();

        item = new ItemStack(Material.getMaterial(materialID), amount);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for(String s:loreString){
            lore.add(Utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        inv.setItem(invSlot - 1, item);
        return item;
    }

    public static ItemStack createItemByte(Inventory inv, int materialID, int byteID, int amount, int invSlot, String displayName, String... loreString){

        ItemStack item;
        List<String> lore = new ArrayList<>();

        item = new ItemStack(Material.getMaterial(materialID), amount, (short) byteID);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for(String s:loreString){
            lore.add(Utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        inv.setItem(invSlot - 1, item);
        return item;
    }

    public static ItemStack createItemStack(int materialID, int amount, String displayName, String... loreString){
        ItemStack item;
        List<String> lore = new ArrayList<>();

        item = new ItemStack(Material.getMaterial(materialID), amount);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for(String s:loreString){
            lore.add(Utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
