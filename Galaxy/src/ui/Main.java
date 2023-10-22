package ui;

import model.Controller;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * The Main class is a Java program that serves as a menu-driven interface for creating and managing
 * galaxies, black holes, and planets.
 */
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

	/**
	 * The menu function displays a menu of options and allows the user to perform various actions based
	 * on their selection.
	 */
	public void menu() {

		boolean flag = false;

		while (!flag) {
			System.out.println("Welcome to the menu \n");
			System.out.println("Options:\n" + "1. Create a galaxy\n" + "2. Create a black hole\n"
					+ "3. Create a planet\n" + "4. Remove a planet\n" + "5. Edit a planet\n"
					+ "6. Add a photo to a planet\n" + "7. Info of a specific galaxy\n"
					+ "8. Info of a specific planet\n" + "9. Order a galaxy by distance from earth\n"
					+ "10. Order a planet by density\n" + "11. Name black holes with theirs galaxy name\n"
					+ "12. Telescope with more photos\n" + "13. Use test cases\n" + "14. Exit the program\n");

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
				
				case 7:// info of a galaxy
					infoGalaxy();
					break;

				case 8:// info of a specific planet
					infoPlanet();
					break;

				case 9:// order a galaxie by distance from earth
					orderDistance();
					break;

				case 10:// order a planet by density
					planetwithmoreDensity();
					break;

				case 11:// nameblackholes with theirs galaxy name
					namesBlackholeGalaxy();
					break;	
				
				case 12://
					controller.telescopeWithmorePhotos(null);
					break;

				case 13:
					//testcases
					break;

				case 14:
					flag = true;
					System.out.println("exiting the program. ");
					System.exit(0);
					scan.close();
					break;

				/* 
				case 15: // remove galaxy
					removeGalaxy(scan, controller);
					break;
				*/

				default:
					System.out.print("Please enter a valid option");
					break;
			}// switch
		} // while
	}// menu

	/**
	 * The function "createGalaxy" prompts the user to enter the name, distance to Earth, and shape of a
	 * galaxy, and then adds the galaxy to a controller object.
	 */
	public void createGalaxy() {
		System.out.println("Please enter the name of the galaxy: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the distance to Earth: ");
		double distanceToEarth = scan.nextDouble();
		scan.nextLine(); // Consume the newline character left in the buffer

		System.out.println("Please enter the shape of the galaxy:"+ "\n" + "ELLIPTICAL, SPIRAL, LENTICULAR, IRREGULAR ");
				
		String shape = scan.nextLine();

		addGalaxyPhoto();

		// Use the method from the Controller to add the galaxy
		//controller.registerGalaxy(galaxyName, distanceToEarth, shape);

		System.out.println(controller.add(galaxyName, distanceToEarth, shape));

		//System.out.println("Galaxy added successfully");

	}

	/**
	 * The function "createblackhole" prompts the user to enter various properties of a black hole, adds a
	 * photo of the black hole, and then registers the black hole using a controller method.
	 */
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
		
		addBlackHolePhoto();

		// Use the method from the Controller to add the black hole
		controller.registerBlackHole(blackholeName, mass, density, size, galaxyName,angularMoment, charge);

		System.out.println("Black hole added successfully");

	}

	/**
	 * The function "createplanet" prompts the user to enter information about a planet and then adds it
	 * to a controller object.
	 */
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

	/**
	 * The function removes a planet from a specified galaxy.
	 */
	public void removeplanet(){
		System.out.println("Please enter the name of the galaxy to remove the planet: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the name of the planet to remove: ");
		String planetName = scan.nextLine();

		// Use the method from the Controller to remove the planet
		controller.rmPlanet(galaxyName, planetName);

		System.out.println("Planet removed successfully");

	}

	/**
	 * The function "editplanet" prompts the user to enter the name of a galaxy and a planet, and then
	 * allows the user to edit the name, number of satellites, radius, and mass of the planet.
	 */
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

	/**
	 * The function prompts the user to enter information about a planet photo and then adds it to the
	 * system.
	 */
	public void addPlanetPhoto() {
		System.out.println("Please enter the name of the galaxy to add the photo: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the name of the planet to add the photo: ");
		String planetName = scan.nextLine();

		System.out.println("Please enter the photo URL ");
		String photoURL = scan.nextLine();

		System.out.println("Please enter the telescope that take the photo: ");
		String telescope = scan.nextLine();

		System.out.println("Please enter the photo creation year (in integers pls) : ");
		int photoCreationYear = scan.nextInt();

		System.out.println("Please enter the photo creation month (in integers pls) : ");
		int photoCreationMonth = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the photo creation day (in integers pls): ");
		int photoCreationDay = scan.nextInt();
		scan.nextLine();
		
		scan.nextLine();

		// Create a Calendar object with the given date
		Calendar photoCreationDate = Calendar.getInstance();
		photoCreationDate.set(photoCreationYear, photoCreationMonth - 1, photoCreationDay);

		// Use the method from the Controller to add the photo
		controller.registerPlanetPhoto(galaxyName, planetName, photoURL, telescope, photoCreationDate);

		System.out.println("Photo added successfully");
	}

	/**
	 * The function `addBlackHolePhoto` prompts the user to enter information about a black hole photo and
	 * then adds it to the system using a controller method.
	 */
	public void addBlackHolePhoto () {
		System.out.println("Please enter the name of the black hole to add the photo: ");
		String blackHoleName = scan.nextLine();

		System.out.println("Please enter the photo URL ");
		String photoURL = scan.nextLine();

		System.out.println("Please enter the telescope that take the photo: ");
		String telescope = scan.nextLine();

		System.out.println("Please enter the photo creation day (in integers pls): ");
		int photoCreationDay = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the photo creation month (in integers pls) : ");
		int photoCreationMonth = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the photo creation year (in integers pls) : ");
		int photoCreationYear = scan.nextInt();
		scan.nextLine();

		// Create a Calendar object with the given date
		Calendar photoCreationDate = Calendar.getInstance();
		photoCreationDate.set(photoCreationYear, photoCreationMonth - 1, photoCreationDay);

		// Use the method from the Controller to add the photo
		controller.registeBlackHolePhoto(blackHoleName, photoURL, telescope, photoCreationDate);

		System.out.println("Photo added successfully");


	}

	/**
	 * The function `addGalaxyPhoto` prompts the user to enter information about a galaxy photo and then
	 * adds it to the system using a controller method.
	 */
	public void addGalaxyPhoto () {

		System.out.println("Please enter the name of the galaxy to add the photo: ");
		String galaxyName = scan.nextLine();

		System.out.println("Please enter the photo URL ");
		String photoURL = scan.nextLine();

		System.out.println("Please enter the telescope that take the photo: ");
		String telescope = scan.nextLine();

		System.out.println("Please enter the photo creation day (in integers pls): ");
		int photoCreationDay = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the photo creation month (in integers pls) : ");
		int photoCreationMonth = scan.nextInt();
		scan.nextLine();

		System.out.println("Please enter the photo creation year (in integers pls) : ");
		int photoCreationYear = scan.nextInt();
		scan.nextLine();

		// Create a Calendar object with the given date
		Calendar photoCreationDate = Calendar.getInstance();
		photoCreationDate.set(photoCreationYear, photoCreationMonth - 1, photoCreationDay);

		// Use the method from the Controller to add the photo
		controller.registerGalaxyPhoto(galaxyName, photoURL, telescope , photoCreationDate);

		System.out.println("Photo added successfully");


	}



	/**
	 * The function "showGalaxy" retrieves information about a galaxy and prints it to the console.
	 */
	public static void showGalaxy(String[] args) {
		Controller controller = new Controller();
		String[] galaxyInfo = controller.getGalaxyInfo();
		for (String info : galaxyInfo) {
			System.out.println(info);
		}
	}
	
	/**
	 * The function prompts the user to enter the name of a galaxy, retrieves the information of the
	 * galaxy from the controller, and prints it out.
	 * 
	 * @return An empty string is being returned.
	 */
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

	/**
	 * The function prompts the user to enter the name of a galaxy and a planet, and then retrieves and
	 * displays information about that planet.
	 * 
	 * @return The method is returning an empty string.
	 */
	public String infoPlanet() {
		System.out.println("Please enter the name of the galaxy to see the info: ");
		String galaxyNameInfo = scan.nextLine();

		System.out.println("Please enter the name of the planet to see the info: ");
		String planetNameInfo = scan.nextLine();

		model.Planet planet = controller.infoPlanet(galaxyNameInfo, planetNameInfo);

		if (planet != null) {
			System.out.println(planet);
		} else {
			System.out.println("Planet not found.");
		}

		return "";
	}

	/**
	 * The function "orderDistance" prints the result of calling the "orderDistance" method on the
	 * "controller" object.
	 */
	public void orderDistance() {
		System.out.println(controller.orderDistance());
	
	}

	/**
	 * The function "planetwithmoreDensity" prints the name of the planet with the highest density.
	 */
	public void planetwithmoreDensity() {

		System.out.println(controller.planetwithmoreDensity());
	}

	/**
	 * The function prints the names of blackholes and their corresponding galaxies.
	 */
	public void namesBlackholeGalaxy() {
		//names of the blackhole name type and their galaxy
		System.out.println(controller.namesBlackholeGalaxy());
	}

	/**
	 * The function "telescopeWithmorePhotos" prints the result of a method call to
	 * "controller.telescopeWithmorePhotos()".
	 */



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
