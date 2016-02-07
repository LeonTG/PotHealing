package de.web.paulschwandes.pothealing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PotHealingCommand implements CommandExecutor {

    public static final String MESSAGE_FORMAT = ChatColor.RED + "Scenario PotHealing is now %s";

    private final Plugin plugin;
    private final Listener listener;
    private boolean enabled = false;

    public PotHealingCommand(Plugin plugin, Listener listener) {
        this.plugin = plugin;
        this.listener = listener;
    }

    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        enabled = !enabled;
        String message = String.format(MESSAGE_FORMAT, enabled ? "enabled" : "disabled");
        sender.sendMessage(message);

        if (enabled) {
            Bukkit.getPluginManager().registerEvents(listener, plugin);
        } else {
            HandlerList.unregisterAll(listener);
        }

        return true;
    }
}
