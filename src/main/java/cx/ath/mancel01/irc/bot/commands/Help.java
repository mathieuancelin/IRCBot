package cx.ath.mancel01.irc.bot.commands;

import cx.ath.mancel01.irc.bot.App;
import cx.ath.mancel01.irc.bot.Halbot;
import org.jibble.pircbot.PircBot;

public class Help implements Command {

    public boolean matches(String channed, String sender, String message) {
        if (message.toLowerCase().contains("help")) {
            return true;
        }
        return false;
    }

    public void react(PircBot bot, String channel, String sender, String login, String hostname, String message) {
        int i = 1;
        for (Command command : Halbot.commands) {
            bot.sendMessage(channel, i + ": " + command.help());
            i++;
        }
    }

    public String help() {
        return "Ask " + App.name + " for \"help\"";
    }
}
