package Utilities;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static Properties properties;
    private final String propertyFilePath= "src/test/resources/properties/config.properties";
    public Utils() {
    properties= Utils.read(propertyFilePath);

    System.out.println("properties"+properties);
    }
    public static Properties read(String path) {
        System.out.println("im in read method");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            properties = new Properties();
            try {
                properties.load(reader);
                System.out.println("I am here......");
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + path);
        }
        System.out.println("I am before properties return");
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





    public  String readFromPropertiesFile(String key) {
        System.out.println("key"+key);
        System.out.println("properties2222222"+properties);

        String value = (read(propertyFilePath)).getProperty(key);
        System.out.println("............"+value);
        if(value != null) return value;
        else throw new RuntimeException("key not specified in the Configuration.properties file.");
    }


    public  List readFromInputFiles() {
        File folder = new File(readFromPropertiesFile("input_file"));
        System.out.println("folder" + folder);
        File[] listOfFiles = folder.listFiles();
        System.out.println("listOfFiles" + listOfFiles);


        List regNumbers = null;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                if (listOfFiles[i].getName().contains("car_input")) {
                    System.out.println("abc...." + readFromPropertiesFile("input_file") + "/" + listOfFiles[i]);
//utils.readContent(readFromPropertiesFile("input_file")+listOfFiles[i]);
                    regNumbers = getRegistrationNumbers(readFromPropertiesFile("input_file") + "/" + listOfFiles[i].getName());
                }
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        return regNumbers;
    }

    public void writeToFile(List registrationNumbers) throws IOException {
        FileWriter fileWriter = new FileWriter("src/test/resources/testData/input_file");
        for (Object str : registrationNumbers) {
            fileWriter.write(str + System.lineSeparator());
        }
        fileWriter.close();


    }


}
