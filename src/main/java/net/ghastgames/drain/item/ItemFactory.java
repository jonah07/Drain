package net.ghastgames.drain.item;

import net.minecraft.server.v1_8_R3.NBTBase;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemFactory {
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemFactory(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemFactory setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemFactory setEnchanted(boolean enchanted) {
        if(enchanted) {
            if(this.itemStack.getEnchantments().size() == 0) {
                this.itemStack.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
                this.itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
        } else {
            if(this.itemStack.getEnchantments().size() >= 1) {
                for(Enchantment enchantment : this.itemStack.getEnchantments().keySet()) {
                    this.itemStack.removeEnchantment(enchantment);
                }
                if(this.itemMeta.hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
                    this.itemMeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
                }
            }
        }
        return this;
    }

    public ItemFactory addEnchantment(Enchantment enchantment, int level) {
        this.itemStack.addEnchantment(enchantment, level);
        return this;
    }

    public ItemFactory setSubId(int subId) {
        this.itemStack.setDurability((short) subId);
        return this;
    }

    public ItemFactory setDisplayName(String displayName) {
        return setDisplayName(displayName, '§');
    }

    public ItemFactory setDisplayName(String displayName, char colorCodeChar) {
        if(colorCodeChar != '§') {
            this.itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes(colorCodeChar, displayName));
        } else {
            this.itemMeta.setDisplayName(displayName);
        }
        return this;
    }

    public ItemFactory setLore(String... lore) {
        return setLore('§', lore);
    }

    public ItemFactory setLore(char colorCodeChar, String... lore) {
        List<String> lines = Arrays.asList(lore);
        List<String> newLines = new ArrayList<>();

        if(colorCodeChar != '§') {
            for(String line : lines) {
                newLines.add(ChatColor.translateAlternateColorCodes(colorCodeChar, line));
            }
        } else {
            newLines = lines;
        }

        this.itemMeta.setLore(newLines);
        return this;
    }

    public ItemFactory setUnbreakable(boolean unbreakable, boolean hide) {
        if(unbreakable) {
            this.itemMeta.spigot().setUnbreakable(true);
            if(hide) {
                if(!this.itemMeta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE)) {
                    this.itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                }
            }
        } else {
            this.itemMeta.spigot().setUnbreakable(false);
            if(this.itemMeta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE)) {
                this.itemMeta.removeItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            }
        }
        return this;
    }

    public ItemFactory addNBTTag(String name, NBTBase value) {
        net.minecraft.server.v1_8_R3.ItemStack itemStack = CraftItemStack.asNMSCopy(this.itemStack);
        NBTTagCompound nbtTagCompound = itemStack.getTag();
        nbtTagCompound.set(name, value);
        itemStack.setTag(nbtTagCompound);
        this.itemStack = CraftItemStack.asBukkitCopy(itemStack);
        return this;
    }

    public ItemFactory addFlag(ItemFlag flag) {
        this.itemMeta.addItemFlags(flag);
        return this;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(itemMeta);
        return this.itemStack;
    }
}
