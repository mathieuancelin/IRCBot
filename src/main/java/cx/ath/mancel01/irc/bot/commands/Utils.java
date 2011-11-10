package cx.ath.mancel01.irc.bot.commands;

import cx.ath.mancel01.irc.bot.App;
import cx.ath.mancel01.irc.bot.Halbot;
import org.jibble.pircbot.PircBot;

public class Utils implements Command {

    public boolean matches(String channed, String sender, String message) {
        if (message.toLowerCase().contains("ping")) {
            return true;
        } else if (message.toLowerCase().contains("echo")) {
            return true;
        } else if (message.toLowerCase().contains("die")) {
            return true;
        }
        return false;
    }

    public void react(PircBot bot, String channel, String sender, String login, String hostname, String message) {
        if (message.toLowerCase().contains("ping")) {
            bot.sendMessage(channel, "PONG");
        } else if (message.toLowerCase().contains("echo")) {
            bot.sendMessage(channel, Halbot.getArg(message, "ECHO"));
        } else if (message.toLowerCase().contains("die")) {
            bot.sendMessage(channel, "Goodby cruel world !!!");
            System.exit(0);
        }
    }

    public String help() {
        return "Ask " + App.name + " for \"ping\", \"echo\" and \"die\"";
    }
}
