package Battleship;

import java.util.Scanner;

public interface ConsoleInput {
	
	Scanner input = new Scanner(System.in);

	public String getInputStr();
	public int getInputInt();
	
}
