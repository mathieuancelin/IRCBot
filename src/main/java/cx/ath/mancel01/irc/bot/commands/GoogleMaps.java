package cx.ath.mancel01.irc.bot.commands;

import cx.ath.mancel01.irc.bot.App;
import cx.ath.mancel01.irc.bot.Halbot;
import cx.ath.mancel01.utils.F.Option;
import java.net.URLEncoder;
import org.jibble.pircbot.PircBot;

public class GoogleMaps implements Command {

    public boolean matches(String channed, String sender, String message) {
        if (message.toLowerCase().contains("map me")) {
            return true;
        }
        return false;
    }

    public void react(PircBot bot, String channel, String sender, String login, String hostname, String message) {
        Option<String> location = Option.maybe(Halbot.getArg(message, "map me"));
        String url = "http://maps.google.com/maps?q="
                + URLEncoder.encode(location.get())
                + "&hl=fr&sll=37.0625,-95.677068&sspn=73.579623,100.371094&vpsrc=0&hnear="
                + URLEncoder.encode(location.get()) + "&t=m&z=11";
        bot.sendMessage(channel, url);
    }

    public String help() {
        return "Ask " + App.name + " \"map me\" a place";
    }
}
