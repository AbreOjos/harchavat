package utils.utilitiesForInfra;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class StringModificationsForInfra {
    private static final Logger logger = Logger.getLogger(StringModificationsForInfra.class);

    private StringModificationsForInfra() {}

    public static String extractPositiveAndNegativeNumbers(String originalStr) {
        logger.debug(String.format("Extracting positive or negative digital from string %s", originalStr));

        String result = CharMatcher.inRange('0', '9').retainFrom(originalStr);

        if (StringUtils.isNotEmpty(result)) {
//            if (Pattern.compile("[\\s\\S]*-?\\d+[\\s\\S]*|[\\s\\S]*\\d+-?[\\s\\S]*").matcher(originalStr).matches()) {
            if(originalStr.contains("-")) {
                int number = Integer.parseInt(result) * -1;
                return String.valueOf(number);
            }
        }

        return result;
    }
}
