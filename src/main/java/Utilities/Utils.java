package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
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

    public String getRegistrationNumbers(){
        String textToParse = "TdkRoot(0x0)/Tdk(0x2,0x0)/Tdk(0x0,0x1)/VAL(40A8F0B32240,2x4)/SN(0000:0000:0000:0000:0000:0000:0000:0000)/IP(000.1.000.1)/Blue(2x4,2x4)";
        Pattern p = Pattern.compile("([A-Z]+\\d+\\s?[A-Z]*)");
        Matcher m = p.matcher(textToParse);
        while (m.find()) {
            System.out.println("key :" + m.group(1));
            System.out.println("key :" + m.group(2));
            System.out.println("key :" + m.group(3));
            System.out.println("key :" + m.group(4));

return "x";
        }

        public String readContent(fileContent){
            Path filePath = Path.of(x);
            String fileContent = "";
            StringBuilder contentBuilder = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null)
                {
                    contentBuilder.append(sCurrentLine).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

               fileContent = contentBuilder.toString();
            return fileContent;
        }

    }

}
