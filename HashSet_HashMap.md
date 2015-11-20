##HashSet Iteration:

	Set set = new HashSet();
	
	  for(int i=0;i<100;i++)
	  {
	   set .add("123");
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
	
	for(Object obj : map.keySet()) {     
	      Object key = obj;     
	      Object value = map.get(obj);     
	      System.out.println(value);
	  }
	

##HashTable Iteration:

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