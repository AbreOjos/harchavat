package readresources.parameters;

import org.apache.log4j.Logger;
import readresources.ReadResourceParameters;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Get Database parameters from resources or system variables
 */
public class DbParameters {
    private static final Logger log = Logger.getLogger(DbParameters.class);

    //Database parameters
    private static Properties databaseConnectionProperties;

    private static final String DB_IP = "dbIP";
    private static final String DB_PORT = "dbPort";
    private static final String DB_USER = "dbUser";
    private static final String DB_PASS = "dbPass";
    private static final String SCHEMA_NET_EXPANSION = "schemaNetExpansion";

    static {
        try {
            databaseConnectionProperties = ReadResourceParameters.getDbConnectionProperties();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public static String getDbIP() {
        log.debug("Reading database IP parameter");

        return System.getProperty(DB_IP,
                databaseConnectionProperties.getProperty(DB_IP));
    }

    public static String getDbPort() {
        log.debug("Reading database port parameter");

        return System.getProperty(DB_PORT,
                databaseConnectionProperties.getProperty(DB_PORT));
    }

    public static String getDbUser() {
        log.debug("Reading database username parameter");

        return System.getProperty(DB_USER,
                databaseConnectionProperties.getProperty(DB_USER));
    }

    public static String getDbPass() {
        log.debug("Reading database password parameter");

        return System.getProperty(DB_PASS,
                databaseConnectionProperties.getProperty(DB_PASS));
    }

    public static String getSchemaNetExpansion() {
        log.debug("Reading database Schema Net Expansion parameter");

        return System.getProperty(SCHEMA_NET_EXPANSION,
                databaseConnectionProperties.getProperty(SCHEMA_NET_EXPANSION));
    }

}
