import java.io.FileReader;

class CSVToSQL {
    public static void main(String[] args) {
        String fileString = fileContents("test.csv");

        int headerEnd = fileString.indexOf('\n');
        String header = fileString.substring(0, headerEnd);
        String minusHead = fileString.substring(headerEnd, fileString.length());
        //System.out.println(header);

        
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