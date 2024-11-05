import java.io.FileReader;
import java.io.FileWriter;
//import java.lang.reflect.Array;
import java.awt.Point;
import java.util.ArrayList;

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
        
        String[] noTags = new String[sections.size()];
        
        for(int i = 0; i < sections.size(); i++) {
            noTags[i] = removeTags(sections.get(i));
            System.out.println(noTags[i]);
        }
        
        /* 
        for(int i = 0; i < noTags.length; i++){
            noTags[i] = csvFormatting(noTags[i]);
            System.out.println(noTags[i]);
        }
            */

    }

    public static void writeCSV(String[] src) {
        try (FileWriter writer = new FileWriter("test.csv")) {
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

    public static String removeTags(String original) {
        StringBuilder stripped = new StringBuilder();
        boolean readingTag = false;

        for(int i = 0; i < original.length(); i++) {
            if(original.charAt(i) == '<') {
                readingTag = true;
            }
            else if(original.charAt(i) == '>') {
                readingTag = false;
                continue;
            }
            if(readingTag) {
                continue;
            }

            if(original.charAt(i) != '\n' && original.charAt(i) != '\r'){
                stripped.append(original.charAt(i));
            } else if(original.charAt(i) == '\n') {
                stripped.append(',');
            }
        }
        stripped.replace(0, 4, "");
        stripped.append("\r\n");
        return String.valueOf(stripped);
    }

    public static String csvFormatting(String str) {
        StringBuilder sb = new StringBuilder(str);
        /*
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '\r' || sb.charAt(i) == '\n') {
                sb.deleteCharAt(i);
                sb.append(',');
            }
        }
        */
        sb.append("\r\n");

        //System.out.println(sb.toString());

        return sb.toString();
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

