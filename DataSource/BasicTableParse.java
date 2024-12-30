import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* 
 *Description:
    Simple program to parse table body extracted from browser.
        Source: series of <td> rows between <tr> elements.
    GOAL:
        Extract contents of <tr> while leaving <tr> & <td> behind.
        Non-volitile/no changes made to source, simply output new CSV based on content of previous file.
*/
class BasicTableParse {
    public static void main(String[] args) {
        String fileString = fileContents("skillsRaw2.txt");
        ArrayList<String> sections = getSections(fileString);
        String[] formatted = new String[sections.size()];

        for(int i = 0; i < sections.size(); i++) {
            formatted[i] = formatSections(sections.get(i));
        }

        for(int i = 0; i < formatted.length; i++) {
            Pattern p = Pattern.compile("(,\"\")");
            Matcher m = p.matcher(formatted[i]);
            formatted[i] = m.replaceAll("");
            System.out.println(formatted[i]);    
        }

        writeCSV(formatted);
    }

    public static void writeCSV(String[] src) {
        String header = "ID,NAME,TYPE,SCHOOL,COST,STR,USE,RANGE,RARITY,DESCRIPTION,HOMING,NOTE\r\n";

        try (FileWriter writer = new FileWriter("test.csv")) {
            writer.write(header);
            for(int i = 0; i < src.length; i++) {
                writer.write(src[i]);
            }
        } catch (Exception e) {
            System.out.println("Failed with: " + e);
        }
    }

    public static ArrayList<String> getSections(String tableString){
        int start = -1, end = -1;
        ArrayList<String> sections = new ArrayList<String>();
        for(int i = 0; i < tableString.length(); i++) {
            if(tableString.charAt(i) == '<') {
                String slice = tableString.substring(i, i+4);
                if(slice.compareTo("<tr ") == 0) {
                    start = i;
                }
                if(slice.compareTo("</tr") == 0) {
                    end = i;
                }
                if(start != -1 && end != -1) {
                    sections.add(tableString.substring(start, end));
                    start = -1;
                    end = -1;
                }
            }
        }
        return sections;
    }

    public static String formatSections(String original) {
        StringBuilder stripped = new StringBuilder();
        boolean readingTag = false;
        boolean readingSpecial = false;

        for(int i = 0; i < original.length(); i++) {
            if(original.charAt(i) == '&'){
                readingSpecial = true;
            }else if(original.charAt(i) == ';'){
                readingSpecial = false;
                continue;
            }

            if(original.charAt(i) == '<') {
                readingTag = true;
            }
            else if(original.charAt(i) == '>') {
                readingTag = false;
                continue;
            }

            if(readingTag || readingSpecial) {
                continue;
            }

            if(original.charAt(i) != '\n' && original.charAt(i) != '\r'){
                stripped.append(original.charAt(i));
            } else if(original.charAt(i) == '\r') {
                stripped.append('"');
                stripped.append(',');
                stripped.append('"');
            }
        }
        stripped.replace(0, 2, "");
        stripped.replace(stripped.length()-2, stripped.length(), "");
        stripped.append("\r\n");
        return String.valueOf(stripped);
    }

    public static String fileContents(String path) {
        StringBuilder result = new StringBuilder();

        try (FileReader f = new FileReader(path);) {
            int nextChar;
            while((nextChar = f.read()) != -1){
                result.append((char) nextChar);
            }
            f.close();
        } catch (Exception e) {
            result.append("");
            System.out.println("Filename not found");
        }

        return result.toString();
    }
}

