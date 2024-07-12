package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

public class Utilities {

    public static String getRandomUsertName() {
        String[] names = {"Emma", "Olivia", "Ava", "Sophia", "Isabella", "Charlotte", "Mia", "Amelia", "Evelyn", "Abigail",
                "Noah", "steev", "moayad", "hogo", "swanan", "rami", "", "Mia", "Amelia", "Evelyn", "Abigail",
                "Noahradr", "Liamdf", "Liamfhf", "William", "Mason", "James", "hddfhf", "Aiden", "Lucas", "Logan", "Elijah"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }


    public static String getRandomLasttName() {
        String[] names = {"steev", "moayad", "hogo", "swanan", "rami", "", "Mia", "Amelia", "Evelyn", "Abigail",
                "Noah", "Liam", "William", "Mason", "James", "Benjamin", "Aiden", "Lucas", "Logan", "Elijah"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }


    public static String getRandomcompany() {
        String[] names = {"alfa", "beta", "test", "soso"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }


    public static String getRandomEmail() {
        // Define character sets for username and domain
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = lowercase.toUpperCase();
        String digits = "0123456789";
        String alphanumeric = lowercase + uppercase + digits;
        String specialChars = "!#$%&'*+/=?^_`{|}~";

        // Build the username with random combination of characters
        StringBuilder username = new StringBuilder();
        Random random = new Random();
        int usernameLength = random.nextInt(10) + 5; // Generate username between 5 and 14 characters
        for (int i = 0; i < usernameLength; i++) {
            int charType = random.nextInt(4); // Choose character type (lowercase, uppercase, digit, special)
            String charSet;
            switch (charType) {
                case 0:
                    charSet = lowercase;
                    break;
                case 1:
                    charSet = uppercase;
                    break;
                case 2:
                    charSet = digits;
                    break;
                default:
                    charSet = specialChars;
            }
            username.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        // Choose a random domain name from a predefined list (replace with your desired domains)
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com"};
        int domainIndex = random.nextInt(domains.length);

        // Combine username and domain
        return username.toString() + "@" + domains[domainIndex];
    }


    public static String generateRandomPassword(int passwordLength, int minUpperCase, int minLowerCase,
                                                int minDigits, int minSpecialChars) {

        // Character categories for password generation
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{};':\\\"|,<.>/?";

        // Character pool for password generation
        String charPool = "";

        if (minUpperCase > 0) {
            charPool = charPool + upperCaseLetters;
        }
        if (minLowerCase > 0) {
            charPool = charPool + lowerCaseLetters;
        }
        if (minDigits > 0) {
            charPool = charPool + digits;
        }
        if (minSpecialChars > 0) {
            charPool = charPool + specialChars;
        }

        // Ensure at least one character from each required category is included
        if (charPool.length() < passwordLength) {
            throw new IllegalArgumentException("Minimum character length not met with specified requirements.");
        }

        StringBuilder password = new StringBuilder(passwordLength);
        SecureRandom random = new SecureRandom();

        // Ensure at least one character from each required category
        if (minUpperCase > 0) {
            password.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
            minUpperCase--;
        }
        if (minLowerCase > 0) {
            password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
            minLowerCase--;
        }
        if (minDigits > 0) {
            password.append(digits.charAt(random.nextInt(digits.length())));
            minDigits--;
        }
        if (minSpecialChars > 0) {
            password.append(specialChars.charAt(random.nextInt(specialChars.length())));
            minSpecialChars--;
        }

        // Fill remaining password length with random characters from the pool
        for (int i = password.length(); i < passwordLength; i++) {
            password.append(charPool.charAt(random.nextInt(charPool.length())));
        }

        return password.toString();
    }


    public static int generateRandompoduct() {
        Random random = new Random();
        int randomNumber = random.nextInt(8) + 2; // Generate random int between 1 and 6
        //   return String.valueOf(randomNumber); // Convert the number to a String
        return randomNumber;
    }

    // read from json
    public static String getSingleJsonData(String jsonFilePath, String jsonField) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }


    //read from Excel

    public static String getExcelData(int RowNum, int ColNum, String SheetName) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        String projectPath = System.getProperty("user.dir");
        String cellData = null;
        try {
            workBook = new XSSFWorkbook(projectPath + "/src/test/resources/test_data/data.xlsx");
            sheet = workBook.getSheet(SheetName);
            cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return cellData;


    }

    public static int generateRandomnumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(1) + 1; // Generate random int between 1 and 2
        //   return String.valueOf(randomNumber); // Convert the number to a String
        return randomNumber;
    }

    public static String generateRandomamount() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; //
          return String.valueOf(randomNumber); // Convert the number to a String
        //return randomNumber;
    }


    // TODO: start html report
    public static void startHtmlReport(String reportDirName, String reportFileName) throws IOException {
        String path = System.getProperty("user.dir") + "/testReport.html";
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd " + reportDirName + " && " + reportFileName);
        builder.redirectErrorStream(true);
        Process p = builder.start();
    }
}