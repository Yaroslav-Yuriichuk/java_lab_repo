
public class App {

	public static void main(String[] args) {
		
		ElectricLamp philipsEcoHome = new ElectricLamp("Philips", "China", 11, 	730,
				"E27", "White", 270, 3000, 1150, 61, 136);

		ElectricLamp osram = new ElectricLamp();
		
		ElectricLamp euroLight = new ElectricLamp("EuroLight", "China", 12, 365);
		
		ElectricLamp.printStaticPurposeOfLamp();
		
		System.out.println();
		System.out.println(philipsEcoHome);
		
		System.out.println();
		System.out.println(osram);
		
		System.out.println();
		System.out.println(euroLight);
		
		System.out.println();
		philipsEcoHome.printPurposeOfLamp();
		osram.printPurposeOfLamp();
	}

}
