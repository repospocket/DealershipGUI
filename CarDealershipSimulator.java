import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CarDealershipSimulator  
{

	public static ArrayList<Car> readCSV(String filePath) {
        BufferedReader br = null;
        String line = "";
		ArrayList<Car> kar = new ArrayList<Car>();

        try {
            br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
				

				Integer Vin = Integer.parseInt(data[0]) ;
				String Mfr = data[1] ;
				String Color = data[2] ;
				String Model = data[3] ;
				String Power = data[4] ;
				Double SafetyRating = Double.parseDouble(data[5]) ;
				int MaxRange = Integer.parseInt(data[6]);
				String AWD = data[7];
				boolean tAWD = false;
				if(AWD.equals("AWD")){
					tAWD = true;
				} else{tAWD = false;}
				
				
				Double Price = Double.parseDouble(data[8]) ;
 
				if(Power.equals("ELECTRIC_MOTOR")){
				int RechargeTime = Integer.parseInt(data[9]);
				Car Car = new ElectricCar(Vin, Mfr, Color, Model, Power, SafetyRating, MaxRange, tAWD, Price, RechargeTime);
				kar.add(Car);
			}
			else{
				Car Car = new Car(Vin, Mfr, Color, Model, Power, SafetyRating,MaxRange, tAWD, Price);
				
				kar.add(Car);
			}
			
            }

      } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return kar;
    }

  public static void main(String[] args) throws Exception
  {	  
	String newline = System.lineSeparator();
	System.out.print(
		"------------------------------" + newline +
		"**Welcome to the Dealership!**" + newline + 
		"------------------------------" + newline +

"ADD     -> Add all cars from cars.txt (Sync)" + newline +

"L       -> List available cars" + newline +
"BUY vin -> Buy a car using its vin (ie. BUY 313)" + newline +
"Q       -> Quit" + newline +
"RET     -> Return last car bought (undo)" + newline +
"****" + newline +

"SPR -> Sort by price" + newline +
"SSR -> sort By Safety Rating" + newline +
"SMR -> sort by max range" + newline +
"****" + newline +

"FPR max min -> Filter by price  (ie. FPR 5000 25000)" + newline +
"FEL -> Filter By Electric" + newline +
"FAW -> Filter By All wheels" + newline +
"FCL -> Clears filters and reset." + newline +
"****" + newline +

"SALES -> Display all sales" + newline +
"SALES TOPSP -> Top sales persons and sales numbers" + newline +
"SALES STATS -> shows the stats buy looking through the transactions history" + newline +
"SALES TEAM  -> Names of the team" + newline 
	
							);
	
      	  // Create a CarDealership object
	  CarDealership dealer = new CarDealership();
	   AccountingSystem sys = dealer.sys;
          
	  // Then create an (initially empty) array list of type Car
      // Then create some new car objects of different types
	  // See the cars file for car object details
	  // Add the car objects to the array list
      // The ADD command should hand this array list to CarDealership object via the addCars() method	
	  /**
	   * Create an array list of car type and add car objects to it.
	   */
	 
	  ArrayList<Car> kar = new ArrayList<Car>();
	  kar  =  readCSV("cars.csv");
	  //I/O reader that reads from cars.txt file and adds cars automatically to the inventory arraylist.
	  
	  try (// Create a scanner object
	Scanner input = new Scanner(System.in)) {
		// Takes input from user and calls the appropriate methods to execute.
		     // saves last bought car into a variable in case returned.
		  while(input.hasNextLine()){
			 //takes next command and split it so its readable
			 String txt = input.nextLine();
			 String[] tokens = txt.split("[ ]+");
			 //display all cars
			 if (tokens[0].equals("L")) {
				 dealer.displayInventory();
				}
			 //Check if index is in range and buy appropriate car.
			 //throws error if index incorrect
			 //updates last bought car variable.
			 if (tokens[0].equals("BUY")) {
			      try {
			         int s = Integer.parseInt(tokens[1]);
			         

			         System.out.println(dealer.buyCar(s) );
			          } catch (Exception e)
			          {
			           System.out.println("not valid entry");
			          }
			 }
			//Add the cars to the inventory.L
			if (tokens[0].equals("ADD")) {
				dealer.addCars(kar);
			}
			//Exit the program.
			if (tokens[0].equals("Q")) {
				System.out.print("Bye Bye!");
				break;
				}
			//Returns last bought car.
			
			if (tokens[0].equals("RET")) {
				if(!sys.history.isEmpty()) {
				         dealer.returnCar(sys.history.get(sys.history.size()-1).id);
				}
				else System.out.println("no cars bought yet" );
			}
			
			//Sort by price.
			if (tokens[0].equals("SPR")) {
				dealer.sortByPrice();
				}
			//Sort by sort By Safety Rating
			if (tokens[0].equals("SSR")) {
				dealer.sortBySafetyRating();
				}
			// sort by max range
			if (tokens[0].equals("SMR")) {
				dealer.sortByMaxRange();
			}
			//filter by price. parse input into readable type. catches any invalid entry. 
			if (tokens[0].equals("FPR")) {
				if (tokens.length > 1) {
				      try {
					double minPrice = (double)  Integer.parseInt(tokens[1]);
					double maxPrice = (double) Integer.parseInt(tokens[2]);
				    dealer.filterByPrice(minPrice, maxPrice);
					dealer.displayInventory();
				          } catch (NumberFormatException e)
				      {
					   System.out.println("not valid entry");
				      }

				} else {
				System.out.println("Please include min and max price. (ie. FPR 20000 30000)");
				}


			}
			// filter By Electric
			if (tokens[0].equals("FEL")) {
				dealer.filterByElectric();
				dealer.displayInventory();
			}
			//filter By All wheels
			if (tokens[0].equals("FAW")) {
				dealer.filterByAWD();
				dealer.displayInventory();
			}
		    //Clears filters.
			if (tokens[0].equals("FCL")) {
				dealer.FiltersClear();
				dealer.displayInventory();
			}
			
			//takes sales command and see what the user wants by looking at next command
			if (tokens[0].equals("SALES")) {
				if (tokens.length == 1) {
					for (Transaction x : sys.history) 
						System.out.println(x.display() );
					}
				else if (tokens.length > 1) {
					if (tokens[1].equals("TOPSP")) {
						
						  Map<String, Integer> map = new HashMap<String, Integer>();
						   for (Transaction x : sys.history) {
							   if (x.sellType.equals("BUY")) {
								
							   map.put(x.seller, map.get(x.seller) == null ? 1 : map.get(x.seller) + 1 );
							   }
							   
						   }
						   for (Entry<String, Integer> entry : map.entrySet()) {
							System.out.println(entry.getKey() + ":" + entry.getValue().toString());
						}
						System.out.print(System.lineSeparator());
						}
						  
					//shows the stats buy looking through the transactions history 
					else if (tokens[1].equals("STATS")) {
						
						 	 double total = 0;     
						 	 int totalsold = 0;
						 	 int totalreturn = 0 ;
				             for (Transaction x : sys.history) {
				            	 if (x.sellType.equals("BUY"))
				            		 total += x.price;
				            	 else  {total -= x.price;}
				            	 if(x.sellType.equals("BUY")) {
				            		 totalsold++;
				            	 }
				            	 if(x.sellType.equals("RET")) {
				            		 totalreturn++;
				            	 }
				             }
				               
								Map<Integer, Integer> map = new HashMap<Integer, Integer>();
								   for (Transaction x : sys.history) {
									   if (x.sellType.equals("BUY")) {
									   map.put(x.date.get(2), map.get(x.date.get(2)) == null ? 1 : map.get(x.date.get(2)) + 1 );
									   }
								   }
										
				             System.out.println("Totalvalue: " + total + " Averagevalue: " + String.format("%.2f", total/12) + " Totalsold:"  + totalsold + " Returned: " + totalreturn
				            		 ) ;

				             }
					
					//prints out sales team
					else if (tokens[1].equals("TEAM")) {
						SalesTeam team = new SalesTeam();
						for (String x : team.listt){
							System.out.print(x + " : ");}
						System.out.print(System.lineSeparator());

						}
					//takes care of displaying the sales of required month (SALES m)
					else {
						try {
							int s = Integer.parseInt(tokens[1]);
							for (Transaction x : sys.history) {
								if(  x.date.get(2) == s)
									System.out.println(x.display());
							}
						} catch (NumberFormatException e)
						{
							System.out.println("not valid entry");
						}}}
			}}
	}
}
				
}
			
		
		
 	  
  
 	 
