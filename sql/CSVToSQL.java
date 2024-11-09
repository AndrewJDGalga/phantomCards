import java.io.FileReader;

class CSVToSQL {
    public static void main(String[] args) {
        String fileString = fileContents("test.csv");

        int headEnd = fileString.indexOf('\n');
        String head = fileString.substring(0, headEnd);
        String minusHead = fileString.substring(headEnd, fileString.length());
        
        String[] brokenHead = head.split(",");
        
        for(int i = 0; i < brokenHead.length; i++) {

            System.out.println(brokenHead[i]);
        }
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