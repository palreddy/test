package Utilities;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static Properties properties;
    private final String propertyFilePath = "src/test/resources/properties/config.properties";

    public Utils() {
        properties = Utils.read(propertyFilePath);
    }

    public static Properties read(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + path);
        }
        return properties;
    }

    public Boolean compareresultsWithOutputFile(String path, String stringToCompare) {
        boolean contains = false;

        String textToParse = readContent(path);
        String[] expectedResult = textToParse.split("\\r?\\n");
        expectedResult = removeEmptyValues(expectedResult);
        contains = Arrays.stream(expectedResult).anyMatch(stringToCompare.trim()::equals);

        for (int i = 0; i < expectedResult.length; i++) {
        }
        return contains;
    }

    public String[] removeEmptyValues(String[] stringArray) {
        String[] expectedResults = new String[10];
        List<String> list = new ArrayList<String>();

        for (String s : stringArray) {
            if (s != null && s.length() > 0) {
                list.add(s);
            }
        }
        stringArray = list.toArray(new String[list.size()]);
        for (int i = 0; i < stringArray.length; i++) {
            expectedResults[i] = stringArray[i].trim();
        }
        return expectedResults;
    }

    public List getRegistrationNumbers(String path) {
        List<String> regNumbers = new ArrayList<>();
        String textToParse = readContent(path);
        Pattern p = Pattern.compile("([A-Z]+\\d+\\s?[A-Z]*)");
        Matcher m = p.matcher(textToParse);
        while (m.find()) {
            regNumbers.add(m.group(0));
        }
        return regNumbers;
    }

    public String formattedResult(String result) {
        String formattedResult = null;
        String[] results = result.split(":");

        for (int i = 1; i < results.length; i++) {
            String registration[] = results[i].split("\\r?\\n");

            String make = results[i + 1].trim().substring(0, results[i + 1].trim().indexOf(' ')); // "72"
            String model = results[i + 1].trim().substring(results[i + 1].trim().indexOf(' ') + 1);

            formattedResult = registration[i - 1] + "," + make + "," + model;
            break;
        }
        return formattedResult;
    }


    public String readContent(String path) {
        Path filePath = Path.of(path);
        String fileContent = "";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileContent = contentBuilder.toString();
        return fileContent;
    }


    public String readFromPropertiesFile(String key) {
        String value = (read(propertyFilePath)).getProperty(key);
        if (value != null) return value;
        else throw new RuntimeException("key not specified in the Configuration.properties file.");
    }


    public List readFromInputFiles() {
        File folder = new File(readFromPropertiesFile("input_file"));
        File[] listOfFiles = folder.listFiles();

        List regNumbers = null;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains("car_input")) {
                    regNumbers = getRegistrationNumbers(readFromPropertiesFile("input_file") + "/" + listOfFiles[i].getName());
                }
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        return regNumbers;
    }
}
