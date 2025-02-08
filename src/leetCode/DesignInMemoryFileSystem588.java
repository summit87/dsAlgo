package leetCode;
import java.util.*;
public class DesignInMemoryFileSystem588 {

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
       System.out.println( fs.ls("/"));
       fs.mkdir("/a/b/c");
       System.out.println(fs.ls("/"));
    }

}


class FileSystem {
    DirStructure dirMap;

    public FileSystem() {
        dirMap = new DirStructure();
    }

    public List<String> ls(String path) {
        List<String> fileNames = new ArrayList<>();
        List<String> dirNames = new ArrayList<>();
        DirStructure dm = dirMap;
        if (path.equals("/")) {
            if (!dm.fMap().isEmpty()) {
                fileNames = new ArrayList<>(dm.fMap().keySet());
            }
            if (!dm.getDirMap().isEmpty()) {
                dirNames = new ArrayList<>(dm.getDirMap().keySet());
            }

            dirNames.addAll(fileNames);

            return dirNames;
        }

        String[] paths = path.split("/");
        for (int i = 0; i < paths.length - 1; i++) {
            dm = dm.getDirMap().get(paths[i]);
        }
        fileNames.addAll(dm.fMap().keySet());
        dirNames.addAll(dm.getDirMap().keySet());
        dirNames.addAll(fileNames);
        return dirNames;
    }

    public void mkdir(String path) {
        DirStructure dm = dirMap;
        String[] paths = path.split("/");
        for (String p : paths) {
            if("".equalsIgnoreCase(p)) continue;
            if (!dm.getDirMap().containsKey(p)) {
                DirStructure dm1 = new DirStructure();
                Map<String, DirStructure> m1 = dm.getDirMap();
                m1.put(p, dm1);
                dm.setDirMap(m1);
            }
            dm = dm.getDirMap().get(p);
        }
        
    }

    public void addContentToFile(String filePath, String content) {
        DirStructure dm = dirMap;
        String[] paths = filePath.split("/");
        for (int i = 0; i < paths.length - 1; i++) {
            dm = dm.getDirMap().get(paths[i]);
        }
        if(dm.fMap().containsKey(paths[paths.length-1])){
            Map<String,String> map = dm.fMap();
            map.put(paths[paths.length-1],map.getOrDefault(paths[paths.length-1],"")+content);
            dm.setFileMap(map);
        }else{
             Map<String,String> map = new HashMap<>();
             map.put(paths[paths.length-1],content);
             dm.setFileMap(map);
        }
       
    }

    public String readContentFromFile(String filePath) {
        DirStructure dm = dirMap;
        String[] paths = filePath.split("/");
        for(int i=0;i<paths.length-1;i++){
            dm = dm.getDirMap().get(paths[i]);
        }
        return dm.fMap().get(paths[paths.length-1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

/**
 * This is the class which will be directory and it will have DIR and File both
 * There can be nestead directory inside the directory and each directory may be
 * have the file or not
 */
class DirStructure {
    private Map<String, DirStructure> dirMap;
    private Map<String, String> fMap;

    public DirStructure(){
        dirMap = new HashMap<>();
        fMap = new HashMap<>();
    }

    public Map<String, DirStructure> getDirMap() {
        return dirMap;
    }

    public Map<String, String> fMap() {
        return fMap;
    }

    public void setDirMap(Map<String, DirStructure> map) {
        this.dirMap = map;
    }

    public void setFileMap(Map<String,String> map){
        this.fMap = map;
    }

}
