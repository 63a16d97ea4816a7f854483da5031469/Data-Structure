##Easy to make mistakes
* Before using the array (it is an object), we need to check the whether this array (object) is null.
 
		int[] arr2=null;
		int n=arr2.length;


* Before we use ListNode, we need to check whether it is null.

* Remember:    

			String --->  str.length();  
			Array---> arr.length; 
			List--->int len=list.size();

* List:

when you are using all kinds of "List", if you remove element from it, the list.size() will be changed at the same time.

	for(int i=0;i<list.size();i++){
		list.remove(list.size()-1); // list.size() is changed.
	}
	
 ==> you can use this way to avoid this mistake:
 
 int i=0;
 while(i<list.size()){
 	if(xxxx){  // loop the element but not delete
 	
 	xxxxx
 	
 	i++;
 	
 	}else{
 		list.remove(i);  // delete one element
 	}
 }
 