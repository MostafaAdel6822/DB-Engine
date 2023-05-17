import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class SQLTerm {
    String _strTableName;
    String _strColumnName;
    String _strOperator;
    Object _objValue;
    
    
    
	public SQLTerm(String _strTableName, String _strColumnName, String _strOperator, Object _objValue) {
		this._strTableName = _strTableName;
		this._strColumnName = _strColumnName;
		this._strOperator = _strOperator;
		this._objValue = _objValue;
	}
    public static void main(String[] args) {
//		ResultSet resultSet = new ResultSet();
//		ResultSet resultSet2 = new ResultSet();
//
//		ResultSet res = new ResultSet();
//
//    	Hashtable<String, Object> t1 = new Hashtable<String, Object>();
//        t1.put("id", 1);
//        t1.put("gpa", 2.0);
//        t1.put("name", "Mostafa");
//        Tuple t11 = new Tuple(t1);
//        
//        Hashtable<String, Object> t2 = new Hashtable<String, Object>();
//        t2.put("id", 2);
//        t2.put("gpa", 5.0);
//        t2.put("name", "khara");
//        Tuple t22 = new Tuple(t2);
//
//        Hashtable<String, Object> t3 = new Hashtable<String, Object>();
//        t3.put("id", 3);
//        t3.put("gpa", 3.0);
//        t3.put("name", "Seif");
//        Tuple t33 = new Tuple(t3);
//        
//        Hashtable<String, Object> t4 = new Hashtable<String, Object>();
//        t4.put("id", 2);
//        t4.put("gpa", 5.0);
//        t4.put("name", "khara");
//        Tuple t44 = new Tuple(t4);
//
//        resultSet.tuples.add(t11);
//        resultSet.tuples.add(t22);
//        resultSet.tuples.add(t33);
//        resultSet.tuples.add(t44);
//        
//        res = getSetDifference(resultSet, resultSet2);
//
////        res = removeduplicates(resultSet);
//        while(resultSet.hasNext()) {
//			System.out.print("< ");
//
//    	 Tuple temp = (Tuple) resultSet.next();
//			Enumeration<String> e = temp.data.keys();
//    	 while (e.hasMoreElements()) {
//				String key = e.nextElement();
//				System.out.print(key + ": " + temp.data.get(key));
//				if (e.hasMoreElements())
//					System.out.print(" , ");
//			}
//			System.out.print(" > \n");
//
//        }
    	System.out.println(getMid("0","9999"));
        
    }
    public static Object getMid(Object min, Object max) {
        if (min instanceof Integer) {
            return ((Integer) max + (Integer) min) / 2;
        } else if (min instanceof Double) {
            return ((Double) max + (Double) min) / 2.0;
        } 
        else if (min instanceof String) {
            return findStringMedian((String) min, (String) max,
                    Math.max(((String) max).length(), ((String) min).length()));

        } 
        else if (min instanceof Date) {
            long midMillis = (((Date) min).getTime() + ((Date) max).getTime()) / 2;
            return new Date(midMillis);
        }
        return null;
    }
    public static String stringAdapter(String S, String T) {
        String m = "";

        for (int i = S.length(); i < T.length(); i++) {
            m += T.charAt(i);
        }

        S += m;
        return S;
    }
    public static String findStringMedian(String S, String T, int N) {
        if (S.length() != N) {
            S = stringAdapter(S, T);

        } else if (T.length() != N) {
            T = stringAdapter(T, S);
        }
        int[] a1 = new int[N + 1];

        for (int i = 0; i < N; i++) {
            a1[i + 1] = (int) S.charAt(i) - 97
                    + (int) T.charAt(i) - 97;
        }

        for (int i = N; i >= 1; i--) {
            a1[i - 1] += (int) a1[i] / 26;
            a1[i] %= 26;
        }

        for (int i = 0; i <= N; i++) {

            if ((a1[i] & 1) != 0) {

                if (i + 1 <= N) {
                    a1[i + 1] += 26;
                }
            }

            a1[i] = (int) a1[i] / 2;
        }
        String m = "";
        for (int i = 1; i <= a1.length - 1; i++) {
            m += (char) (a1[i] + 97);
        }
        return m;
    }

    public static ResultSet getSetDifference(ResultSet allResultSet, ResultSet tempResultSet) {
		ResultSet res = new ResultSet();
		res = allResultSet;
		for(int i = 0; i<res.tuples.size(); i++) {
			for(int j = 0; j<tempResultSet.tuples.size(); j++) {
				if(res.tuples.get(i).data.equals(tempResultSet.tuples.get(j).data)) {
					System.out.println("66666666666");
					res.tuples.remove(res.tuples.get(i));		
				}
			}			
		}
		return res;
	}
//    public static ResultSet removeDuplicates(ResultSet allResultSet) {
//		ResultSet res = new ResultSet();
//		res = allResultSet;
//		Boolean duplicate = false;
//		for(int i = 0; i<res.tuples.size(); i++) {
//			int count = 1;
//			for(int j  = 0; j<res.tuples.size();j++) {
//				if(res.tuples.get(i).data.equals(tempResultSet.tuples.get(j).data)) {
//					System.out.println("66666666666");
//					res.tuples.remove(res.tuples.get(i));		
//				}	
//			}
//						
//		}
//		return res;
//	}
//    public static ResultSet removeDuplicates(ResultSet x) {
//        ResultSet res = new ResultSet();
//        for (Tuple hash : x.tuples) {
//            if (!res.tuples.contains(hash)) {
//                res.tuples.add(hash);
//            }
//        }
//        return res;
//    }
//    public static ResultSet removeduplicates(ResultSet x) {
//    	ResultSet res = new ResultSet();
//        for (int i=0;i<x.tuples.size();i++) {
//            boolean f=false;
//            for(int j=0;j<res.tuples.size();j++) {
//                if((res.tuples.get(j).equals(x.tuples.get(i)))) {
//                    f=true;
//                }
//            }
//            if(!f) {
//                res.tuples.add(x.tuples.get(i));
//            }
//        }
//        return res;
//    }
    

}

