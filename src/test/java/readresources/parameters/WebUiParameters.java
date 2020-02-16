package readresources.parameters;

import org.apache.log4j.Logger;
import readresources.ReadResourceParameters;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Get Users parameters from resources or system variables
 */
public class WebUiParameters {
    private static final Logger log = Logger.getLogger(WebUiParameters.class);

    private static Properties webUIProperties;

    private static final String HN_URL = "hnURL";

    static {
        try {
            webUIProperties = ReadResourceParameters.getWebUiProperties();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static String getHnUrl() {
        return System.getProperty(HN_URL,
                webUIProperties.getProperty(HN_URL));
    }

}
