package cx.ath.mancel01.irc.bot.commands;

import org.jibble.pircbot.PircBot;

public interface Command {

    boolean matches(String channel, String sender, String message);

    void react(PircBot bot, String channel, String sender,
            String login, String hostname, String message);
    
    String help();
}
