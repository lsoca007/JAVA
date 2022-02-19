import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;



public class Main {

	public Main() {
		
	}

	public static void main(String[] args) {
		UnbalancedTreeMap myTreeMap=new UnbalancedTreeMap(); //my implemented map initialization
		TreeMap<String, Integer> standTreeMap = new TreeMap<String, Integer>(); //standard map initialization
		
		long startTime = System.nanoTime();
		long myTotalTime = 0;
		long standTotalTime = 0;
		
		
		for(int i = 1; i<=77;i++) //1 to 77 
		{
			File file = new File("./HCAndersen Tales/"+i+".okpuncs");  //reading the i-th file. Ex: i=2 & (/HCAndersen Tales/2.okpuncs)
			
			try {
				Scanner input = new Scanner(file); //reading the file
				while (input.hasNextLine()) { //if the file has next line (=not in the end of file)
	                String line = input.nextLine(); //reading the line
	                StringTokenizer defaultTokenizer = new StringTokenizer(line); //for tokenizing the line ("I am well" -> "I", "am", "well")
	                while (defaultTokenizer.hasMoreTokens()) //if the token has next (=not in the end of tokens)
	                {
	                	String word = defaultTokenizer.nextToken(); //reading the token (=word)
	            
	                	startTime = System.nanoTime(); 
	                	myTreeMap.put(word, 1+myTreeMap.get(word)); //inserting the token (=word) & value + 1 into the unbalanced tree
	                	myTotalTime+= (System.nanoTime()-startTime);
	                	
	                	startTime = System.nanoTime();
	                	Integer gotValue = standTreeMap.get(word); //inserting the token (=word) & value + 1 into the Standard tree
	                	if (gotValue==null) //if the key isn't in the standard tree
	                		gotValue = 0; //set it to 0
	                	standTreeMap.put(word,gotValue+1); //inserting the token (=word) into the unbalanced tree
	                	standTotalTime+= (System.nanoTime()-startTime);
	                }
	            }
	            input.close();
			} catch (FileNotFoundException e) {//when no such file is found
				System.out.println("Error: "+ e.getMessage()); //printing if there is error
			}
		}
		
		System.out.println("Unbalanced Map Time: " + myTotalTime + ", Standard Map Time: " + standTotalTime);
		
	}

}
