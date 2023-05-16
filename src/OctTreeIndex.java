import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

class Cube {
    Hashtable<String, Object> mins, maxs; // <column, minValue>

    public Cube(Hashtable<String, Object> mins, Hashtable<String, Object> maxs) {
        this.mins = mins;
        this.maxs = maxs;
    }
}

//class OctTree {
//    int maxEntries;
//    int entriesCount;
//    OctTree[] children;
//    Cube bounds;
//    // add references to pages
//
//    public OctTree(Cube bounds) throws IOException {
//        this.children = new OctTree[8];
//        this.bounds = bounds;
//        this.entriesCount = 0;
//
//
//    }
//
//}

public class OctTreeIndex {
    String indexName;
    String tableName;
    String[] columnsNames;
    int maxEntriesPerOctant;
    OctTree octTree;

    public OctTreeIndex(String tableName, String indexName, String[] columnsNames) throws IOException, DBAppException{
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("resources/DBApp.config");
        prop.load(fis);
        this.maxEntriesPerOctant = Integer.parseInt(prop.getProperty("MaximumEntriesinOctreeNode"));
        
		ArrayList<String[]> tableData =csvReader("metadata.csv", tableName);
		Hashtable<String, Object> mins = new Hashtable<String, Object>();
		Hashtable<String, Object> maxs = new Hashtable<String, Object>();
		boolean flag = false;
		for(int i = 0; i<tableData.size(); i++) {
			for(int j = 0 ; j<columnsNames.length; j++) {
				if(tableData.get(i)[1].equals(columnsNames[j])) {
					mins.put(columnsNames[j], tableData.get(i)[6]);
					maxs.put(columnsNames[j], tableData.get(i)[7]);
					flag = true;
				}
			}
		}
		if(flag==false) 
			throw new DBAppException("coloumns doe not exist");
		
		Cube bounds = new Cube(mins, maxs);


    }

    public ArrayList<String[]> csvReader(String fileName, String strTableName) {
		String csvFile = fileName;
		String line = "";
		String csvSeparator = ",";
		ArrayList<String[]> result = new ArrayList<String[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(csvSeparator);
				if (values[0].equals(strTableName)) {
					result.add(values);
				}

			}
			return result;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}