package constants;

import com.mysql.cj.exceptions.WrongArgumentException;

public class EnglishHebrewConstants {

    private EnglishHebrewConstants() {
    }

    // headers
    public static final String PERSONAL_DETAILS = "פרטים אישיים";
    public static final String VEHICLE_STATEMENT = "הצהרת רכב";
    public static final String WAGE = "שכר";
    public static final String REAL_ESTATE_REVENUE = "הכנסות מנדל\"ן";
    public static final String VARIOUS = "שונות";
    public static final String SEND_FORM = "שלח טופס";

    // months
    public static final String JANUARY = "ינואר";
    public static final String FEBRUARY = "פברואר";
    public static final String MARCH = "מרץ";
    public static final String APRIL = "אפריל";
    public static final String MAY = "מאי";
    public static final String JUNE = "יוני";
    public static final String JULY = "יולי";
    public static final String AUGUST = "אוגוסט";
    public static final String SEPTEMBER = "ספטמבר";
    public static final String OCTOBER = "אוקטובר";
    public static final String NOVEMBER = "נובמבר";
    public static final String DECEMBER = "דצמבר";

    public static String getMonth(String month) {
        switch (month) {
            case JANUARY:
                return "01";
            case FEBRUARY:
                return "02";
            case MARCH:
                return "03";
            case APRIL:
                return "04";
            case MAY:
                return "05";
            case JUNE:
                return "06";
            case JULY:
                return "07";
            case AUGUST:
                return "08";
            case SEPTEMBER:
                return "09";
            case OCTOBER:
                return "10";
            case NOVEMBER:
                return "11";
            case DECEMBER:
                return "12";
            default:
                throw new WrongArgumentException(String.format("Incorrect month name: %s", month));
        }
    }

    // marital statuses
    public static final String BACHELOR = "רווק";
    public static final String MARRIED = "נשוי";
    public static final String DIVORCEE = "גרוש";
    public static final String WIDOW = "אלמנ";
    public static final String ALLIANCE = "בברית הזוגיות";
    public static final String SEPARATED = "פרוד";
    public static final String POLYGAMY = "פוליגם";

    // real estate types
    public static final String APARTMENT = "דירה";
    public static final String UNIT = "יחידת דיור";
    public static final String STORAGE = "מחסן";
    public static final String PARKING = "חניה";
    public static final String PRIVATE_LAND = "קרקע פרטית";
    public static final String AGRICULTURAL_LAND = "קרקע חקלאית";
    public static final String REAL_ESTATE_OPTION = "אופציה במקרקעין";
    public static final String FARM = "משק חקלאי";
    public static final String REAL_ESTATE_UNION_ACTION = "פעולה באיגוד מקרקעין";
    public static final String OTHER_REAL_ESTATE = "אחר";
    public static final String REAL_ESTATE_TYPE = "סוג נדלן";

    // real estate usage
    public static final String PERSONAL_USAGE = "שימוש עצמי";
    public static final String FAMILY_USAGE = "בשימוש המשפחה";
    public static final String RENTING_USAGE = "השכרה";
    public static final String NOT_USING = "ללא שימוש";

    // cities
    public static final String JERUSALEM = "ירושלים";

    // countries
    public static final String ISRAEL = "ישראל";
    public static final String USA = "ארצות הברית";
    public static final String INCOME_ISRAEL = "הכנסה מהארץ";
    public static final String INCOME_ABROAD = "הכנסה מחו״ל";

    // error messages
    public static final String ENTER_LANDLINES_OR_MOBILE_PHONE = "יש להזין טלפון נייח או טלפון נייד";

    // boolean
    public static final String YES = "כן";
    public static final String NO = "לא";
    public static final String NOT_YET_REPORTED = "טרם דווח";

    // types and usages
    public static final String PRIVATE = "פרטי";
    public static final String COMMERCIAL = "מסחרי";
    public static final String HEAVY_ENGINEERING_EQUIPMENT = "ציוד הנדסי כבד";
    public static final String AIRCRAFT = "כלי טייס";
    public static final String VESSEL = "כלי שייט";
    public static final String BUSINESS = "עסקי";

    // user
    public static final String IGOR = "איגור";
    public static final String GINDIN = "גינדין";
}
