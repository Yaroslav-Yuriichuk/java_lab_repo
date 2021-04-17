
public class App {

	public static void main(String[] args) {
		
		ElectricLamp philipsEcoHome = new ElectricLamp("Philips", "China", 11, 	730,
				"E27", "White", 270, 3000, 1150, 61, 136);

		ElectricLamp osram = new ElectricLamp("OSRAM", "China", 8, 730,
				"E14", "Matt", 200, 2900, 806, 45, 90);
		
		ElectricLamp euroLight = new ElectricLamp("EuroLight", "China", 12, 365,
				"E27", "Matt", 220, 4200, 960, 60, 123);
		
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
