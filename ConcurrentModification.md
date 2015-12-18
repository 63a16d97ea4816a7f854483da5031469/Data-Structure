

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Appointment implements Comparable<Appointment> {
	long startTime;
	long endTime;
	boolean valid;

	public Appointment(Date startTime, Date endTime) {
		// remove the invalid input
		if (startTime == null || endTime == null) {
			valid = false;

		} else {

			this.startTime = startTime.getTime();
			this.endTime = endTime.getTime();
			valid = true;
		}
	}

	public int compareTo(Appointment other) {
		if (this.startTime < other.startTime)
			return 1;
		else if (this.startTime > other.startTime)
			return -1;
		else
			return 1;
	}

}

public class Myclass {

	/*
	 * 
	 * 1.null 2.list is empty. 3.normal input 4.Appointment checking(startTime
	 * or endTime may be null).
	 * 
	 * Normal Input: List contains the Appointment object:
	 * 
	 * List<Appointment> inputList=new ArrayList<Appointment>();
	 * 
	 * 
	 * inputList.add(new Appointment(new Date(now),new Date("");
	 * 
	 * [9:10-10:00] [10-11] [10:30-2][3-4]
	 * 
	 * 1900
	 * 
	 */

	public static void main(String args[]) {

		Myclass my = new Myclass();

		List<Appointment> inputList = new ArrayList<Appointment>();
 
		inputList.add(new Appointment(convertDateFromString("01-04-2013 11:35:42"), convertDateFromString("03-04-2013 11:35:42")));
		inputList.add(new Appointment(convertDateFromString("02-04-2013 11:35:42"), convertDateFromString("02-04-2013 11:35:42")));
		inputList.add(new Appointment(convertDateFromString("09-04-2013 11:35:42"), convertDateFromString("10-04-2013 11:35:42")));
		my.findConflict(inputList);
	}
	
	
    public static Date convertDateFromString(String dateStr){
    	// Convert string to date
    SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    String strdate = dateStr;
    Date newdate=null;
    try {
        newdate = dateformat.parse(strdate);
        System.out.println(newdate);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return newdate;
    
}


	public List<Appointment> findConflict(List<Appointment> list) {

		// input validation
		if (list == null)
			return new ArrayList<Appointment>();

		for (Appointment tmp :list) {
			if (tmp.valid)
				list.remove(tmp);
			if (tmp.startTime > tmp.endTime)
				list.remove(tmp);
		}

		// Implement the main function

		// sort the List by startTime
		Collections.sort(list);

		ArrayList<Appointment> result = new ArrayList<Appointment>();

		for (Appointment tmp : list) {
			for (Appointment sec : list) {
				if (tmp == sec)
					continue;
				if (sec.startTime > tmp.endTime)
					continue;
				if (sec.startTime <= tmp.endTime) {
					result.add(sec);
					result.add(tmp);
				}

			}
		}

		return result;
	}

}


Mon Apr 01 11:35:42 SGT 2013
Wed Apr 03 11:35:42 SGT 2013
Tue Apr 02 11:35:42 SGT 2013
Tue Apr 02 11:35:42 SGT 2013
Tue Apr 09 11:35:42 SGT 2013
Wed Apr 10 11:35:42 SGT 2013
Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:859)
	at java.util.ArrayList$Itr.next(ArrayList.java:831)
	at Myclass.findConflict(Myclass.java:90)
	at Myclass.main(Myclass.java:64)
