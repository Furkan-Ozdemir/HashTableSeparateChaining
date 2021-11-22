import java.util.ArrayList;

public class Entry<K, V> {

    int hash;
    K key;
    V value;

    ArrayList<Character> characters = new ArrayList<>();

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        // this.hash = hashCodeSSF(key.toString());
        this.hash = hashCodePAF(key);
    }

    public void initCharacters() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabet.length(); i++) {
            characters.add(alphabet.charAt(i));
        }
    }

    public boolean equals(Entry<K, V> other) {
        if (hash != other.hash)
            return false;
        return key.equals(other.key);
    }

    public String toString() {
        return key + "=>" + value;
    }

    public int hashCodeSSF(String key) {
        int capacity = HashTableSeparateChaining.capacity();
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        return hash % capacity;
    }

    public int hashCodePAF(K key) {
        int capacity = HashTableSeparateChaining.capacity();

        final int constant = 31;
        int hash = 0;
        String stringKey = key.toString();

        for (int i = 0; i < stringKey.length(); i++) {
            hash += (characters.indexOf(stringKey.charAt(i)) + 1) * Math.pow(constant, stringKey.length() - 1 - i);
        }

        return hash % capacity;

    }
}
