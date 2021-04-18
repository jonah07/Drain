package net.ghastgames.drain.tests;

import net.ghastgames.drain.item.ItemFactory;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public class ItemFactoryTest {

    public static void main(String[] args) {
        ItemFactory itemFactory = new ItemFactory(Material.STONE_SWORD)
                .setAmount(1)
                .setEnchanted(true)
                .setSubId(1)
                .addEnchantment(Enchantment.ARROW_DAMAGE, 1);

        System.out.println(itemFactory.build());
    }
}
