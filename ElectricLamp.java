
public class ElectricLamp {

	private String brand;
	private String manufacturerCountry;
	private int power;
	private int daysGaranty;
	private String capType;
	private String bulbColor;
	private int disperseAngle;
	private int luminescenceTemperature;
	private int lightFlow;

	protected double diameter;
	protected double height;

	private static String purposeOfLamp = "Room Lighting";

	public ElectricLamp(String brand, String manufacturerCountry, int power, int daysGaranty, String capType,
			String bulbColor, int disperseAngle, int luminescenceTemperature, int lightFlow, double diameter,
			double height) {
		super();
		setValues(brand, manufacturerCountry, power, daysGaranty, capType, bulbColor, disperseAngle,
				luminescenceTemperature, lightFlow, diameter, height);
	}
	
	public ElectricLamp(String brand, String manufacturerCountry, int power, int daysGaranty) {
		this(brand, manufacturerCountry, power, daysGaranty, "Unknown", "Unknown", 0, 0, 0, 0, 0);
	}

	public ElectricLamp() {
		this("Unknown", "Unknown", 0, 0, "Unknown", "Unknown", 0, 0, 0, 0, 0);
	}

	private void setValues(String brand, String manufacturerCountry, int power, int daysGaranty, String capType,
			String bulbColor, int disperseAngle, int luminescenceTemperature, int lightFlow, double diameter,
			double height) {

		this.brand = brand;
		this.manufacturerCountry = manufacturerCountry;
		this.power = power;
		this.daysGaranty = daysGaranty;
		this.capType = capType;
		this.bulbColor = bulbColor;
		this.disperseAngle = disperseAngle;
		this.luminescenceTemperature = luminescenceTemperature;
		this.lightFlow = lightFlow;
		this.diameter = diameter;
		this.height = height;
	}

	public void resetValues(String brand, String manufacturerCountry, int power, int daysGaranty, String capType,
			String bulbColor, int disperseAngle, int luminescenceTemperature, int lightFlow, double diameter,
			double height) {
		setValues(brand, manufacturerCountry, power, daysGaranty, capType, bulbColor, disperseAngle,
				luminescenceTemperature, lightFlow, diameter, height);
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufacturerCountry() {
		return manufacturerCountry;
	}

	public void setManufacturerCountry(String manufacturerCountry) {
		this.manufacturerCountry = manufacturerCountry;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDaysGaranty() {
		return daysGaranty;
	}

	public void setDaysGaranty(int daysGaranty) {
		this.daysGaranty = daysGaranty;
	}

	public String getCapType() {
		return capType;
	}

	public void setCapType(String capType) {
		this.capType = capType;
	}

	public String getBulbColor() {
		return bulbColor;
	}

	public void setBulbColor(String bulbColor) {
		this.bulbColor = bulbColor;
	}

	public int getDisperseAngle() {
		return disperseAngle;
	}

	public void setDisperseAngle(int disperseAngle) {
		this.disperseAngle = disperseAngle;
	}

	public int getLuminescenceTemperature() {
		return luminescenceTemperature;
	}

	public void setLuminescenceTemperature(int luminescenceTemperature) {
		this.luminescenceTemperature = luminescenceTemperature;
	}

	public int getLightFlow() {
		return lightFlow;
	}

	public void setLightFlow(int lightFlow) {
		this.lightFlow = lightFlow;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public static void printStaticPurposeOfLamp() {
		System.out.println(purposeOfLamp);
	}
	
	public void printPurposeOfLamp() {
		System.out.println(purposeOfLamp);
	}
	
	@Override
	public String toString() {
		return "ElectricLamp Brand = " + getBrand() +
				", \nManufacturerCountry = " + getManufacturerCountry() +
				", \nPower = " + getPower() + "Watts" +
				", \nDaysGaranty = " + getDaysGaranty() + " days" +
				", \nCapType = " + getCapType() +
				", \nBulbColor = " + getBulbColor() +
				", \nDisperseAngle = " + getDisperseAngle() + "°" +
				", \nLuminescenceTemperature = " + getLuminescenceTemperature() + "K" +
				", \nLightFlow = " + getLightFlow() + " Lumems" +
				", \nDiameter = " + getDiameter() + "mm" +
				", \nHeight = " + getHeight() + "mm";
	}
}
