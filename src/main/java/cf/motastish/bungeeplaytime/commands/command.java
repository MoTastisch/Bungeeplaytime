package cf.motastish.bungeeplaytime.commands;

import cf.motastish.bungeeplaytime.Bungeeplaytime;
import cf.motastish.bungeeplaytime.utils.datamanger;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;

import java.time.Duration;
import java.util.Date;

public class command extends Command {
    static Plugin plugin = Bungeeplaytime.getInstance();
    public command() {
        super("bungeeplaytime");
    }
    public void execute(CommandSender sender, String[] args) {
        if(args.length==0){
            if(sender instanceof ProxiedPlayer){
                Duration duration = Duration.ofMillis((Long) datamanger.readlong(((ProxiedPlayer) sender).getDisplayName()+".playtime"));
                plugin.getLogger().info(String.valueOf(duration));
                Date login = datamanger.login.get(sender);
                Date now = new Date();
                long diff = now.getTime()-login.getTime();

                long seconds = datamanger.readlong(sender+".playtime")+diff/1000;
                long HH = seconds / 3600;
                long MM = (seconds % 3600) / 60;
                long SS = seconds % 60;
                sender.sendMessage("§8[§f§lS§fpielzeit§8] §e"+HH+" §7Stunden §e"+MM+" §7Minuten §e"+SS+" §7Sekunden ");
            } else {
                plugin.getLogger().warning("Bitte gib einen Spielernamen an!");

            }
        }


    }
}
