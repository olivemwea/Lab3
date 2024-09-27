package org.translation;

import java.util.ArrayList;
import java.util.List;

// Extra Task: if your group has extra time, you can add support for another country code in this class.

/**
 * An implementation of the Translator interface which translates
 * the country code "can" to several languages.
 */
public class InLabByHandTranslator implements Translator {

    public static final String CANADA = "can";

    /**
     * Returns the language abbreviations for all languages whose translations are
     * available for the given country.
     *
     * @param country the country
     * @return list of language abbreviations which are available for this country
     */

    @Override
    public List<String> getCountryLanguages(String country) {
        // TODO Checkstyle: The String "can" appears 4 times in the file.
        if ("can".equals(country)) {
            return new ArrayList<>(List.of("de", "en", "zh", "es", "fa", "it"));
        }
        return new ArrayList<>();
    }

    /**
     * Returns the country abbreviations for all countries whose translations are
     * available from this Translator.
     *
     * @return list of country abbreviations for which we have translations available
     */
    @Override
    public List<String> getCountries() {
        return new ArrayList<>(List.of("can"));
    }

    /**
     * Returns the name of the country based on the specified country abbreviation and language abbreviation.
     *
     * @param country  the country
     * @param language the language
     * @return the name of the country in the given language or null if no translation is available
     */
    @Override
    public String translate(String country, String language) {
        if (!"can".equals(country)) {
            return null;
        }
        String result = null;
        if ("de".equals(language)) {
            result = "Kanada";
        }
        else if ("en".equals(language)) {
            result = "Canada";
        }
        else if ("zh".equals(language)) {
            result = "加拿大";
        }
        else if ("es".equals(language)) {
            result = "Canadá";
        }
        else if ("fa".equals(language)) {
            result = "کانادا";
        }
        else if ("it".equals(language)) {
            result = "Canada";
        }
        return result;
    }
}
