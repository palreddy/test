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
    private final String propertyFilePath= "src/test/resources/properties/config.properties";
    public Utils() {
    properties= Utils.read(propertyFilePath);

    }
    public static Properties read(String path) {
        BufferedReader reader;
        try {
            System.out.println("path"+path);
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
    public Boolean compareresultsWithOutputFile(String path,String stringToCompare) {
        Boolean flag=false;
        System.out.println("......path in compare method"+path);
        String  textToParse=  readContent(path);
        if(textToParse.contains(stringToCompare)) {
            flag = true;
        }
      return flag;
    }
    public List getRegistrationNumbers(String path) {
        List<String> regNumbers = new ArrayList<>();
        String  textToParse=  readContent(path);
        Pattern p = Pattern.compile("([A-Z]+\\d+\\s?[A-Z]*)");
        Matcher m = p.matcher(textToParse);
        while (m.find()) {
            regNumbers.add(m.group(0));

        }

        return regNumbers;
    }

    public String orderResult (String result) {
        String[] results = result.split(":");
        return "x";
    }



        public String readContent (String path) {
        System.out.println("path.in read content.."+path);
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


        String value = (read(propertyFilePath)).getProperty(key);
        if(value != null) return value;
        else throw new RuntimeException("key not specified in the Configuration.properties file.");
    }


    public  List readFromInputFiles() {
        File folder = new File(readFromPropertiesFile("input_file"));
        File[] listOfFiles = folder.listFiles();


        List regNumbers = null;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains("car_input")) {
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



        FileWriter fileWriter = new FileWriter("src/test/resources/testData/input_file.csv");
        for (Object str : registrationNumbers) {
            fileWriter.write(str + System.lineSeparator());
        }
        fileWriter.close();


    }
    public String getTestData(String path,int number){

        String line = "";
        String splitBy = ",";
        String[] employee = new String[0];
        try
        {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
              employee = line.split(splitBy);    // use comma as separator
                System.out.println("Employee =" + employee.length);
                System.out.println("Employee =" + Arrays.stream(employee).toArray().toString());

                System.out.println("Employee [First Name=" + employee[0]);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       return employee[number];

}


}
