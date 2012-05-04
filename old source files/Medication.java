/**
 * 
 * @author keith
 * This is the medication class which is an abstract class
 * It is abstract because it PRNMed and ScheduledMed will be extending from them
 */

abstract public class Medication {
	
	private String name;
	private double amount;
	private String units;
	
	public Medication (String name, double amount, String units) {
		this.name = name;
		this.amount = amount;
		this.units = units;
	}
	
	public void setMedication (String x) {
		name = x;
	}
	
	public String getMedication () {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}
	
	
	
	

}
