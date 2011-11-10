package cx.ath.mancel01.irc.bot.commands;

import cx.ath.mancel01.irc.bot.App;
import cx.ath.mancel01.irc.bot.Halbot;
import org.jibble.pircbot.PircBot;

public class Mustache implements Command {

    public boolean matches(String channed, String sender, String message) {
        if (message.toLowerCase().contains("mustache me")) {
            return true;
        }  else if (message.toLowerCase().contains("mustache me")) {
            return true;
        } 
        return false;
    }

    public void react(PircBot bot, String channel, String sender, String login, 
            String hostname, String message) {
        if (message.toLowerCase().contains("mustache me")) {
            bot.sendMessage(channel, sender + ", http://mustachify.me/?src=" 
                    + Halbot.getArg(message, "mustache me"));
        }  else if (message.toLowerCase().contains("mustache me")) {
            bot.sendMessage(channel, sender + ", http://mustachify.me/?src=" 
                    + Halbot.getArg(message, "moustache me"));
        } 
    }

    public String help() {
        return "Ask " + App.name + " \"mustache me\" with an image url";
    }
}
