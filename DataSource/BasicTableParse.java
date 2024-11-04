import java.io.FileReader;

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
        int start = -1, end = -1;
        ArrayList<Point> positions = new ArrayList<Point>();
        ArrayList<String> sections = new ArrayList<String>();

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
                    positions.add(new Point(start, end));
                    start = -1;
                    end = -1;
                }
            }
        }

        for(int i = 0; i < positions.size(); i++) {
            
        }
    }

    public static String removeTags(String original) {
        StringBuffer section = new StringBuffer();
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
            section.append(original.charAt(i));
        }
        return String.valueOf(section);
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

