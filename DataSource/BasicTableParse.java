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
        //int start = 0, end = 0, oldStart = 0, oldEnd = 0;
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

        /*
        String example = """
        <tr class='row-attack'>
        <td>001</td>
        <td>Psycho Wave</td>
        <td>Attack</td>
        <td>Psycho</td>
        <td>&nbsp;</td>
        <td>4</td>
        <td>X</td>
        <td>1</td>
        <td>short</td>
        <td>4</td>
        <td>STR = target's Level</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>""";
        */

        /*
        for(int i = 0; i < example.length(); i++) {
            if(example.charAt(i) == '<') {
                String slice = example.substring(i, i+4);
                if(slice.compareTo("<tr ") == 0) {
                    start = i;
                }
                if(slice.compareTo("</tr") == 0) {
                    end = i;
                }
            }
        }
            */
        

        /*
        for(int i = 0; i < fileString.length(); i++) {
            if(fileString.charAt(i) == '<') {
                if(fileString.charAt(i+1) == 't' && fileString.charAt(i+2) == 'r') {
                    start = i;
                }
                else if(fileString.charAt(i+1) == '/' && fileString.charAt(i+2) == 't' && fileString.charAt(i+3) == 'r'){
                    end = i;
                    System.out.println(fileString.charAt(i+3));
                }
            }
            
            if(start > oldStart && end != oldEnd && start <= end) {
                //System.out.println(fileString.charAt(i));
                oldStart = start;
                oldEnd = end;
            }
                
            /*
            if(start > oldStart && end != oldEnd) {
                System.out.println("____Section____");
                System.out.println(fileString.substring(start, end));
                //System.out.println(start);
                //System.out.println(end);
                //System.out.println(fileString.length());
                System.out.println("____EndSection____");
                oldStart = start;
                oldEnd = end;
            }
              
        }*/
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

