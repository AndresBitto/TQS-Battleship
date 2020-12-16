package Battleship;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class AutomatedCases {

	ConsoleInput inUser;
	ConsoleInput inCPU;
	
	public void testingFileLecture(String filename) throws FileNotFoundException {
		
		File txt = new File(filename);
		Scanner scan = new Scanner(txt);
		
		int dataLen = 0;
		int dataLenCPU = 0;
        
		String[] usrInputStr;
		int[] usrInputInt;

		String[] cpuInputStr;
		int[] cpuInputInt;
		
		if(scan.hasNextLine()) {
			
			String lineInd = scan.nextLine().replaceAll("\\s+","");
			
			String[] partsInd = lineInd.split(",");
			
			dataLen = Integer.parseInt(partsInd[0]);
			
			if (partsInd.length == 1) {
				dataLenCPU = dataLen;
			} else {
				dataLenCPU = Integer.parseInt(partsInd[1]);
			}
			
			usrInputStr = new String [dataLen];
			usrInputInt = new int [dataLen];
			
			cpuInputStr = new String [dataLenCPU];
	        cpuInputInt = new int [dataLenCPU];
			
			int index = 0;
			while(scan.hasNextLine() && (index < dataLen || index < dataLenCPU)){
				
				String line = scan.nextLine().replaceAll("\\s+","");
				
				String[] parts = line.split(",");
				
				
				if (index < dataLen) {
					usrInputStr[index] = parts[0];
					usrInputInt[index] = Integer.parseInt(parts[1]);
					
				}
				
				if (index < dataLenCPU) {
					cpuInputStr[index] = parts[2];
					cpuInputInt[index] = Integer.parseInt(parts[3]);
				}
				
				index++;
				
			}
			
			inUser 	= new MockInput(usrInputStr, usrInputInt);
			inCPU	= new MockInput(cpuInputStr, cpuInputInt);
	
		}
		
		
		scan.close();
	}

	@Test
	public void outOfBoundsAtShootingTest() throws FileNotFoundException {
		
		testingFileLecture("auto_OOB_shots.txt");
		coreExeOOBShots();
		
	}
	
	@Test
	public void missAtShootingTest() throws FileNotFoundException {
		
		testingFileLecture("auto_fallar_todas.txt");
		coreExeFallar();
		
	}
	
	@Test
	public void placingShipsAtSamePositionTest() throws FileNotFoundException {
		
		testingFileLecture("auto_placing_at_same_position.txt");
		coreExeAllocateSamePosition();
		
	}
	
	@Test
	public void outOfBoundsAtPlacingTest() throws FileNotFoundException {
		
		testingFileLecture("auto_OOB.txt");
		coreExeOOB();
		
	}
	
	@Test
	public void mimickingShotsTest() throws FileNotFoundException {
		
		testingFileLecture("auto_mimicking_shots.txt");
		coreExeSameShots();
		
	}
	
	@Test
	public void specialInputsTest() throws FileNotFoundException {
		
		testingFileLecture("auto_inputs_incorrectos.txt");
		coreExeSpecialInputs();
		
	}
	
	public void coreExeOOBShots() {

		Player you = new Player(inUser);
		Player cpu = new Player(inCPU);
		
				
		//you.insertship();
		//you.CPUinsertship(rand.randomallocation());
		
		String outToCheck = you.insertshipMock();
		
		System.out.println("This is your board");
		
		String checkTries = "";
		
		you.getM_playerboard().printboard();
		
		
		cpu.insertshipMock();//randomallocation mock?
		
		
		boolean finish = false;
		int countRounds = 0;
		do {
			countRounds++;
			
			System.out.println("////////////////////////////////////////");
			System.out.println("////////////////////////////////////////");
			int[][] direction = you.chooseshotdirectionMock(cpu.getM_playerboard());
			 
			outToCheck = you.chooseshotdirectionMock;
			
			if (countRounds == 1) {
				checkTries = "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = A	\n"
						+ "Enter a row number between 0 - 7: You entered -1\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = A	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = B	\n"
						+ "Enter a row number between 0 - 7: You entered -1	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = B	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = C	\n"
						+ "Enter a row number between 0 - 7: You entered -1	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = C	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = D	\n"
						+ "Enter a row number between 0 - 7: You entered -1	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = D	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = E	\n"
						+ "Enter a row number between 0 - 7: You entered -1	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = E	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = F	\n"
						+ "Enter a row number between 0 - 7: You entered -1	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = F	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = G	\n"
						+ "Enter a row number between 0 - 7: You entered -1	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = G	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = H	\n"
						+ "Enter a row number between 0 - 7: You entered -1	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = H	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ "Incorrect value row. must be between 0 - 7. try again\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered -1	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 0	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 1	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 2	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 3	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 4	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 5	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 6	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 7	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = I	\n"
						+ "Enter a row number between 0 - 7: You entered 8	\n"
						+ " Incorrect value for function string_to_int switch_case has failed 	\n"
						+ "Now you will have to try shoot a ship of the adversary board	\n"
						+ "Enter a word between A - H in capital letters: Text entered = B	\n"
						+ "Enter a row number between 0 - 7: You entered 3\n";
				
				assertTrue(outToCheck.equals(checkTries));
				
			}
			
			you.shoot(cpu.getM_playerboard(), direction);
			
			cpu.shoot(you.getM_playerboard(), cpu.chooseshotdirectionMock(you.getM_playerboard()));
			
			
			System.out.println(" ");
			System.out.println("Your adversary board:");
			System.out.println(" ");
			String playerBoard = you.getM_playerboard().printadversaryboardStr();
			
			System.out.println(" ");
			System.out.println("Your board:");
			System.out.println(" ");
			String cpuBoard = cpu.getM_playerboard().printadversaryboardStr();
			
			
			///
			System.out.println(" ");
			System.out.println("Your strikes are: " + you.getM_playerboard().getM_strikes());
			System.out.println(" ");
			
			///
			
			if (you.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			
			if (cpu.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			if (countRounds == 4) {
				
				checkTries = "  A B C D E F G H\n"
						+ "0 1               \n"
						+ "1                 \n"
						+ "2                 \n"
						+ "3                 \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(cpuBoard.equals(checkTries));
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               1 \n"
						+ "2                 \n"
						+ "3   1           1 \n"
						+ "4 1               \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(playerBoard.equals(checkTries));
				
				
			} else {
				
				
			}
				
				
			System.out.println(countRounds);
			
		} while (finish == false);
		
		
		
		if (you.getM_playerboard().getM_strikes() == 4) {
			System.out.println("You win like a champ");
		}else {
			System.out.println("You lose like a champ");
		}


	}
	
	public void coreExeSameShots() {

		Player you = new Player(inUser);
		Player cpu = new Player(inCPU);
		
		
		String outToCheck = you.insertshipMock();
		
		System.out.println("This is your board");
		
		String checkTries = "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 1\n"
				+ "There are 2 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 2\n"
				+ "There are 1 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 3\n";
		
		assertTrue(outToCheck.equals(checkTries));
		
		you.getM_playerboard().printboard();
		
		
		cpu.insertshipMock();//randomallocation mock?
		
		
		boolean finish = false;
		int countRounds = 0;
		do {
			countRounds++;
			
			
			int[][] direction = you.chooseshotdirectionMock(cpu.getM_playerboard());
			 
			you.shoot(cpu.getM_playerboard(), direction);
			
			cpu.shoot(you.getM_playerboard(), cpu.chooseshotdirectionMock(you.getM_playerboard()));
			
			
			System.out.println(" ");
			System.out.println("Your adversary board:");
			System.out.println(" ");
			String playerBoard = you.getM_playerboard().printadversaryboardStr();
			
			System.out.println(" ");
			System.out.println("Your board:");
			System.out.println(" ");
			String cpuBoard = cpu.getM_playerboard().printadversaryboardStr();
			
			
			///
			System.out.println(" ");
			System.out.println("Your strikes are: " + you.getM_playerboard().getM_strikes());
			System.out.println(" ");
			
			///
			
			if (you.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			
			if (cpu.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
			
			System.out.println(countRounds);
			
			if (countRounds == 1) {
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1                 \n"
						+ "2                 \n"
						+ "3   1             \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(playerBoard.equals(checkTries));
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1                 \n"
						+ "2                 \n"
						+ "3   0             \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(cpuBoard.equals(checkTries));	
		
				
			} else if (countRounds == 2) {
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               1 \n"
						+ "2                 \n"
						+ "3   1             \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(playerBoard.equals(checkTries));
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               0 \n"
						+ "2                 \n"
						+ "3   0             \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(cpuBoard.equals(checkTries));			
				
			} else if (countRounds == 3) {
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               1 \n"
						+ "2                 \n"
						+ "3   1           1 \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(playerBoard.equals(checkTries));
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               0 \n"
						+ "2                 \n"
						+ "3   0           0 \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(cpuBoard.equals(checkTries));	
				
				
			} else {
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               1 \n"
						+ "2                 \n"
						+ "3   1           1 \n"
						+ "4 1               \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(playerBoard.equals(checkTries));
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               0 \n"
						+ "2                 \n"
						+ "3   0           0 \n"
						+ "4 0               \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(cpuBoard.equals(checkTries));	
				
				
			}
				
				
			System.out.println(countRounds);
			
		} while (finish == false);
		
		
		
		if (you.getM_playerboard().getM_strikes() == 4) {
			System.out.println("You win like a champ");
		}else {
			System.out.println("You lose like a champ");
		}


	}
	
	public void coreExeFallar() {

		Player you = new Player(inUser);
		Player cpu = new Player(inCPU);
		
				
		//you.insertship();
		//you.CPUinsertship(rand.randomallocation());
		
		String outToCheck = you.insertshipMock();
		
		System.out.println("This is your board");
		
		String checkTries = "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 1\n"
				+ "There are 2 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 2\n"
				+ "There are 1 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 3\n";
		
		assertTrue(outToCheck.equals(checkTries));
		
		you.getM_playerboard().printboard();
		
		
		cpu.insertshipMock();//randomallocation mock?
		
		
		boolean finish = false;
		int countRounds = 0;
		do {
			countRounds++;
			
			
			int[][] direction = you.chooseshotdirectionMock(cpu.getM_playerboard());
			 
			you.shoot(cpu.getM_playerboard(), direction);
			
			cpu.shoot(you.getM_playerboard(), cpu.chooseshotdirectionMock(you.getM_playerboard()));
			
			
			System.out.println(" ");
			System.out.println("Your adversary board:");
			System.out.println(" ");
			String playerBoard = you.getM_playerboard().printadversaryboardStr();
			
			System.out.println(" ");
			System.out.println("Your board:");
			System.out.println(" ");
			String cpuBoard = cpu.getM_playerboard().printadversaryboardStr();
			
			
			///
			System.out.println(" ");
			System.out.println("Your strikes are: " + you.getM_playerboard().getM_strikes());
			System.out.println(" ");
			
			///
			
			if (you.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			
			if (cpu.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			if (countRounds == 60) {
				
				checkTries = "  A B C D E F G H\n"
						+ "0 1               \n"
						+ "1                 \n"
						+ "2                 \n"
						+ "3                 \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(cpuBoard.equals(checkTries));
				
				checkTries = "  A B C D E F G H\n"
						+ "0 0 0 0 0 0 0 0 0 \n"
						+ "1 0 0 0 0 0 0 0   \n"
						+ "2 0 0 0 0 0 0 0 0 \n"
						+ "3 0   0 0 0 0 0   \n"
						+ "4   0 0 0 0 0 0 0 \n"
						+ "5 0 0 0 0 0 0 0 0 \n"
						+ "6 0 0 0 0 0 0 0 0 \n"
						+ "7 0 0 0 0 0 0 0 0 \n";
				
				assertTrue(playerBoard.equals(checkTries));
				
				
			} else if (countRounds == 64) {
				  checkTries = "  A B C D E F G H\n"
							+ "0 1               \n"
							+ "1                 \n"
							+ "2                 \n"
							+ "3                 \n"
							+ "4                 \n"
							+ "5                 \n"
							+ "6                 \n"
							+ "7                 \n";
					
					assertTrue(cpuBoard.equals(checkTries));
					
					checkTries = "  A B C D E F G H\n"
							+ "0 0 0 0 0 0 0 0 0 \n"
							+ "1 0 0 0 0 0 0 0 1 \n"
							+ "2 0 0 0 0 0 0 0 0 \n"
							+ "3 0 1 0 0 0 0 0 1 \n"
							+ "4 1 0 0 0 0 0 0 0 \n"
							+ "5 0 0 0 0 0 0 0 0 \n"
							+ "6 0 0 0 0 0 0 0 0 \n"
							+ "7 0 0 0 0 0 0 0 0 \n";
					
					assertTrue(playerBoard.equals(checkTries));
				
			}
				
				
			System.out.println(countRounds);
			
		} while (finish == false);
		
		
		
		if (you.getM_playerboard().getM_strikes() == 4) {
			System.out.println("You win like a champ");
		}else {
			System.out.println("You lose like a champ");
		}


	}

	public void coreExeSpecialInputs() {

		Player you = new Player(inUser);
		Player cpu = new Player(inCPU);
		
				
		//you.insertship();
		//you.CPUinsertship(rand.randomallocation());
		
		System.out.println("/////////");
		System.out.println("/////////");
		
		String outToCheck = you.insertshipMock();
		
		
		
		String checkTries = "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = AASD\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = @\n"
				+ "Enter a row number between 0 - 7: You entered 1\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = NULL\n"
				+ "Enter a row number between 0 - 7: You entered 2\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = %\n"
				+ "Enter a row number between 0 - 7: You entered 3\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 1\n"
				+ "There are 2 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 2\n"
				+ "There are 1 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 3\n";
		
		
		assertTrue(outToCheck.equals(checkTries));
		
		System.out.println("This is your board");
		
		you.getM_playerboard().printboard();
		
		
		cpu.insertshipMock();
		
		
		boolean finish = false;
		int countRounds = 0;
		do {
			countRounds++;
			
			
			int[][] direction = you.chooseshotdirectionMock(cpu.getM_playerboard());
			 
			you.shoot(cpu.getM_playerboard(), direction);
			
			cpu.shoot(you.getM_playerboard(), cpu.chooseshotdirectionMock(you.getM_playerboard()));
			
			
			System.out.println(" ");
			System.out.println("Your adversary board:");
			System.out.println(" ");
			String playerBoard = you.getM_playerboard().printadversaryboardStr();
			
			System.out.println(" ");
			System.out.println("Your board:");
			System.out.println(" ");
			String cpuBoard = cpu.getM_playerboard().printadversaryboardStr();
			
			
			///
			System.out.println(" ");
			System.out.println("Your strikes are: " + you.getM_playerboard().getM_strikes());
			System.out.println(" ");
			
			///
			
			if (you.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			
			if (cpu.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
				
			System.out.println(countRounds);
			
		} while (finish == false);
		
		
		
		if (you.getM_playerboard().getM_strikes() == 4) {
			System.out.println("You win like a champ");
		}else {
			System.out.println("You lose like a champ");
		}


	}

	public void coreExeAllocateSamePosition() {

		Player you = new Player(inUser);
		Player cpu = new Player(inCPU);
		
				
		//you.insertship();
		//you.CPUinsertship(rand.randomallocation());
		
		String outToCheck = you.insertshipMock();
		
		System.out.println("This is your board");
		
		String checkTries = "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 1\n"
				+ "There are 2 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 2\n"
				+ "There are 1 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 3\n";
		
		assertTrue(outToCheck.equals(checkTries));
		
		you.getM_playerboard().printboard();
		
		
		cpu.insertshipMock();//randomallocation mock?
		
		
		boolean finish = false;
		int countRounds = 0;
		do {
			countRounds++;
			
			
			int[][] direction = you.chooseshotdirectionMock(cpu.getM_playerboard());
			 
			you.shoot(cpu.getM_playerboard(), direction);
			
			cpu.shoot(you.getM_playerboard(), cpu.chooseshotdirectionMock(you.getM_playerboard()));
			
			
			System.out.println(" ");
			System.out.println("Your adversary board:");
			System.out.println(" ");
			String playerBoard = you.getM_playerboard().printadversaryboardStr();
			
			System.out.println(" ");
			System.out.println("Your board:");
			System.out.println(" ");
			String cpuBoard = cpu.getM_playerboard().printadversaryboardStr();
			
			
			///
			System.out.println(" ");
			System.out.println("Your strikes are: " + you.getM_playerboard().getM_strikes());
			System.out.println(" ");
			
			///
			
			if (you.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			
			if (cpu.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			if (countRounds == 4) {
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               0 \n"
						+ "2                 \n"
						+ "3   0           0 \n"
						+ "4 0               \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(cpuBoard.equals(checkTries));
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               1 \n"
						+ "2                 \n"
						+ "3   1           1 \n"
						+ "4 1               \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(playerBoard.equals(checkTries));
				
				
			}
				
				
			System.out.println(countRounds);
			
		} while (finish == false);
		
		
		
		if (you.getM_playerboard().getM_strikes() == 4) {
			System.out.println("You win like a champ");
		}else {
			System.out.println("You lose like a champ");
		}


	}
	
	public void coreExeOOB() {

		Player you = new Player(inUser);
		Player cpu = new Player(inCPU);
		
				
		//you.insertship();
		//you.CPUinsertship(rand.randomallocation());
		
		String outToCheck = you.insertshipMock();
		
		System.out.println("This is your board");
		
		String checkTries = "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = B\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = B\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = C\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = C\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = D\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = D\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = E\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = E\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = F\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = F\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = G\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = G\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = H\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = H\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ "Incorrect value row. must be between 0 - 7. try again\n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered -1\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 1\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 2\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 3\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 4\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 5\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 6\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 7\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = I\n"
				+ "Enter a row number between 0 - 7: You entered 8\n"
				+ " Incorrect value for function string_to_int switch_case has failed \n"
				+ "There are 4 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 0\n"
				+ "There are 3 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 1\n"
				+ "There are 2 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 2\n"
				+ "There are 1 ships left to allocate\n"
				+ "Enter a word between A - H in capital letters: Text entered = A\n"
				+ "Enter a row number between 0 - 7: You entered 3\n";
		
		assertTrue(outToCheck.equals(checkTries));
		
		you.getM_playerboard().printboard();
		
		
		cpu.insertshipMock();//randomallocation mock?
		
		
		boolean finish = false;
		int countRounds = 0;
		do {
			countRounds++;
			
			
			int[][] direction = you.chooseshotdirectionMock(cpu.getM_playerboard());
			 
			you.shoot(cpu.getM_playerboard(), direction);
			
			cpu.shoot(you.getM_playerboard(), cpu.chooseshotdirectionMock(you.getM_playerboard()));
			
			
			System.out.println(" ");
			System.out.println("Your adversary board:");
			System.out.println(" ");
			String playerBoard = you.getM_playerboard().printadversaryboardStr();
			
			System.out.println(" ");
			System.out.println("Your board:");
			System.out.println(" ");
			String cpuBoard = cpu.getM_playerboard().printadversaryboardStr();
			
			
			///
			System.out.println(" ");
			System.out.println("Your strikes are: " + you.getM_playerboard().getM_strikes());
			System.out.println(" ");
			
			///
			
			if (you.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			
			if (cpu.getM_playerboard().getM_strikes() == 4) {
				finish = true;
			}
				
			if (countRounds == 4) {
				
				checkTries = "  A B C D E F G H\n"
						+ "0 1               \n"
						+ "1                 \n"
						+ "2                 \n"
						+ "3                 \n"
						+ "4                 \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(cpuBoard.equals(checkTries));
				
				checkTries = "  A B C D E F G H\n"
						+ "0                 \n"
						+ "1               1 \n"
						+ "2                 \n"
						+ "3   1           1 \n"
						+ "4 1               \n"
						+ "5                 \n"
						+ "6                 \n"
						+ "7                 \n";
				
				assertTrue(playerBoard.equals(checkTries));
				
			}
				
				
			System.out.println(countRounds);
			
		} while (finish == false);
		
		
		
		if (you.getM_playerboard().getM_strikes() == 4) {
			System.out.println("You win like a champ");
		}else {
			System.out.println("You lose like a champ");
		}


	}
}
