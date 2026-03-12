package net.simpvp.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public class JoinListener implements Listener {

    private final JavaPlugin plugin;

    public JoinListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Delay in ticks (20 ticks = 1 second)
        int delay = 60; // 5 seconds

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            if (player.isOnline()) {
                player.performCommand("event");
            }
        }, delay);
    }
}