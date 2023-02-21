package cf.motastish.bungeeplaytime.listeners;

import cf.motastish.bungeeplaytime.Bungeeplaytime;
import cf.motastish.bungeeplaytime.utils.datamanger;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

public class join implements Listener {

    @EventHandler
    public void onjoin(PostLoginEvent e){
        datamanger.login.put(e.getPlayer(), new Date());
    }
}
