package readresources;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

import static automation.tests.infra.helpers.resourceshelpers.ReadResources.getBufferedReader;

public class ReadResourceParameters {
    public static Properties getWebUiProperties() throws IOException, URISyntaxException {
        return new Gson().fromJson(getBufferedReader("connection_params/webUiParams.json"), Properties.class);
    }

    public static Properties getDbConnectionProperties() throws IOException, URISyntaxException {
        return new Gson().fromJson(getBufferedReader("connection_params/dbParams.json"), Properties.class);
    }
}
