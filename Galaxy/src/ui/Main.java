package ui;

import model.Controller;
import model.Galaxy;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Controller controller = new Controller();
		menu(scan, controller);
		scan.close();
		// Create a new Controller object

	}

	public static void menu(Scanner scan, Controller controller) {

		boolean flag = false;

		while (!flag) {
			System.out.println("Welcome to the menu \n");
			System.out.println("Options:\n" + "1. Create Galaxy \n" + "2. show all galaxies  \n"
					+ "3. info of a especific galaxy \n" + "4. remove galaxy \n" + "5. exit");

			int option = scan.nextInt();

			scan.nextLine();

			switch (option) {
				case 1:
					System.out.println("Please enter the name of the galaxy: ");
					String galaxyName = scan.nextLine();

					System.out.println("Please enter the distance to Earth: ");
					double distanceToEarth = scan.nextDouble();
					scan.nextLine(); // Consume the newline character left in the buffer

					System.out.println("Please enter the shape of the galaxy: ");
					String shape = scan.nextLine();

					// Use the method from the Controller to add the galaxy
					controller.registerGalaxy(galaxyName, distanceToEarth, shape);

					System.out.println("Galaxy added successfully");
					break;

				case 2:// show galaxies
						// Retrieve all galaxies from the Controller
						Galaxy[] galaxies = controller.getinfogalaxy();

						if (galaxies.length == 0) {
							System.out.println("No galaxies found.");
						} else {
							// Sort the galaxies array based on distance to Earth (from nearest to farthest)
							for (int i = 0; i < galaxies.length - 1; i++) {
								int minIndex = i;
								for (int j = i + 1; j < galaxies.length; j++) {
									if (galaxies[j] != null &&
										galaxies[i] != null &&
										galaxies[j].getDistanceToEarth() < galaxies[i].getDistanceToEarth()) {
										minIndex = j;
									}
								}
								
								// Swap galaxies[i] and galaxies[minIndex]
								Galaxy temp = galaxies[i];
								galaxies[i] = galaxies[minIndex];
								galaxies[minIndex] = temp;
							}
					
							System.out.println("Galaxies sorted by distance to Earth (from nearest to farthest):");
							for (int i = 0; i < galaxies.length; i++) {
								System.out.println("Galaxy " + (i + 1));
								if (galaxies[i] != null) {
									System.out.println("Galaxy Name: " + galaxies[i].getGalaxyName());
									System.out.println("Distance to Earth: " + galaxies[i].getDistanceToEarth());
								} else {
									System.out.println("This galaxy has been removed.");
								}
							}
						}
						break;

				case 3:// info of a specific galaxy

					System.out.println("Please enter the name of the galaxy to see the info: ");
					String galaxyNameInfo = scan.nextLine();
					Galaxy galaxy = controller.infoGalaxy(galaxyNameInfo);

					if (galaxy != null) {
						System.out.println(galaxy);
					} else {
						System.out.println("Galaxy not found.");
					}

					break;

				case 4:// remove galaxy
					System.out.println("Please enter the name of the galaxy to remove: ");
					String galaxyNameRemove = scan.nextLine();
					if (Controller.rmGalaxy(galaxyNameRemove)) {
						System.out.println("Galaxy removed successfully");
					} else {
						System.out.println("Galaxy not found.");
					}

					break;

				case 5:
					flag = true;
					System.out.println("exiting the program. ");
					System.exit(0);
					break;

				default:
					System.out.print("Please enter a valid option");
					break;
			}// switch
		} // while
	}// menu

}// class
