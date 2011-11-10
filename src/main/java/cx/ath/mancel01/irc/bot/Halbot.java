package cx.ath.mancel01.irc.bot;

import cx.ath.mancel01.irc.bot.commands.Command;
import cx.ath.mancel01.irc.bot.commands.GoogleMaps;
import cx.ath.mancel01.irc.bot.commands.Help;
import cx.ath.mancel01.irc.bot.commands.Mustache;
import cx.ath.mancel01.irc.bot.commands.Rules;
import cx.ath.mancel01.irc.bot.commands.Time;
import cx.ath.mancel01.irc.bot.commands.Utils;
import cx.ath.mancel01.irc.bot.util.Property;
import cx.ath.mancel01.utils.SimpleLogger;
import java.util.ArrayList;
import java.util.List;
import org.jibble.pircbot.PircBot;

public class Halbot extends PircBot {
    
    public static final List<Command> commands = new ArrayList<Command>();
    
    static {
        commands.add(new GoogleMaps());
        commands.add(new Mustache());
        commands.add(new Rules());
        commands.add(new Time());
        commands.add(new Utils());
        commands.add(new Help());
    }

    public Halbot() {
        this.setName(Property.getString("bot.name"));
    }
    
    @Override
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        if (message.toLowerCase().startsWith(getName().toLowerCase() + " ")) {
            for (Command command : commands) {
                if (command.matches(channel, sender, message)) {
                    command.react(this, channel, sender, login, hostname, message);
                }
            }
        }
        SimpleLogger.trace("message from {} : {}", sender, message);
    }
    
    public void stop() {
        this.disconnect();
    }
    
    public static String getArg(String message, String delimiter) {
        return message.substring(message.toLowerCase().indexOf(delimiter.toLowerCase()) + (delimiter.length() + 1), message.length());
    }
}
