package org.translation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides the service of converting language codes to their names.
 */
public class LanguageCodeConverter {

    private List<String> languagename;
    private List<String> languagecode;

    // TODO Task: pick appropriate instance variables to store the data necessary for this class

    /**
     * Default constructor which will load the language codes from "language-codes.txt"
     * in the resources folder.
     */
    public LanguageCodeConverter() {
        this("language-codes.txt");
    }

    /**
     * Overloaded constructor which allows us to specify the filename to load the language code data from.
     * @param filename the name of the file in the resources folder to load the data from
     * @throws RuntimeException if the resource file can't be loaded properly
     */
    public LanguageCodeConverter(String filename) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(getClass()
                    .getClassLoader().getResource(filename).toURI()));

            this.languagename = new ArrayList<>();
            this.languagecode = new ArrayList<>();

            for (int i = 1; i < lines.size(); i++) {
                String[] details = lines.get(i).split("\t");
                System.out.println(details[0]);
                System.out.println(details[1]);
                this.languagename.add(details[0]);
                this.languagecode.add(details[1]);
            }
            // TODO Task: use lines to populate the instance variable
            //           tip: you might find it convenient to create an iterator using lines.iterator()

        }
        catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * Returns the name of the language for the given language code.
     * @param code the language code
     * @return the name of the language corresponding to the code
     */
    public String fromLanguageCode(String code) {
        for (int i = 0; i < this.languagecode.size(); i++) {
            if (this.languagecode.get(i).equals(code)) {
                return this.languagename.get(i);
            }
        }
        // TODO Task: update this code to use your instance variable to return the correct value
        return null;
    }

    /**
     * Returns the code of the language for the given language name.
     * @param language the name of the language
     * @return the 2-letter code of the language
     */
    public String fromLanguage(String language) {
        for (int i = 0; i < this.languagename.size(); i++) {
            if (this.languagename.get(i).equals(language)) {
                return this.languagecode.get(i);
            }
        }
        // TODO Task: update this code to use your instance variable to return the correct value
        return null;
    }

    /**
     * Returns how many languages are included in this code converter.
     * @return how many languages are included in this code converter.
     */
    public int getNumLanguages() {

        // TODO Task: update this code to use your instance variable to return the correct value
        return this.languagename.size();
    }
}
