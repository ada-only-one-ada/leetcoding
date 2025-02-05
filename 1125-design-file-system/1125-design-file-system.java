import java.util.*;

class FileSystem {
    Map<String, Integer> map;

    public FileSystem() {
        map = new HashMap<>();
        map.put("", 0); // Initialize root path
    }
    
    public boolean createPath(String path, int value) {
        if (path.equals("/") || map.containsKey(path)) {
            return false; // Check if path already exists or is the root path
        }

        // Get the parent path by finding the last '/' and substring up to it
        String parentPath = path.substring(0, path.lastIndexOf('/'));

        // Check if the parent path exists
        if (!map.containsKey(parentPath)) {
            return false;
        }

        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if (!map.containsKey(path)) {
            return -1;
        }
        return map.get(path);
    }
}
