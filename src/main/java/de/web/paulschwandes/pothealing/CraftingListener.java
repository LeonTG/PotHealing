package de.web.paulschwandes.pothealing;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class CraftingListener implements Listener {

    // Highest priority  to be after the UHC plugin to check for golden heads
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    @SuppressWarnings("unused")
    protected void on(PrepareItemCraftEvent event) {
        CraftingInventory inventory = event.getInventory();
        ItemStack result = inventory.getResult();

        if (result == null) {
            return;
        }

        if (!result.getType().equals(Material.GOLDEN_APPLE)) {
            return;
        }

        if (result.getDurability() != 0) {
            return;
        }

        boolean isGoldenHead = result.hasItemMeta() && result.getItemMeta().hasDisplayName();
        int potionLevel = isGoldenHead ? 2 : 1;
        
        Potion potion = new Potion(PotionType.INSTANT_HEAL, potionLevel);
        ItemStack potionItemStack = potion.toItemStack(1);
        inventory.setResult(potionItemStack);
    }
}
