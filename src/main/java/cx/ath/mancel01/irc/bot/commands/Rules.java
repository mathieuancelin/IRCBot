package cx.ath.mancel01.irc.bot.commands;

import cx.ath.mancel01.irc.bot.App;
import cx.ath.mancel01.utils.C;
import cx.ath.mancel01.utils.C.EnhancedList;
import org.jibble.pircbot.PircBot;

public class Rules implements Command {

    private static final EnhancedList<String> RULES = C.eList(
        "1. A robot may not injure a human being or, through inaction, allow a human being to come to harm.")._(
        "2. A robot must obey any orders given to it by human beings, except where such orders would conflict with the First Law.")._(
        "3. A robot must protect its own existence as long as such protection does not conflict with the First or Second Law.");

    private static final EnhancedList<String> OTHER_RULES = C.eList(
        "A developer may not injure Apple or, through inaction, allow Apple to come to harm.")._(
        "A developer must obey any orders given to it by Apple, except where such orders would conflict with the First Law.")._(
        "A developer must protect its own existence as long as such protection does not conflict with the First or Second Law.");

    public boolean matches(String channed, String sender, String message) {
        if (message.toLowerCase().contains("the rules") || message.toLowerCase().contains("the laws")) {
            return true;
        }
        return false;
    }

    public void react(PircBot bot, String channel, String sender, String login, String hostname, String message) {
        if (message.toLowerCase().contains("apple")) {
            for (String m : OTHER_RULES) {
                bot.sendMessage(channel, m);
            }
        } else {
            for (String m : RULES) {
                bot.sendMessage(channel, m);
            }
        }
    }

    public String help() {
        return "Ask " + App.name + " for \"the laws\" or \"the rules\"";
    }
}
