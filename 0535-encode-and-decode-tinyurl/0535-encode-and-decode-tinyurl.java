import java.util.HashMap;
import java.util.Map;

public class Codec {
    private Map<String, String> map = new HashMap<>();
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int counter = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = idToShortURL(counter++); // Increment counter for each new URL
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Helper method to convert an integer ID to a base-62 encoded string
    private String idToShortURL(int n) {
        StringBuilder shortUrl = new StringBuilder();
        while (n > 0) {
            shortUrl.append(ALPHABET.charAt(n % 62));
            n /= 62;
        }
        return shortUrl.reverse().toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
