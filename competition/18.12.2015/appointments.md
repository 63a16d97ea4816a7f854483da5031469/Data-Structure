"You are given N appointments.  Each appointment contains start time & endtime.  Return all conflicting appointments"
	
	
	
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
				if (this.startTime > this.endTime) {
					valid = false;
				} else {
					valid = true;
				}
			}
		}
	
		public String toString() {
			return "startTime: " + this.startTime + " endTime: " + this.endTime;
		}
	
		public int compareTo(Appointment other) {
			if (this.startTime > other.startTime)
				return 1;
			else if (this.startTime < other.startTime)
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
	
			
			//Normal input:
			inputList.add(new Appointment(convertDateFromString("01-04-2013 11:35:42"),
					convertDateFromString("03-04-2013 11:35:42")));
			inputList.add(new Appointment(convertDateFromString("02-04-2013 11:35:42"),
					convertDateFromString("02-04-2013 11:35:42")));
			inputList.add(new Appointment(convertDateFromString("09-04-2013 11:35:42"),
					convertDateFromString("10-04-2013 11:35:42")));
	
			// inputList.add(new Appointment(convertDateFromString("09-04-2013
			// 11:35:42"),
			// convertDateFromString("10-04-2013 11:35:42")));
			// inputList.add(new Appointment(convertDateFromString("09-04-2013
			// 11:35:42"),
			// convertDateFromString("10-04-2013 11:35:42")));
	
			// previous.endTime = this.startTime
			inputList.add(new Appointment(convertDateFromString("10-04-2013 11:35:42"),
					convertDateFromString("12-04-2013 11:35:42")));
	
			// this.startTime=previous.endTime+1
			inputList.add(new Appointment(convertDateFromString("12-04-2013 11:35:43"),
					convertDateFromString("12-04-2013 11:35:43")));
	
			// this.startTime=this.endTime
			inputList.add(new Appointment(convertDateFromString("12-04-2013 11:35:42"),
					convertDateFromString("12-04-2013 11:35:42")));
	
			// startTime and endTime is wrong
			inputList.add(new Appointment(convertDateFromString(""), convertDateFromString("")));
			inputList.add(new Appointment(convertDateFromString("fdsfd"), convertDateFromString("fds")));
			// startTime is not wrong but endTime is wrong
			inputList.add(new Appointment(convertDateFromString("09-04-2013 11:35:42"), convertDateFromString("")));
			// startTime>endTime case:
			inputList.add(new Appointment(convertDateFromString("12-04-2013 11:35:42"),
					convertDateFromString("10-04-2013 11:35:42")));
	
	//		for (Appointment tmp : inputList) {
	//			System.out.println(tmp.startTime + " " + tmp.endTime + " " + tmp.valid);
	//		}
	//		System.out.println();
	
			List<Appointment> result = my.findConflict(inputList);
	
			for (Appointment tmp : result) {
				System.out.println(tmp.startTime + " " + tmp.endTime + " ");
			}
		}
	
		public static Date convertDateFromString(String dateStr) {
			// Convert string to date
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String strdate = dateStr;
			Date newdate = null;
			try {
				newdate = dateformat.parse(strdate);
			} catch (ParseException e) {
				return null;
			}
			return newdate;
	
		}
	
		public List<Appointment> findConflict(List<Appointment> inputList) {
	
			// input validation
			if (inputList == null)
				return new ArrayList<Appointment>();
	
			// Implement the main function
	
			// sort the List by startTime
			Collections.sort(inputList);
	
			ArrayList<Appointment> result = new ArrayList<Appointment>();
			Set<Appointment> set = new HashSet<Appointment>();
	
			for (int i = 0; i < inputList.size(); i++) {
				if (!inputList.get(i).valid)
					continue;
	
				for (int j = i + 1; j < inputList.size(); j++) {
	
					if (!inputList.get(j).valid)
						continue;
	
					if (inputList.get(i) == inputList.get(j))
						continue;
					if (inputList.get(j).startTime > inputList.get(i).endTime)
						continue;
	
					// For debug:
	//				System.out.println(i + " " + j + " " + inputList.get(i).toString() + " " + inputList.get(j).toString());
	
					if (inputList.get(j).startTime <= inputList.get(i).endTime) {
						set.add(inputList.get(i));
						set.add(inputList.get(j));
					}
				}
			}
	
			for (Iterator<Appointment> it = set.iterator(); it.hasNext();) {
				result.add(it.next());
			}
	
			return result;
		}
	
	}