public class Vehicle {

	String mfr, color,power ; 
	int numWheels ;
	public static final int  ELECTRIC_MOTOR = 0 ;
	public static final int GAS_ENGINE  = 1;
	int vin = 0;
/**
 *   A constructs for Vehicle.
 * @param mfr        ;  Manufacture.
 * @param color      ;  color.
 * @param power      ;  power.
 * @param numWheels  ;  Number of wheels.
 */

	public Vehicle(Integer vin, String mfr, String color,String power) {
		this.mfr = mfr;
		this.color = color;
		this.power = power;
	    this.vin = vin;
	}

//Setters and getters for Manufacture , Color, Power, Number of wheels.
	public String getMfr() {return mfr;}

	public void setMfr(String mfr) {this.mfr = mfr;}

	public String getColor() {return color;}

	public void setColor(String color) {this.color = color;}

	public String getPower() {return power;}

	public void setPower(String power) {this.power = power;}

//Compare two Vehicles and see if they are identical
	public boolean equals(Object other) {
		Vehicle other1 = (Vehicle) other;
		if (this.mfr == other1.mfr && this.power == other1.power ){
		  return true;
		  }
		return false;
	}

//Returns Vehicle manufacture and color information.
	public String display() {
		return  vin + " " +  this.getMfr() + " " + this.getColor() + " "  + this.power;
	}
	public String cvsformat() {
		return  vin + "," +  this.getMfr() + "," + this.getColor() + ","+ this.power ;
	}
	
}
