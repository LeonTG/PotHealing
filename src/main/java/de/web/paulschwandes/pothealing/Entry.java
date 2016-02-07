package de.web.paulschwandes.pothealing;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Entry extends JavaPlugin {

    @Override
    public void onEnable() {
        CraftingListener listener = new CraftingListener();
        PotHealingCommand commandExecutor = new PotHealingCommand(this, listener);
        PluginCommand pluginCommand = getCommand("pothealing");
        pluginCommand.setExecutor(commandExecutor);
    }
}
