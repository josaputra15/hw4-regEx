import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class DateFormation {
    public static void main(String[] args) {

        ArrayList<String> datesData = new ArrayList<>();


        String[] dateModel = {
            "(January|February|March|April|May|June|July|August|September|October|November|December) \\d{1,2}, \\d{4}",
            "\\d{1,2} (January|February|March|April|May|June|July|August|September|October|November|December), \\d{4}",
            "\\d{1,2}/\\d{1,2}/\\d{2}",
            "\\d{1,2}/\\d{1,2}/\\d{4}",
            "\\d{4}/\\d{1,2}/\\d{1,2}",
            "\\d{1,2}-\\d{1,2}-\\d{4}"
        };


        try {
            BufferedReader readerTxt = new BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = readerTxt.readLine()) != null) {
                for (String pattern : dateModel) {
                    Pattern regexPattern = Pattern.compile(pattern);
                    Matcher matcher = regexPattern.matcher(line);
                    
                    while (matcher.find()) {
                        datesData.add(matcher.group());
                    }
                }
            }
            readerTxt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (datesData.isEmpty()) {
            System.out.println("No dates found.");
        } else {
            System.out.println("Dates:");
            for (String date : datesData) {
                System.out.println(date);
            }
        }
    }
}
