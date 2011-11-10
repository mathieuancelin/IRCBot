package cx.ath.mancel01.irc.bot.commands;

import cx.ath.mancel01.irc.bot.App;
import org.jibble.pircbot.PircBot;

public class Time implements Command {

    public boolean matches(String channed, String sender, String message) {
        if (message.toLowerCase().contains("time")) {
            return true;
        }
        return false;
    }

    public void react(PircBot bot, String channel, String sender, String login, String hostname, String message) {
        String time = new java.util.Date().toString();
        bot.sendMessage(channel, sender + ": The time is now " + time);
    }

    public String help() {
        return "Ask " + App.name + " for \"time\"";
    }
}
