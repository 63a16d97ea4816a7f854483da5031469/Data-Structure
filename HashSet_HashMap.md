##HashSet Iteration:

	Set set = new HashSet();
	
	  for(int i=0;i<100;i++)
	  {
	   set.add("123");
	  }
      for (Iterator it = set.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

##HashMap Iteration:  
  
Method 1:        (method 1 is better than method 2----> entry is the basic type in HashMap's implementation.)

	for(Entry<Integer, String> entry:map.entrySet())
	  {
	   System.out.println(entry.getKey()+"="+entry.getValue());
	  }
	
Method 2:
	
	for(Object key : map.keySet()) {     
	      Object value = map.get(key);     
	      System.out.println(value);
	  }
	

##HashTable Iteration:

HashTable 是线程安全的。

	Hashtable table = new Hashtable();
	  table.put(1, "1");
	  table.put(2, "1");
	  table.put(3, "1");
	  //遍历key
	  Enumeration e = table.keys();
	
	  while( e. hasMoreElements() ){
	
	  System.out.println( e.nextElement() );
	
	  }
	  //遍历value
	  e = table.elements();
	
	  while( e. hasMoreElements() ){
	
	  System.out.println( e.nextElement() );
	
	  }
	  
	  
	  
	import java.util.*;

	public class HashTableDemo {
	
	   public static void main(String args[]) {
	      // Create a hash map
	      Hashtable balance = new Hashtable();
 
	      String str;
	      double bal;
	
	      balance.put("Zara", new Double(3434.34));
	      balance.put("Mahnaz", new Double(123.22));
	      
	      // Show all balances in hash table.
	      Enumeration names = balance.keys();
	      while(names.hasMoreElements()) {
	         str = (String) names.nextElement();
	         System.out.println(str + ": " +
	         balance.get(str));
	      }
	      System.out.println();
	      // Deposit 1,000 into Zara's account
	      bal = ((Double)balance.get("Zara")).doubleValue();
	      balance.put("Zara", new Double(bal+1000));
	      System.out.println("Zara's new balance: " +
	      balance.get("Zara"));
	   }
	}
	
	
	
	
	