import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * this class constructs a transaction given appropriate values
 * @author George
 *
 */
public class Transaction {
	//initiate variables 
	int id;
	Calendar date;
	Car car;
	String seller;
	String sellType;
	double price;
	
	//the constructor 
	public Transaction(int id, Calendar date, Car car, String seller, String sellType, double price) {
		this.id = id;
		this.date = date;
		this.car = car;
		this.seller = seller;
		this.sellType = sellType;
		this.price = price;
	}
/**
 * prints out the transaction
 * @return string represents the transaction
 */
	public String display() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");  
	return "Transaction [id=" + id + ", date=" + sdf.format(date.getTime()) + ", car=" + car.display() + ", seller=" + seller + ", sellType="
				+ sellType + ", price=" + price + "]";
	}



}
