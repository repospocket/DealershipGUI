import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class SalesTeam {
	
	LinkedList<String> listt ;
	//Constructs sales team
	public SalesTeam(){
	     listt = new LinkedList<String>();
         listt.add("George");
         listt.add("Rami");
         listt.add("Rachel");
         listt.add("Ali");
         listt.add("Olivia");
	}
	
	/**
	 *  gets a random sales team
	 * @return string of name of random sales team
	 */
	public String getPerson() {
		Random rand = new Random();
		return listt.get(rand.nextInt(4) + 1) ;
	}

	/**
	 *   displays names of team
	 * @return string of names of sales team
	 */
	public  String displayNames() {
		ListIterator<String> it = listt.listIterator();
		String names = "";
		while(it.hasNext()) {
			names += it.next().toString() + " ";
		}
		return names;
	}
/**
 *   gets sales team with provided index
 * @param x the index of sales team
 * @return string of sales team name
 */
	public String getPerson(int x) {
		return listt.get(x);
	}

}
