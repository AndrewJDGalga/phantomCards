import java.io.FileReader;

import java.awt.Point;
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
        int start = -1, end = -1;
        ArrayList<String> sections = new ArrayList<String>();

        //obtain sections
        for(int i = 0; i < fileString.length(); i++) {
            if(fileString.charAt(i) == '<') {
                String slice = fileString.substring(i, i+4);
                if(slice.compareTo("<tr ") == 0) {
                    start = i;
                }
                if(slice.compareTo("</tr") == 0) {
                    end = i;
                }
                if(start != -1 && end != -1) {
                    sections.add(fileString.substring(start, end));
                    start = -1;
                    end = -1;
                }
            }
        }

        System.out.println(removeTags(sections.get(0)));

        /*
        Pattern isolateContent = Pattern.compile("(<.*?>)");
        for(int i = 0; i < sections.size(); i++) {
            Matcher getContent = isolateContent.matcher(sections.get(i));
            String raw = getContent.replaceAll(",");
            String chopped = raw.substring(4, raw.length());
            sections.set(i, chopped);
            System.out.println(sections.get(i));
        }
            */
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
                stripped.append(',');
                continue;
            }
            if(readingTag) {
                continue;
            }
            stripped.append(original.charAt(i));
        }
        stripped.replace(0, 4, "");
        stripped.append('\n');
        return String.valueOf(stripped);
    }

    public static String fileContents(String path) {
        StringBuffer result = new StringBuffer();

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

        return String.valueOf(result);
    }
}

