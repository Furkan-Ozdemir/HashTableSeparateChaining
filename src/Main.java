import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        /*----------------------------------------------------------*/

        // File file = new File("C:\\Users\\DELL\\Desktop\\ödev\\search.txt");
        // Scanner sc = new Scanner(file);
        // while (sc.hasNext()) {
        // // System.out.println(sc.nextLine());
        // tableSeparateChaining.put(sc.next(), file.getName());
        // }

        // FileHandling.readFile("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\business");
        // System.out.println(new
        // File("C:\\Users\\DELL\\Desktop\\ödev\\bbc").listFiles().length);

        /* ----------------------------------------------------------------- */
        // System.out.println(new
        // File("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\business").listFiles().length);
        // System.out.println(new
        // File("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\entertainment").listFiles().length);
        // System.out.println(new
        // File("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\politics").listFiles().length);
        // System.out.println(new
        // File("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\sport").listFiles().length);
        // System.out.println(new
        // File("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\tech").listFiles().length);

        /*----------------------------------------------------------*/
        for (File file : new File("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\business").listFiles()) {
            FileHandling.stopWords();

            FileHandling.readFileAndPut("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\business\\" + file.getName());
        }

        // FileHandling.readFileAndPut("C:\\Users\\DELL\\Desktop\\ödev\\bbc\\business\\001.txt");
        System.out.println(FileHandling.tableSeparateChaining.toString());
        System.out.println(FileHandling.tableSeparateChaining.size());

        // System.out.println(tableSeparateChaining.toString());
        // System.out.println(tableSeparateChaining.size());
        // System.out.println(HashTableSeparateChaining.capacity());

    }
}
