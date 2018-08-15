import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
class WorkerThread extends Thread {	
	public static String items[] = {"bread", "sausages", "butter", "cheese", "sauerkraut", "pepper", "salt"};
	public Set<String> receipt = new HashSet<String>();
	public Set<Integer> set = new HashSet<Integer>();
	public ArrayList <Integer> numbers = new ArrayList<Integer>();
	public TreeSet sortedreceipt;
	protected Object lock = new Object();
	int max=100;
		    @Override
	public void run() {
	Random r = new Random();
	for (int i=0; i<max;i++) {		//5 random numbers without duplicates in under 'max' trials
		numbers.add(r.nextInt(7)); 
		set.add(numbers.get(i));	//to eliminate duplicates
		if (set.size()==5)
		break;
   	 	}
   	Integer[] rand = new Integer[set.size()];
   	rand = set.toArray(rand);
		    synchronized(lock){
		     try{
		        for(int i = 0; i<5; i++){
		           	receipt.add(items[rand[i]]);
		        }	
		     }
		     catch(Exception e){}
	//	     System.out.println(this + ":" + receipt);
		   }
		}
		}
//Generate single item sets to be used to find all possible 7choose3 = 35 subsets
class Miniset extends Thread {
	public Set<String> atom = new HashSet<String>();
	Miniset(int par){
		atom.add(WorkerThread.items[par]);
	}
}

public class DataMiner {
	public static WorkerThread[] Threads = new WorkerThread[50];
	public static Miniset[] Miniset = new Miniset[7];
     	public static void main(String[] args) { 	
	//	System.out.println("The 50 receipts are: ");
		for (int i = 0; i<50; i++){
			Threads[i] = new WorkerThread();
			}
		for (int i = 0; i<7; i++){
			Miniset[i] = new Miniset(i);
			}
	synchronized(Threads[0]){
		for (int i = 0; i<50; i++){			
			Threads[i].start();	
			}
		for (int i = 0; i<7; i++){			
			Miniset[i].start();	
			}
		  }
	synchronized(Threads[0]){
       	try{ 
		Threads[0].wait();
   	for (int i = 0; i<7; i++){
   		for (int j = i+1; j<7; j++){
   			for (int k = j+1; k<7; k++){
   				int count = 0;
   				Set<String> union1 = new HashSet<String>(Miniset[i].atom);
   				union1.addAll(Miniset[j].atom); //union of 2 items

   				Set<String> union2 = new HashSet<String>(union1);
   				union2.addAll(Miniset[k].atom); //union of 3 items
   				for (int l = 0; l<50; l++){
   					if((Threads[l].receipt).containsAll(union2)) count++;
   			//	System.out.println("The subset containing items "+(i+1) + ", "+(j+1)+" ,"+" and "+ (k+1)+ " is: "+ union2+" and is cotained in receipt "+ l + " Counter: " + (count++));
   						//System.out.println(count);
   				}
   				System.out.println(union2+ "			Count: " + count);
   			}
   	}
 }
       	}catch(InterruptedException e){
      		 e.printStackTrace();
   		}
   	}
   }
}

