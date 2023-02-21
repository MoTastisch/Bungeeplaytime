package cf.motastish.bungeeplaytime;

import cf.motastish.bungeeplaytime.commands.command;
import cf.motastish.bungeeplaytime.listeners.join;
import cf.motastish.bungeeplaytime.listeners.leave;
import cf.motastish.bungeeplaytime.utils.datamanger;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.IOException;


public final class Bungeeplaytime extends Plugin {

    private static Bungeeplaytime instance;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;


        //Messages
        getLogger().info("Hello there :D");

        //Call the Datamanger
        try {
            new datamanger();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Register all commands etc.
        registerCommandsAndListeners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            datamanger.saveconfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Bungeeplaytime getInstance() {
        return instance;
    }

    //Method to register commands and listeners
    private void registerCommandsAndListeners() {
        getProxy().getPluginManager().registerListener(this, new join());
        getProxy().getPluginManager().registerListener(this, new leave());

        getProxy().getPluginManager().registerCommand(this, new command());

    }
}
