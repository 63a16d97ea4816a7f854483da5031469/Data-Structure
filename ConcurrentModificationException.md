##java.util.ConcurrentModificationException

	Exception in thread "main" java.util.ConcurrentModificationException
		at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:859)
		at java.util.ArrayList$Itr.next(ArrayList.java:831)
		at Myclass.findConflict(Myclass.java:90)
		at Myclass.main(Myclass.java:64)


====>The code:


		for (Appointment tmp :list) {
			if (tmp.valid)
				list.remove(tmp);
			if (tmp.startTime > tmp.endTime)
				list.remove(tmp);
		}
		
		
If you are using the  xxxx xx:list  to loop the List, then you try to remove it, it will cause ConcurrentModificationException.