import java.io.FileReader;
import java.util.Arrays;

class CSVToSQL {
    public static void main(String[] args) {
        String fileString = fileContents("test.csv");
        int headEnd = fileString.indexOf('\n');
        String head = fileString.substring(0, headEnd);
        head = head.replace("RARITY,","");
        String minusHead = fileString.substring(headEnd, fileString.length());
        String headerQuery = createSQLTableQuery(head);
        
        StringBuffer valueInsertQuery = new StringBuffer("insert into skills(");
        valueInsertQuery.append(head);
        valueInsertQuery.insert(valueInsertQuery.length()-1, ") value(");

        StringBuffer test = new StringBuffer();
        for(int i = 0; i < minusHead.length(); i++){
            test.append(minusHead.charAt(i));
            if(minusHead.charAt(i) == '\n' && i > 0) {
                test.delete(test.length()-3, test.length());
                //test.deleteCharAt(test.length()-3);
                test.append("), (");
                //System.out.println("Test: " + test);
                valueInsertQuery.append(test);
                break;
            }
        }
        
        //valueInsertQuery.append(minusHead);
        System.out.println(valueInsertQuery);
    }

    static String createSQLTableQuery(String head) {
        String[] brokenHead = head.split(",");
        brokenHead[0] += " INT PRIMARY KEY";
        brokenHead[1] += " VARCHAR(64) NOT NULL";
        brokenHead[2] += " VARCHAR(32) NOT NULL";
        brokenHead[3] += " VARCHAR(32) NOT NULL";
        brokenHead[4] += " VARCHAR(8) NOT NULL"; //cost can be X
        brokenHead[5] += " VARCHAR(8)"; //STR can be X || NULL
        brokenHead[6] += " VARCHAR(8) NOT NULL"; //USE can be INF
        brokenHead[7] += " VARCHAR(16) NOT NULL";
        brokenHead[8] = brokenHead[9] + " VARCHAR(64)"; //Don't care about rarity
        brokenHead[9] =  "HOMING INT";
        
        String header = "use phantom_dust;\ncreate table if not exists skills(";
        for(int i = 0; i < brokenHead.length; i++) {
            header += brokenHead[i];
            if(i >= 9) break;
            header += ",";
        }
        header += ");";

        return header;
    }

    static String fileContents(String path) {
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