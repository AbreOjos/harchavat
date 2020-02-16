package readresources.drivers;

import java.net.URISyntaxException;
import java.nio.file.Path;

import static automation.tests.infra.helpers.resourceshelpers.ReadResources.uriFromFilename;

public class WebDrivers {

    public static Path getChromeDriverWindows() throws URISyntaxException {
        return uriFromFilename("drivers/chromedriver.exe");
    }

    public static Path getChromeDriverUnix() throws URISyntaxException {
        return uriFromFilename("drivers/chromedriver");
    }

    public static Path getFirefoxDriverWindows() throws URISyntaxException {
        return uriFromFilename("drivers/geckodriver.exe");
    }

    public static Path getFirefoxDriverUnix() throws URISyntaxException {
        return uriFromFilename("drivers/geckodriver");
    }

    public static Path getIEDriverWindows() throws URISyntaxException {
        return uriFromFilename("drivers/IEDriverServer.exe");
    }
}
