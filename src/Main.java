import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws Exception {
        DBApp engine = new DBApp();
        engine.init();

        // create table
        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("id", "java.lang.Integer");
        htblColNameType.put("name", "java.lang.String");
        htblColNameType.put("gpa", "java.lang.Double");

        Hashtable<String, String> mins = new Hashtable<String, String>();
        mins.put("id", "0");
        mins.put("name", "A");
        mins.put("gpa", "0.0");

        Hashtable<String, String> maxs = new Hashtable<String, String>();
        maxs.put("id", "9999");
        maxs.put("name", "ZZZZZZZZZZZZZZZZ");
        maxs.put("gpa", "4.0");

        // insert data
        Hashtable<String, Object> t1 = new Hashtable<String, Object>();
        t1.put("id", 1);
        t1.put("gpa", 2.0);
        t1.put("name", "Mostafa");

        Hashtable<String, Object> t2 = new Hashtable<String, Object>();
        t2.put("id", 2);
        t2.put("gpa", 2.0);
        t2.put("name", "Mahmoud");

        Hashtable<String, Object> t3 = new Hashtable<String, Object>();
        t3.put("id", 3);
        t3.put("gpa", 3.0);
        t3.put("name", "Seif");

        Hashtable<String, Object> t4 = new Hashtable<String, Object>();
        t4.put("id", 4);
        t4.put("gpa", 3.0);
        t4.put("name", "Seaf");

        Hashtable<String, Object> t5 = new Hashtable<String, Object>();
        t5.put("id", 5);
        t5.put("gpa", 2.0);
        t5.put("name", "Sesdfaf");

        Hashtable<String, Object> t6 = new Hashtable<String, Object>();
        t6.put("id", 6);
        t6.put("gpa", 3.0);
        t6.put("name", "Sesdfaf");
        
        Hashtable<String, Object> t7 = new Hashtable<String, Object>();
        t7.put("id", 7);
        t7.put("gpa", 3.0);
        t7.put("name", "Sesdfaf");
        
        Hashtable<String, Object> t8 = new Hashtable<String, Object>();
        t8.put("id", 8);
        t8.put("gpa", 3.0);
        t8.put("name", "Mostafa");


 

        // delete data
        Hashtable<String, Object> d1 = new Hashtable<String, Object>();
        d1.put("name", "Sesdfaf");

        Hashtable<String, Object> d2 = new Hashtable<String, Object>();
        d2.put("gpa", 3.0);
        d2.put("name", "Seaf");

        // update data
        Hashtable<String, Object> u1 = new Hashtable<String, Object>();
        u1.put("name", "Sssss");

        Hashtable<String, Object> u2 = new Hashtable<String, Object>();
        u2.put("name", "Sesdfaf");

        Hashtable<String, Object> u3 = new Hashtable<String, Object>();
        u3.put("name", 4);

        // engine

       // engine.createTable("Student", "id", htblColNameType, mins, maxs);
//        engine.insertIntoTable("Student", t1);
//        engine.insertIntoTable("Student", t2);
//        engine.insertIntoTable("Student", t3);
//        engine.insertIntoTable("Student", t4);
//        engine.insertIntoTable("Student", t5);
//        engine.insertIntoTable("Student", t6);
//        engine.insertIntoTable("Student", t7);
//        engine.insertIntoTable("Student", t8);



//         SQLTerm query = new SQLTerm("Student", "name","=","Sesdfaf");
//         SQLTerm query2 = new SQLTerm("Student", "gpa","=",3.0);
//         SQLTerm query3 = new SQLTerm("Student", "name","=","Seaf");
//
//         SQLTerm[] sqlTerms = {query, query2};
//         String [] x = {"OR"};
//         Iterator res = new ResultSet();
//         //res = engine.selectFromTable(sqlTerms, x);
//         while(res.hasNext()) {
//				System.out.print("< ");
//
//        	 Tuple temp = (Tuple) res.next();
//				Enumeration<String> e = temp.data.keys();
//        	 while (e.hasMoreElements()) {
//					String key = e.nextElement();
//					System.out.print(key + ": " + temp.data.get(key));
//					if (e.hasMoreElements())
//						System.out.print(" , ");
//				}
//				System.out.print(" > \n");
//
//         }
        // engine.insertIntoTable("Student", t4);
        // engine.insertIntoTable("Student", t5);
        // engine.insertIntoTable("Student", t6);

        // engine.insertIntoTable("Student", t7);

        // engine.deleteFromTable("Student", d1);

        // engine.updateTable("Student", "2", u3);

       engine.clear();

        // print page content
        System.out.println("\nin main");
        TableInfo tableInfo = (TableInfo) engine.readObject("Student" + "Info" + ".class");
        engine.printPagesContent(tableInfo);

        // t1,

    }

}
