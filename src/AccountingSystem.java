import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class AccountingSystem {
    //holds array of the transactions
	ArrayList<Transaction> history = new ArrayList<Transaction>();
	
	/**
	 *  adds a transaction to the history of the transactions
	 * @param date
	 * @param car
	 * @param seller
	 * @param sellType
	 * @param price
	 * @return  string of the transaction 
	 */
	public String add(Calendar date, Car car, String seller, String sellType, double price) {	
     Random random = new Random();
	 int id = random.nextInt(99) + 1;
    Transaction transaction = new Transaction(id, date, car, seller, sellType, price);
    if(car != null)
    history.add(transaction);
    return transaction.display();
	}
	
	/**
	 * gets a transaction given its id
	 * @param id
	 * @return object of the transaction 
	 */
	public Transaction getTransaction(int id) {
		for (Transaction x : history) {
			if (x.id == id)
				return x;
		}
		return null;
	}
	
	

}
