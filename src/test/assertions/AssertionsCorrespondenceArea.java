package assertions;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

import static constants.StringConstants.NO_INFO;


public class AssertionsCorrespondenceArea {
    private static final Logger log = Logger.getLogger(AssertionsCorrespondenceArea.class);

    public static void assertListNotEmpty(List list, String... additionalInfo) {
        log.debug("Checking that List is not empty");

        Assert.assertFalse(list.isEmpty(),
                String.join(" ", additionalInfo) + " List is empty");
    }

    public static void assertListEmpty(List list, String... additionalInfo) {
        log.debug("Checking that List is empty");

        Assert.assertTrue(list.isEmpty(), String.join(" ", additionalInfo) + " List is NOT empty");
    }

    public static void assertListContainsExactNumberOfElements(List list, int elementsQuantity, String... additionalInfo) {
        log.debug(String.format("Checking that list contains %d elements", elementsQuantity));

        Assert.assertTrue(list.size() == elementsQuantity,
                String.join(" ", additionalInfo)
                + " Number elements in the list incorrect, " +
                "expected " + elementsQuantity + " but found " + list.size());
    }

    public static void assertListOfListsContainsSubstring(List<List<String>> listList, String substring) {
        log.debug("Checking that any element in any sublist contains substring");
        listList.forEach(l -> assertListContainsSubstring(l, substring));
    }

    public static void assertListDoesNotContainsString(List<String> stringList, String substring,
                                                       String... additionalInfo) {
        log.debug("Checking that list does not contains string");
        Assert.assertTrue(
                stringList.stream().noneMatch(substring::equalsIgnoreCase),
                String.join(" ", additionalInfo)
        );
    }

    public static void assertListContainsSubstring(List<String> stringList, String substring,
                                                   String... additionalInfo) {
        log.debug("Checking that any element in list contains substring");
        Assert.assertTrue(
                stringList.stream().anyMatch(s -> containsSubstring(s, substring)),
                String.join(" ", additionalInfo)
        );
    }

    public static void assertListContainsGivenStringOnly(List<String> stringList, String givenString,
                                                         String... additionalInfo) {
        log.debug("Checking that every element in list equal to given string");
        Assert.assertTrue(
                stringList.stream().allMatch(s -> s.equals(givenString)),
                String.join(" ", additionalInfo)
        );
    }

    public static void assertListStringsContainsSubstring(List<String> stringList, String substring, String... additionalInfo) {
        log.debug("Checking that list contains strings by pattern only");
        stringList.forEach(s -> assertTextContainsSubstring(s, substring, additionalInfo));
    }

    public static void assertTextContainsSubstring(String text, String substring,
                                                   String... additionalInfo) {
        log.debug("Checking that text contains substring");

        Assert.assertTrue(containsSubstring(text, substring),
                String.join(" ", additionalInfo)
        );
    }

    public static void assertTextNotContainsSubstring(String text, String substring,
                                                      String... additionalInfo) {
        log.debug("Checking that text not contains substring");

        Assert.assertFalse(containsSubstring(text, substring),
                String.join(" ", additionalInfo)
        );
    }

    public static void assertElementContainsText(WebElement webElement, String expectedText) {
        log.debug(String.format("Checking that WebElement contains text '%s'", expectedText));

        Assert.assertTrue(webElement.getText().toLowerCase().contains(expectedText.toLowerCase()),
                String.format("Text '%s' not found in WebElement", expectedText));
    }

    public static void assertTitle(WebDriver driver, String expectedText) {
        log.debug(String.format("Checking that Title of page contains text '%s'", expectedText));

        Assert.assertEquals(driver.getTitle().toLowerCase(), expectedText.toLowerCase(), "incorrect title");
    }

    public static void assertElementEnabledOrDisabled(WebElement webElement, boolean isEnabled, String... additionalInfo) {
        log.debug("check is element enabled or disabled");

        Assert.assertEquals(webElement.isEnabled(), isEnabled,
                String.format("Expected WebElement '%s' enabled = %s, actually it = %s",
                        String.join(" ", additionalInfo), isEnabled, webElement.isEnabled()));
    }

    public static void assertWebpageContainsText(WebDriver driver, String expectedText) {
        log.debug(String.format("Checking that text '%s' found on webpage", expectedText));

        Assert.assertTrue(driver.getPageSource().toLowerCase().contains(expectedText.toLowerCase()),
                String.format("text '%s' was not found on webpage", expectedText));
    }

    public static void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
        log.debug(String.format("Checking that HTTP request status code is '%s'", expectedStatusCode));

        Assert.assertEquals(actualStatusCode, expectedStatusCode, "HTTP request status code incorrect");
    }

    public static void assertTwoUnsortedListsEqual(List<String> webPageList, List<String> apiList, String... additionalInfo) {

        // apiList was created by API
        // if it contains null a webpage list must display "no information"
        // for simplifying comparing with webPageList all null's in the apiList will be changed
        // to "no information"

        apiList = changeNullToNoInfo(apiList);

        webPageList = listToLowerCase(webPageList);

        apiList = listToLowerCase(apiList);

        webPageList = listOfStringsNormalization(webPageList);

        apiList = listOfStringsNormalization(apiList);

        Collections.sort(webPageList);
        Collections.sort(apiList);

        String message
                = webPageList.toString() + " : " + apiList.toString() + ". " + String.join(" ", additionalInfo);

        Assert.assertEquals(webPageList, apiList, message);
    }

    public static void assertTwoSortedListsEqual(List<String> webPageList, List<String> apiList, String... additionalInfo) {

        // apiList was created by API
        // if it contains null a webpage list must display "no information"
        // for simplifying comparing with webPageList all null's in the apiList will be changed
        // to "no information"

        apiList = changeNullToNoInfo(apiList);

        webPageList = listToLowerCase(webPageList);

        apiList = listToLowerCase(apiList);

        webPageList = listOfStringsNormalization(webPageList);

        apiList = listOfStringsNormalization(apiList);

        String message
                = webPageList.toString() + " : " + apiList.toString() + ". " + String.join(" ", additionalInfo);

        Assert.assertEquals(webPageList, apiList, message);
    }


    public static void assertTwoMapsOfListsEquals(Map<Integer, List<String>> firstMap, Map<Integer, List<String>> secondMap) {

        for (List<String> list : firstMap.values())
            list.sort(Comparator.nullsLast(Comparator.naturalOrder()));

        for (List<String> list : secondMap.values())
            list.sort(Comparator.nullsLast(Comparator.naturalOrder()));

        assertTwoMapsEqual(firstMap, secondMap);
    }

    public static void assertTwoMapsEquals(Map firstMap, Map secondMap) {


        assertTwoMapsEqual(firstMap, secondMap);
    }


    public static void assertTwoListOfListsEquals(List<List<String>> webList, List<List<String>> apiList) {
//        Assert.assertEquals(new HashSet(apiList), new HashSet(webList));

//        for (List<String> web : webList) {
//            Collections.sort(web);
//        }
//
//        for (List<String> api : apiList) {
//            Collections.sort(api);
//        }

//        log.info("GINDIN LOG\nWEBLIST:\n" + webList + "APILIST:\n" + apiList);

        Assert.assertEquals(webList, apiList);

//        Assert.assertTrue(webList.containsAll(apiList) && apiList.containsAll(webList), "List taken from webpage \n" + webList +
//                "\n not equals to list created with api \n" + apiList);

    }

//    public static void assertTwoMapsEqual(Map<Integer, List<List<String>>> firstMap, Map<Integer, List<String>> secondMap) {
//        Assert.assertEquals(firstMap, secondMap,
//                "Maps unequal.\nFirst map:\n" + firstMap + "\nSecond map:\n" + secondMap);
//    }

    public static void assertTwoObjectsEqual(Object webObject, Object sqlObject, String... additionalInfo) {
        Assert.assertEquals(webObject, sqlObject, String.join(" ", additionalInfo));
    }



    public static <T extends Comparable>void assertTwoUnsortedCollectionsEqual(Collection<T> fromWebPage, Collection<T> fromDatabase, String... additionalInfo) {

        List<T> fromWeb = new ArrayList<>(fromWebPage);
        List<T> fromDB = new ArrayList<>(fromDatabase);

        Collections.sort(fromWeb);
        Collections.sort(fromDB);

        Assert.assertEquals(fromWeb, fromDB, String.join(" ", additionalInfo));
    }

    public static <T extends Comparable>void assertOneCollectionContainsAnother(Collection<T> fromWebPage, Collection<T> fromDatabase, String... additionalInfo) {

        List<T> fromWeb = new ArrayList<>(fromWebPage);
        List<T> fromDB = new ArrayList<>(fromDatabase);

        Assert.assertEquals(fromWeb.size(), fromDB.size(), String.join(" ", additionalInfo));

        Assert.assertTrue(fromWeb.containsAll(fromDB), String.join(" ", additionalInfo));
    }

    public static <T extends Comparable>void assertTwoSortedCollectionsEqual(Collection<T> fromWebPage, Collection<T> fromDatabase, String... additionalInfo) {

        List<T> fromWeb = new ArrayList<>(fromWebPage);
        List<T> fromDB = new ArrayList<>(fromDatabase);

        Assert.assertEquals(fromWeb, fromDB, String.join(" ", additionalInfo));
    }

    public static void assertCompareTwoStringsAfterNormalization(String actual, String expected, String... additionalInfo) {
        actual = StringUtils.normalizeSpace(actual);
        expected = StringUtils.normalizeSpace(expected);

        Locale locale = new Locale("he");

        Assert.assertEquals(actual.toLowerCase(locale), expected.toLowerCase(locale),
                String.format(
                        "Actual string (%s) does not match with Expected string (%s). %s",
                        actual, expected, String.join(" ", additionalInfo))
        );
    }

    public static void assertTwoNumbersAreEqual(Number actualNumber, Number expectedNumber, String... additionalInfo) {
        Assert.assertEquals(actualNumber, expectedNumber,
                String.join(" ", additionalInfo));
    }

    public static void assertTwoNumbersAreNotEqual(Number actualNumber, Number expectedNumber, String... additionalInfo) {
        Assert.assertNotEquals(actualNumber, expectedNumber,
                String.join(" ", additionalInfo));
    }

    // == private methods ==
    private static boolean containsSubstring(String text, String substring) {
        text = StringUtils.normalizeSpace(text);
        substring = StringUtils.normalizeSpace(substring);

        Locale locale = new Locale("he");

        return text.toLowerCase(locale).contains(substring.toLowerCase(locale));
    }

    /**
     * list was created by API
     * if it contains null a webpage list must display "no information"
     * for simplifying comparing all null's in the list will be changed
     * to "no information" value
     *
     * @param list
     * @return
     */
    private static List<String> changeNullToNoInfo(List<String> list) {
        if (list == null)
            return Collections.emptyList();
        else
            return list.stream()
                    .map(x -> (x == null) ? NO_INFO : x)
                    .collect(Collectors.toList());
    }

    private static List<String> listToLowerCase(List<String> list) {
        if (list == null)
            return Collections.emptyList();
        else
            return list
                    .stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
    }

    private static List<String> listOfStringsNormalization(List<String> list) {
        if (list == null)
            return Collections.emptyList();
        else
            return list
                    .stream()
                    .map(StringUtils::normalizeSpace)
                    .collect(Collectors.toList());
    }

    private static void assertTwoMapsEqual(Map firstMap, Map secondMap) {

        Assert.assertEquals(firstMap, secondMap,
                "Maps unequal.\nFirst map:\n" + firstMap + "\nSecond map:\n" + secondMap);
    }
}

