package cf.motastish.bungeeplaytime.utils;

import cf.motastish.bungeeplaytime.Bungeeplaytime;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import java.io.*;
import java.util.Date;
import java.util.HashMap;

public class datamanger {
    static Plugin plugin = Bungeeplaytime.getInstance();
    static Configuration configuration;

    public static HashMap<ProxiedPlayer, Date> login = new HashMap<>();

    public datamanger() throws IOException {
        loadconfig();
    }

    private void loadconfig() throws IOException {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        File configFile = new File(plugin.getDataFolder(), "data.yml");
        if (!configFile.exists()) {
            FileOutputStream outputStream = new FileOutputStream(configFile); // Throws IOException
            InputStream in = plugin.getResourceAsStream("data.yml"); // This file must exist in the jar resources folder
            in.transferTo(outputStream); // Throws IOException
        }
        configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(plugin.getDataFolder(), "data.yml"));
    }

    public static void saveconfig() throws  IOException {
        ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, new File(plugin.getDataFolder(), "data.yml"));
    }

    public static void write(String name, String value){
        configuration.set(name, value);
    }
    public static void writelong(String name, Long value){
        configuration.set(name, value);
    }
    public static Object read(String name){

        return configuration.get(name);
    }
    public static Object readlong(String name){
        return configuration.getLong(name);
    }

}
