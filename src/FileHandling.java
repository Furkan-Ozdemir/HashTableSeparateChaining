import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class FileHandling {
    static HashTableSeparateChaining<String, String> tableSeparateChaining = new HashTableSeparateChaining<>();
    static ArrayList<String> stopWords = new ArrayList<>();

    // public static String replaceAll(String str, ArrayList<String> stopwords) {
    // for (String word : stopwords) {
    // str = str.replace(word, " ");
    // }
    // return str;
    // }

    /*
     * Takes a path to the file then strips it from punctuation marks and stop
     * words, then adds it to the table
     */
    public static void readFileAndPut(String path) throws Exception {
        // File file2 = new File("C:\\Users\\DELL\\Desktop\\ödev\\search.txt");
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            // strip et , replace et , ekle

            // System.out.println(scanner.next());
            String currentString = scanner.next();
            String[] stripped = stripDelimeter(currentString);

            if (stripped.length == 1) {
                if (!stopWords.contains(stripped[0])) { // stopword değilse table a ekliyor
                    tableSeparateChaining.put(stripped[0], file.getName());
                }
                // stopword ise boş geç.
            }
            if (stripped.length == 2) {
                if (!stopWords.contains(stripped[0] + stripped[1])) { // stopword değilse table a ekliyor
                    tableSeparateChaining.put(stripped[0] + stripped[1], file.getName());
                }
                // stopword ise boş geç.
            }

        }
        scanner.close();
    }

    /*
     * Stop words dosyasını tek tek okuyor her birini stripDelimeter fonksiyonundan
     * geçirip noktalama işaretlerini kaldırıyor ve stopWords arraylist'ine atıyor.
     */
    public static void stopWords() throws Exception {
        File file = new File("C:\\Users\\DELL\\Desktop\\ödev\\stop_words_en.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String[] stripped = stripDelimeter(sc.next());
            if (stripped.length == 1)
                stopWords.add(stripped[0]);
            else
                stopWords.add(stripped[0] + stripped[1]);

        }
        sc.close();
    }

    public static String[] stripDelimeter(String str) {
        String DELIMITERS = "[-+=" +

                " " + // space

                "\r\n " + // carriage return line fit

                "1234567890" + // numbers

                "’'\"" + // apostrophe

                "(){}<>\\[\\]" + // brackets

                ":" + // colon

                "," + // comma

                "‒–—―" + // dashes

                "…" + // ellipsis

                "!" + // exclamation mark

                "." + // full stop/period

                "«»" + // guillemets

                "-‐" + // hyphen

                "?" + // question mark

                "‘’“”" + // quotation marks

                ";" + // semicolon

                "/" + // slash/stroke

                "⁄" + // solidus

                "␠" + // space?

                "·" + // interpunct

                "&" + // ampersand

                "@" + // at sign

                "*" + // asterisk

                "\\" + // backslash

                "•" + // bullet

                "^" + // caret

                "¤¢$€£¥₩₪" + // currency

                "†‡" + // dagger

                "°" + // degree

                "¡" + // inverted exclamation point

                "¿" + // inverted question mark

                "¬" + // negation

                "#" + // number sign (hashtag)

                "№" + // numero sign ()

                "%‰‱" + // percent and related signs

                "¶" + // pilcrow

                "′" + // prime

                "§" + // section sign

                "~" + // tilde/swung dash

                "¨" + // umlaut/diaeresis

                "_" + // underscore/understrike

                "|¦" + // vertical/pipe/broken bar

                "⁂" + // asterism

                "☞" + // index/fist

                "∴" + // therefore sign

                "‽" + // interrobang

                "※" + // reference mark

                "]";

        String[] splitted = str.split(DELIMITERS);
        return splitted;
    }

}
