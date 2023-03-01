public class ElectricCar extends Car {
	
	int rechargeTime ;
	String batteryType ;

//Constructs the electric car 
	public ElectricCar(Integer vin, String mfr, String color,  String model, String power, double safetyRating, int maxRange,
			boolean aWD, double price, int rechargeTime) {
		super(vin, mfr, color, model, power,safetyRating, maxRange , aWD, price);
		this.rechargeTime = rechargeTime;
	}

//Setters and getters for recharge time and battery type.
	public int getRechargeTime() 
	   { return rechargeTime; }

	public void setRechargeTime(int rechargeTime) 
	   { this.rechargeTime = rechargeTime; }

	public String getBatteryType() 
	   { return batteryType; }

	public void setBatteryType(String batteryType) 
	   { this.batteryType = batteryType; }

// returns electric car information.
	public String display() {
		return super.display() + " " + rechargeTime  ;
	}
	
	
	
}
