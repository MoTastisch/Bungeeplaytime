package cf.motastish.bungeeplaytime.listeners;

import cf.motastish.bungeeplaytime.Bungeeplaytime;
import cf.motastish.bungeeplaytime.utils.datamanger;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class leave implements Listener {

    @EventHandler
    public void onPlayerDisconnectEvent(PlayerDisconnectEvent e) throws IOException {
        Date d1 = new Date();
        Date d2 = datamanger.login.get(e.getPlayer().getDisplayName());
        long diff = d1.getTime()-d2.getTime();
        long playime = (long) datamanger.readlong(e.getPlayer().getDisplayName()+".playtime");
        datamanger.writelong(e.getPlayer().getDisplayName()+".lastsession", diff/1000);
        datamanger.writelong(e.getPlayer().getDisplayName()+".playtime", playime+diff);
    }
}
