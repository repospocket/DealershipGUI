import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.ListIterator;

public class CarDealership {

// Initiate two array lists' references of car type.
// carz; the original cars inventory array list.
// backup; a backup array list used when clearing filters. 
	ArrayList<Car> carz;
	ArrayList<Car> backup;
	SalesTeam team;
	//AccountingSystem object
	
//Constructs the array lists.
	CarDealership(){
		carz = new ArrayList<Car>();
		backup = new ArrayList<Car>();
	}
	
//Method to add cars to the array lists.
    public void addCars(ArrayList<Car> newCars) {
    	if (carz.isEmpty()) {
	 carz.addAll(newCars);
	 backup.addAll(newCars);
	 System.out.println("Added!");
	}
	else{
		if (!newCars.isEmpty()) {
			for (Car car : newCars) {
				if (!carz.contains(car)) {
					carz.add(car);
				}
			}
		} else {
			System.out.println("was not able to add.. (the inventory may not be empty)");

		}
	}
	}

	    AccountingSystem sys = new AccountingSystem();

	    
/**
 *  buy car from the inventory.
 * @param VIN id of car to buy
 * @return String of information of transaction of bought car
 */
   public String buyCar(int VIN) {
	   try {
	   ListIterator<Car> it = carz.listIterator();
	    double price = 0 ;
	    Car car1 = null;
		while(it.hasNext()) {
			Car car = it.next();
			if(car.vin == VIN) {
				car1 = car;
				price = car.price;
				it.remove();
			}				
		}
		SalesTeam team = new SalesTeam();
		String seller = team.getPerson();
		Calendar calendar = new GregorianCalendar();	      
	    int day =  randBetween(0, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    int month = randBetween(0, 11);
		Calendar calendar1 = new GregorianCalendar(2019, month, day);	      
	   return sys.add(calendar1, car1, seller, "BUY", price);
	   }
       catch(Exception e) 
	   {
           return "No such car exists..";
	   }	   	 
   }
   
   /**
    * @param start
    * @param end
    * @return Helper method to get a random integer between to giving two giving values
    */
   public  int randBetween(int start, int end) {
       return start + (int)Math.round(Math.random() * (end - start));
   }
 
//Takes id as a parameter
//Returns a transaction with random date set after the purchase date and returns last car bought
    public void returnCar(int transaction) {
 	  Transaction tra1 = sys.getTransaction(transaction);
 	  if (tra1.sellType.equals("BUY")) {
 		  int day =  randBetween(tra1.date.get(3) , tra1.date.getActualMaximum(3));
 		  Calendar calendar1 = new GregorianCalendar(2019, tra1.date.get(2), day);	
 		  sys.add(calendar1, tra1.car, tra1.seller, "RET", tra1.price);
 		  carz.add(tra1.car);
 	  }
 	  else {System.out.println("last car was returned");}
   }
    

//Prints out the cars in the array list.
    public String displayInventory() {
    	String dis = "";
    	if (carz.isEmpty()){
			System.out.println("No cars in inventory! Please Add cars" );
    		return "No cars in inventory! Please Add cars";}
    	else {
			System.out.println("# VIN MFR COLOR MODEL POWER SAFTYRATING PRICE RECHARGETIME");
    	for (Object x : carz) {
    		System.out.println(carz.indexOf(x) + " " + ((Car) x).display());
    		dis +=  carz.indexOf(x) + " " + ((Car) x).display() + "\n";
    	}
    	return dis;}
    } 
    
    public String displayInventoryAWD() {
    	String dis = "";
    	if (carz.isEmpty())
    		return "no cars in inventory! please populate me";
    	else {
    	for (Car x : carz) {
    		if (x.AWD & !x.getPower().equals("ELECTRIC_MOTOR")) {
    		System.out.println(carz.indexOf(x) + " " + ((Car) x).display());
    		dis +=  carz.indexOf(x) + " " + ((Car) x).display() + "\n";}
    	}
    	return dis;
    	}
    } 
    
    public String displayInventoryElectric() {
    	String dis = "";
    	if (carz.isEmpty())
    		return "no cars in inventory! please populate me";
    	else {
    	for (Car x : carz) {
    		if ( x.getPower().equals("ELECTRIC_MOTOR") & !x.AWD) {
    		System.out.println(carz.indexOf(x) + " " + ((Car) x).display());
    		dis +=  carz.indexOf(x) + " " + ((Car) x).display() + "\n";}
    	}
    	return dis;}
    } 
    
    
//Filter the cars in the array list by electric.
    public void  filterByElectric() {
  	  ArrayList<Car> temp = new ArrayList<Car>();
  	  for (Car x : carz) {
		
    		if (x.getPower().equals("ELECTRIC_MOTOR")) {
    			temp.add(x);
    		}
    	}
  	  carz = temp;
    }
    
    public void  eleclear() {
    	  for (Car x : backup) {
      		if (!x.getPower().equals("ELECTRIC_MOTOR") & !carz.contains(x)) {
      			carz.add(x);
      		}
      	}
    	  
      }

//filter the cars in the list by All wheel type.
    public void  filterByAWD() {
    	ArrayList<Car> temp = new ArrayList<Car>();
     	  for (Car x : carz) {
       		if (x.AWD) {
       			temp.add(x);
       		}
       	}
      carz = temp;
    }

 /**
  * filter the cars in the list by price range
  * @param minPrice lowest desired price.
  * @param maxPrice highest desired price.
  */
    public void filterByPrice(double minPrice, double maxPrice) {
      ArrayList<Car> temp = new ArrayList<Car>();
   	  for (Car x : carz) {
   		  if (x.price >= minPrice && x.price <= maxPrice ) 
   			  temp.add(x);
   		  }
   		carz = temp;
   	  }
   			  
//Clears all filters that are set by calling the backup array list.
    public void FiltersClear() {
    	carz = backup;
    }
    
    public void awdClear() {
    	for (Car x : backup) {
     		if (!x.AWD & !carz.contains(x)) {
     			carz.add(x);
     		}
     	}
    }
    
    
//Sorts the cars in the list by price.
    public void sortByPrice(){
    	Collections.sort(carz);
    	
    }
    
//Sorts the cars in the list by Safety Rating.
    public void sortBySafetyRating() {
    	Collections.sort(carz, new Comparator<Car>(){
    	public int compare(Car o1, Car o2) {
    		if(o1.safetyRating == o2.safetyRating)  return 0;
    		else if (o1.safetyRating < o2.safetyRating)  return -1;
    		return +1;
    		}
    	});
    }
    
 //Sorts the cars in the list by max range.
    public void sortByMaxRange() {
    	Collections.sort(carz, new Comparator<Car>(){
    	public int compare(Car o1, Car o2) {
    		if(o1.maxRange == o2.maxRange)  return 0;
    		else if (o1.maxRange < o2.maxRange)  return -1;
    		return +1;
    		}
    	});
    }
}
