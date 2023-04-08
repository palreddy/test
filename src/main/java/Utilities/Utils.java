package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static Properties properties;

    public Properties read(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            try {
                properties.load(reader);
                System.out.println("I am here");
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

    public List getRegistrationNumbers(String path) {
        List<String> regNumbers = new ArrayList<>();
        String  textToParse=  readContent(path);
        System.out.println("textToParse"+textToParse);
        Pattern p = Pattern.compile("([A-Z]+\\d+\\s?[A-Z]*)");
        Matcher m = p.matcher(textToParse);
        while (m.find()) {
            System.out.println("Group " + m.group(0));
            regNumbers.add(m.group(0));
            System.out.println("regNumbers " + regNumbers);

//            for (int i = 0; i <= m.groupCount(); i++) {
//                System.out.println("------------");
//                System.out.println("Group " + i + ": " + m.group(i));
//                //regNumbers.add(m.group(i));
//
//            }
          //  System.out.println();
        }

        return regNumbers;
    }


        public String readContent (String path) {
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



}
