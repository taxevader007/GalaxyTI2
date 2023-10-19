package ui;

import model.Controller;
import java.util.Calendar;
import java.util.Scanner;


public class Main {
	private final Scanner scan = new Scanner(System.in);
	private final Controller controller;

	public Main() {
		controller = new Controller();
	}


	public static void main(String[] args) {
		Main main = new Main();
		main.menu();



		// Create a new Controller object

	}

	public void menu() {

		boolean flag = false;

		while (!flag) {
			System.out.println("Welcome to the menu \n");
			System.out.println("Options:\n" + "1. Create a galaxy\n" + "2. Create a black hole\n"
					+ "3. Create a planet\n" + "4. Remove a planet\n" + "5. Edit a planet\n"
					+ "6. Add a photo to a planet\n" + "7. Info of a specific galaxy\n"
					+ "8. Info of a specific planet\n" + "9. Order a galaxy by distance from earth\n"
					+ "10. Order a planet by density\n" + "11. Name black holes with theirs galaxy name\n"
					+ "12. Telescope with more photos\n" + "13. Test cases\n" + "14. Add a photo to a black hole\n"
					+ "15. Add a photo to a galaxy\n" + "16. Exit the program\n");

			int option = scan.nextInt();

			scan.nextLine();

			switch (option) { // create galaxy
				case 1:
					createGalaxy();
					break;

				case 2:
					createblackhole();
					break;
				
				case 3:
					createplanet();
					break;

				case 4:
					removeplanet();
					break;
				
				case 5:
					editplanet();
					break;

				case 6:
					//
					addPlanetPhoto();
					break;
				
				case 7:// info of a 
					infoGalaxy();
					break;

				case 8:// info of a specific planet
					infoGalaxy();
					break;

				case 9:// order a galaxie by distance from earth
					//orderDistance();
					break;

				case 10:// order a planet by density
					//planetwithmoreDensity(scan, controller);
					break;

				case 11:// nameblackholes with theirs galaxy name
					//namesBlackholeGalaxy(scan, controller);
					break;	
				
				case 12:
					//telescopeWithmorePhotos(scan, controller);
					break;

				case 13:
					//testcases
					break;

				case 14:
					//addBlackholePhoto(scan, controller);
					break;
				
				case 15: 
					//addGalaxyPhoto(scan, controller);
					break;

				case 16:
					flag = true;
					System.out.println("exiting the program. ");
					System.exit(0);
					scan.close();
					break;

				/* 
				case 17: // remove galaxy
					removeGalaxy(scan, controller);
					break;
				*/

				default:
					System.out.print("Please enter a valid option");
					break;
			}// switch
		} // while
	}// menu

	public void createGalaxy() {
		System.out.println("Please enter the name of the galaxy: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the distance to Earth: ");
		double distanceToEarth = scan.nextDouble();
		scan.nextLine(); // Consume the newline character left in the buffer

		System.out.println("Please enter the shape of the galaxy:"+ "\n" + "ELLIPTICAL, SPIRAL, LENTICULAR, IRREGULAR ");
				
		String shape = scan.nextLine();

		// Use the method from the Controller to add the galaxy
		controller.registerGalaxy(galaxyName, distanceToEarth, shape);

		System.out.println("Galaxy added successfully");

	}

	public void createblackhole() {
		System.out.println("Please enter the name of the black hole: ");
		String blackholeName = scan.nextLine();

		System.out.println("Please enter the mass of the black hole: ");
		double mass = scan.nextDouble();
		scan.nextLine(); // Consume the newline character left in the buffer

		System.out.println("Please enter the density of the black hole: ");
		double density = scan.nextDouble();
		scan.nextLine(); // Consume the newline character left in the buffer

		System.out.println("Please enter the size of the black hole: ");
		double size = scan.nextDouble();
		scan.nextLine(); // Consume the newline character left in the buffer

		System.out.println("Please enter the galaxy name of the black hole: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the angular moment of the black hole (true or false)");
		boolean angularMoment = scan.nextBoolean();

		System.out.println("Please enter the charge of the black hole (true or false)");
		boolean charge = scan.nextBoolean();

		// Use the method from the Controller to add the black hole
		controller.registerBlackHole(blackholeName, mass, density, size, galaxyName,angularMoment, charge);

		System.out.println("Black hole added successfully");

	}

	public void createplanet(){
		System.out.println("Please enter the name of the galaxy to associate the planet: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the name of the planet: ");
		String planetName = scan.nextLine();

		System.out.println("Please enter the number of satellites: ");
		int numberOfSatellites = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the radius of the planet (in meters): ");
		double planetRadius = scan.nextDouble();
		scan.nextLine(); // Consume the newline character left in the buffer

		System.out.println("Please enter the mass of the planet (in kg): ");
		double planetMass = scan.nextDouble();
		scan.nextLine(); 

		// Use the method from the Controller to add the planet
		controller.registerPlanet(planetName, numberOfSatellites, planetRadius, planetMass, galaxyName);

		System.out.println("Planet added successfully");

	}

	public void removeplanet(){
		System.out.println("Please enter the name of the galaxy to remove the planet: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the name of the planet to remove: ");
		String planetName = scan.nextLine();

		// Use the method from the Controller to remove the planet
		controller.rmPlanet(galaxyName, planetName);

		System.out.println("Planet removed successfully");

	}

	public void editplanet(){
		System.out.println("Please enter the name of the galaxy to edit the planet: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the name of the planet to edit: ");
		String planetName = scan.nextLine();

		System.out.println("Please enter the new name of the planet: ");
		String newPlanetName = scan.nextLine();

		System.out.println("Please enter the new number of satellites: ");
		int newNumberOfSatellites = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the new radius of the planet (in meters): ");
		double newPlanetRadius = scan.nextDouble();
		scan.nextLine(); // Consume the newline character left in the buffer

		System.out.println("Please enter the new mass of the planet (in kg): ");
		double newPlanetMass = scan.nextDouble();
		scan.nextLine(); 

		// Use the method from the Controller to edit the planet
		controller.editPlanet(galaxyName, planetName, newPlanetName, newNumberOfSatellites, newPlanetRadius, newPlanetMass);

		System.out.println("Planet edited successfully");

	}

	public void addPlanetPhoto() {
		System.out.println("Please enter the name of the galaxy to add the photo: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the name of the planet to add the photo: ");
		String planetName = scan.nextLine();

		System.out.println("Please enter the photo URL ");
		String photoURL = scan.nextLine();

		System.out.println("Please enter the telescope that take the photo: ");

		System.out.println("Please enter the photo creation day: ");
		int photoCreationDay = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the photo creation month: ");
		int photoCreationMonth = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the photo creation year: ");
		int photoCreationYear = scan.nextInt();
		scan.nextLine();

		// Create a Calendar object with the given date
		Calendar photoCreationDate = Calendar.getInstance();
		photoCreationDate.set(photoCreationYear, photoCreationMonth - 1, photoCreationDay);

		// Use the method from the Controller to add the photo
		controller.registerPlanetPhoto(galaxyName, planetName, photoURL, photoCreationDate);

		System.out.println("Photo added successfully");
	}



		public static void showGalaxy(String[] args) {
		Controller controller = new Controller();
		String[] galaxyInfo = controller.getGalaxyInfo();
		for (String info : galaxyInfo) {
			System.out.println(info);
		}
	}
	
	public String infoGalaxy() {
		System.out.println("Please enter the name of the galaxy to see the info: ");
		String galaxyNameInfo = scan.nextLine();
		model.Galaxy galaxy = controller.infoGalaxy(galaxyNameInfo);

		if (galaxy != null) {
			System.out.println(galaxy);
		} else {
			System.out.println("Galaxy not found.");
		}

		return "";
	}

	/*
	public void removeGalaxy() {
		System.out.println("Please enter the name of the galaxy to remove: ");
		String galaxyNameRemove = scan.nextLine();
		String removed = controller.rmGalaxy(galaxyNameRemove);
		if (removed.equals("Galaxy removed successfully.")) {
			System.out.println("Galaxy removed successfully.");
		} else {
			System.out.println("Galaxy not found.");
		}
	}
	*/

}// class
