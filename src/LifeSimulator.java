import lifeSim.Simulation;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintStream;

public class LifeSimulator{
	
	public static void main(String[] args)  throws FileNotFoundException{
		Scanner scanner = new Scanner(System.in);
		PrintStream printer = new PrintStream(System.out);
		if(args.length>0){
			scanner = new Scanner(new java.io.File(args[0]));
		}
		if(args.length>1){
			printer = new PrintStream(args[1]);
		}
		runSim(scanner, printer);
	}
	
	private static void runSim(Scanner scanner, PrintStream printer){
		String input;
		int row = 0, col = 0, height = 22, width = 80;
		int auxrow, auxcol;
		Simulation simulation = new Simulation();
		boolean didwork;
		printer.print("Current generation: ");
		printer.println(simulation.getGeneration());
		while(scanner.hasNext()){
			didwork = false;
			input = scanner.next();
			input = input.toUpperCase();
			if(input.equals("EXIT") || input.equals("QUIT")){
				didwork = true;
				return;
			}
			if(input.equals("HELP")){
				didwork = true;
				printer.println("Commands: ");
				printer.println("ADD row col - places a living cell at" +
						" the given location.");
				printer.println("KILL row col - places a dead cell at" +
						" the given location.");
				printer.println("TICK - runs the simulation for 1 turn.");
				printer.println("TICKFOR ticks - runs the simulation for" +
						" the given ammount of time.");
				printer.println("PRINT - displays the simulation.");
				printer.println("SETPRINT row, col, height, width - sets" +
						" the printing coordinates.");
				printer.println("EXIT - Closes the simulation.");
				printer.println("QUIT - Same as EXIT.");
				printer.println("HELP - Displays a list of commands.");
			}
			if(input.equals("ADD")){
				didwork = true;
				auxrow = scanner.nextInt();
				auxcol = scanner.nextInt();
				simulation.alterCell(auxrow, auxcol, true);
			}
			if(input.equals("KILL")){
				didwork = true;
				auxrow = scanner.nextInt();
				auxcol = scanner.nextInt();
				simulation.alterCell(auxrow, auxcol, false);
			}
			if(input.equals("PRINT")){
				didwork = true;
				printer.print(simulation.print(row, col, height, width));
			}
			if(input.equals("SETPRINT")){
				didwork = true;
				row = scanner.nextInt();
				col = scanner.nextInt();
				height = scanner.nextInt();
				width = scanner.nextInt();
				printer.print("Printing coordinates (");
				printer.print(row);
				printer.print("; ");
				printer.print(col);
				printer.print(") -> (");
				printer.print(row + height - 1);
				printer.print("; ");
				printer.print(col + width - 1);
				printer.println(").");
			}
			if(input.equals("TICK")){
				didwork = true;
				simulation.update();
				simulation.tick();
			}
			if(input.equals("TICKFOR")){
				didwork = true;
				int tick = scanner.nextInt();
				while(tick >= 1){
					simulation.update();
					simulation.tick();
					tick--;
				}
			}
			if(!didwork){
				printer.println("Error on input");
			}
			printer.print("Current generation: ");
			printer.println(simulation.getGeneration());
		}
	}
}
