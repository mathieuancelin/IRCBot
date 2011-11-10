package cx.ath.mancel01.irc.bot.util;

import java.util.Properties;

public class Property {
    
    private static final Properties props = new Properties();
    
    static {
        try {
            props.load(Property.class.getResourceAsStream("/config.properties"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static Boolean getBoolean(String name) {
        return Boolean.valueOf(props.getProperty(name));
    }
    
    public static String getString(String name) {
        return props.getProperty(name);
    }
    
    public static Integer getInteger(String name) {
        return Integer.valueOf(props.getProperty(name));  
    }
}
