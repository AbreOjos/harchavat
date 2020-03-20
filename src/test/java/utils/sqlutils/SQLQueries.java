package utils.sqlutils;

import org.apache.log4j.Logger;
import readresources.parameters.DbParameters;

import java.util.HashMap;
import java.util.Map;

/**
 * Prepared statements
 */
public class SQLQueries {

    private static final Logger log = Logger.getLogger(SQLQueries.class);

    // == public methods ==

    // == SELECT ==




    // == private methods ==


    private static Map<String, String> dataSourceParameters() {

        Map<String, String> dsParams = new HashMap<>();

        dsParams.put("user", DbParameters.getDbUser());
        dsParams.put("password", DbParameters.getDbPass());
        dsParams.put("servername", DbParameters.getDbIP());
        dsParams.put("portnumber", DbParameters.getDbPort());

        return dsParams;
    }

}
