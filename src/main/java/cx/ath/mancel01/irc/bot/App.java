package cx.ath.mancel01.irc.bot;

import cx.ath.mancel01.irc.bot.util.Property;
import cx.ath.mancel01.utils.SimpleLogger;

public class App {
    
    private static Halbot bot = new Halbot();
    
    private static final Boolean verboseMode = Property.getBoolean("bot.verbose");
    
    private static final String hostName = Property.getString("bot.server");

    private static final String channels = Property.getString("bot.channels");
    
    public static final String name = Property.getString("bot.name");
        
    static {
        SimpleLogger.enableColors(true);
        SimpleLogger.enableTrace(true);
    }
    
    public void startBot() throws Exception {
        bot.setVerbose(verboseMode);
        bot.connect(hostName);
        for (String channel : channels.split(",")) {
            bot.joinChannel(channel);
        }
    }
    
    public static void main(String... args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                bot.stop();
            }
        });
        new App().startBot();
    }
}
