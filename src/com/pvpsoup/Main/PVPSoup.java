package com.pvpsoup.Main;

import com.pvpsoup.Listeners.Listeners;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author RiflemanSD
 */
public class PVPSoup  extends JavaPlugin {

    public static final Logger log = Logger.getLogger("Minecraft");
    public static PluginManager pluginManager;
    public static Listeners listeners;
    private static final String pluginName = "PvPSoup";
    
    @Override
    public void onDisable() {
        log.info(pluginName + " plugin has been disabled");
    }
    @Override
    public void onEnable() {
        pluginManager = this.getServer().getPluginManager();
        listeners = new Listeners();
        pluginManager.registerEvents(listeners, this);
        
        log.info(pluginName + " plugin has been enabled");
    }
}
