import java.util.*;

class Barkit implements Comparable<Barkit>{
	public double cost;
	public String[] Ingredients;
	
	public Barkit(double inputCost,String[] tmpIngredients){
		this.cost=inputCost;
		this.Ingredients=tmpIngredients;
	}
	
	
	public boolean contain(String str){
		for(String tmp:Ingredients){
			if(str.equals(tmp)) return true;
		}
		return false;
	}
	

	public String toString() {
		String finalStr = "";
		for (String tmp : Ingredients) {
			finalStr += tmp;
		}
		finalStr += " " + cost;
		return finalStr;
	}
	
 
    public int compareTo(Barkit other){
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than 
        // other and 0 if they are supposed to be equal
        if(this.cost>other.cost) return 1;
        else if(this.cost<other.cost) return -1;
        else return 1;
    }
}

public class Solution{
	
	static Barkit[] allBarKits=new Barkit[4];
	
	static Barkit b1=new Barkit(100,new String[]{"wine"});
	static Barkit b2=new Barkit(2,new String[]{"egg"});
	static Barkit b3=new Barkit(10,new String[]{"water"});
	static Barkit b4=new Barkit(13,new String[]{"wine"});
 


	
	
	public static void main(String args[]){
		Solution s=new Solution();
		
		allBarKits[0]=b1;
		allBarKits[1]=b2;
		allBarKits[2]=b3;
		allBarKits[3]=b4;
 
		String[] targetStr={"wine","egg","water","fire"};
		
		Barkit[] result=s.makeShoppingList(targetStr);
		
		System.out.println("The result:");
		
		if(result!=null)
		for(Barkit tmp:result){
			System.out.println(tmp);
		}
		
		
		
	}
	

	public static Barkit[] makeShoppingList(String[] targetIngredients){
		
		Arrays.sort(allBarKits);
 
		int[] buylist=new int[targetIngredients.length];
		HashMap<String,Barkit> map=new HashMap<String,Barkit>();
 
		Set<Barkit> result=new HashSet<Barkit>();
		boolean[] flag=new boolean[targetIngredients.length];
		
		for(String tmp:targetIngredients){
			for(Barkit bit:allBarKits){
				if(bit.contain(tmp)){
					result.add(bit);
					break;
				}
			}
			
		}
		
		Barkit[] bitresult=new Barkit[result.size()];
		int i=0;
	     Iterator<Barkit> itr = result.iterator();  
	        while(itr.hasNext()){  
	            Barkit bit = itr.next();  
	            bitresult[i]=bit;
	            i++;
	        }  
		
		return bitresult;
	}
}