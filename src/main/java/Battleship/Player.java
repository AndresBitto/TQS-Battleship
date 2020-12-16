package Battleship;
import java.util.Scanner;

public class Player {
	
	private Board m_playerboard;
	private ConsoleInput in;
	
	String string_to_intErrorMsg = "";
	//public String chooseshotdirectionMock_ErrorMsg = "";
	public String chooseshotdirectionMock = "";
	public Player(ConsoleInput in) {
		
		m_playerboard = new Board();
		this.in = in;
		
	}
	
	
	public Board getM_playerboard() {
		return m_playerboard;
	}


	public int[][] chooseshotdirection(Board target_board ) {
		
		Scanner input = new Scanner(System.in);
		String col_pos;
		int row_pos;
		
		do {
			
		System.out.println("Now you will have to try shoot a ship of the adversary board");
			
			
		// Getting String input
        System.out.print("Enter a word between A - H in capital letters: ");
        col_pos = input.next();
        System.out.println("Text entered = " + col_pos);
        
        // Getting int input
        System.out.print("Enter a row number between 0 - 7: "); 
        row_pos = input.nextInt();
        System.out.println("You entered " + row_pos);
	        
        
        
		} while (!targetableposition(target_board, col_pos, row_pos));
		
		
		
		int[][] position = {{row_pos,string_to_int(col_pos)}};
		
		return position;
		
		
		
		
	}
	//MODIFICACIONES LIGERAS PARA AUTOMATED TESTING
	public int[][] chooseshotdirectionMock(Board target_board ) {
		
		
		Scanner input = new Scanner(System.in);
		String col_pos;
		int row_pos;
		chooseshotdirectionMock = "";
		
		do {
			
			if (!string_to_intErrorMsg.equals(""))
	        	chooseshotdirectionMock += string_to_intErrorMsg;
			
		System.out.println("Now you will have to try shoot a ship of the adversary board");
		chooseshotdirectionMock += "Now you will have to try shoot a ship of the adversary board" + "\n";
			
		// Getting String input
        System.out.print("Enter a word between A - H in capital letters: ");
        chooseshotdirectionMock += "Enter a word between A - H in capital letters: ";
        //col_pos = input.next();
        col_pos = in.getInputStr();
        System.out.println("Text entered = " + col_pos);
        chooseshotdirectionMock += "Text entered = " + col_pos + "\n";
        
        // Getting int input
        System.out.print("Enter a row number between 0 - 7: "); 
        chooseshotdirectionMock += "Enter a row number between 0 - 7: ";
        //row_pos = input.nextInt();
        row_pos = in.getInputInt();
        System.out.println("You entered " + row_pos);
        chooseshotdirectionMock += "You entered " + row_pos + "\n";;
	        
        
        
//        if (!chooseshotdirectionMock_ErrorMsg.equals(""))
//        	chooseshotdirectionMock_ErrorMsg += string_to_intErrorMsg + "\n";
        
        
		} while (!targetableposition(target_board, col_pos, row_pos));
		
		
		
		int[][] position = {{row_pos,string_to_int(col_pos)}};
		
		
		
		return position;
		
		
		
		
	}
	
	public String int_to_string(int col) {
		string_to_intErrorMsg = "";
		
		String col_pos = null;
		
	       switch (col) {
			case 0:
				col_pos = "A";
				break;
			case 1:
				col_pos = "B";
				break;
			case 2:
				col_pos = "C";
				break;
			case 3:
				col_pos = "D";
				break;
			case 4:
				col_pos = "E";
				break;
			case 5:
				col_pos = "F";
				break;
			case 6:
				col_pos = "G";
				break;
			case 7:
				col_pos = "H";
				break;
				
			default:
				System.out.println(" Incorrect value for function CPUinsertship switch_case has failed ");
				string_to_intErrorMsg = " Incorrect value for function CPUinsertship switch_case has failed ";
				
				col_pos = "ERROR";
				break;
			}
	       
	       return col_pos;
		
	}

	public int shoot(Board target_board, int[][] direction_to_shoot) {
		
		
		String col_pos = int_to_string(direction_to_shoot[0][1]);
		int row_pos = direction_to_shoot[0][0];
		
		int result = -1;
		
        
        if (targetableposition(target_board, col_pos, row_pos)) {
        	
			int converted_col = string_to_int(col_pos);
			result = target_board.getM_board()[row_pos][converted_col];
			String converted_result = Integer.toString(result);
			
			if (this.getM_playerboard().getM_adversaryboard()[row_pos][converted_col] == " ") {
				
				this.getM_playerboard().getM_adversaryboard()[row_pos][converted_col] = converted_result;
				
				if (result == 1) {
					this.getM_playerboard().setM_strikes(this.getM_playerboard().getM_strikes() + 1);
				}
			}
			
			
			
		}
	            
		
		
		return result;
	}
	
	
	public int CPUshoot(Board target_board, int[][]shot_position) {
		
		Scanner input = new Scanner(System.in);
		
		String col_pos = int_to_string(shot_position[0][1]);
		int row_pos = shot_position[0][0];
		

		
		int result = -1;
		

		

			
        System.out.println("Text entered = " + col_pos);
        

        System.out.println("You entered " + row_pos);
	        
	        if (targetableposition(target_board, col_pos, row_pos)) {
	        	
				int converted_col = string_to_int(col_pos);
				result = target_board.getM_board()[row_pos][converted_col];
				String converted_result = Integer.toString(result);
				
				if (this.getM_playerboard().getM_adversaryboard()[row_pos][converted_col] == " ") {
					
					this.getM_playerboard().getM_adversaryboard()[row_pos][converted_col] = converted_result;
					
					if (result == 1) {
						this.getM_playerboard().setM_strikes(this.getM_playerboard().getM_strikes() + 1);
					}
				}
				
				
				
			}
	        
	        
        
        
        
		
		
		return result;
	}

	
	public boolean targetableposition(Board board, String position_col, int position_row) {
		//returns true if the selected position is valid (inside the board)
		//returns false if the selected position invalid (outside the board)
		
		int col_to_numeric = string_to_int(position_col);
		
		boolean selectable = false;
		boolean correct_col = true;
		boolean correct_row = false;
		
		if (position_row > -1 && position_row < 8) {
			correct_row = true;
		}
		
		
		if (col_to_numeric == -1) {
			correct_col = false;
		}
	
		if (correct_col && correct_row) {
			selectable = true;
		}

		
		
		
		return selectable;
	}

	
	
	


	public boolean marcableposition(Board board, String position_col, int position_row) {
		//returns true if the selected position is available to put a ship on it.
		//returns false if the selected position has already a ship on it.
		
		int col_to_numeric = string_to_int(position_col);
		
		boolean selectable = false;
		boolean correct_col = true;
		boolean correct_row = false;
		

		if (col_to_numeric == -1) {
			correct_col = false;
		}
		
		if (position_row > -1 && position_row < 8) {
			correct_row = true;
		}
		
		if (correct_col && correct_row && board.getM_board()[position_row][col_to_numeric] == 0) {
			selectable = true;
		}
		
		
		return selectable;
	}

	
	
	
	public int string_to_int(String col) {
		
		string_to_intErrorMsg = "";
		int col_to_numeric = -1;
		
		switch (col) {
		case "A":
			col_to_numeric = 0;
			break;
		case "B":
			col_to_numeric = 1;
			break;
		case "C":
			col_to_numeric = 2;
			break;
		case "D":
			col_to_numeric = 3;
			break;
		case "E":
			col_to_numeric = 4;
			break;
		case "F":
			col_to_numeric = 5;
			break;
		case "G":
			col_to_numeric = 6;
			break;
		case "H":
			col_to_numeric = 7;
			break;
			
		default:
			System.out.println(" Incorrect value for function string_to_int switch_case has failed ");
			string_to_intErrorMsg += " Incorrect value for function string_to_int switch_case has failed \n";
			col_to_numeric = -1;
			break;
		}
		
		return col_to_numeric;
	}
	
	
	
	
	public void insertship() {
		//This functions try to insert a ship in the board of the player
		//The position to insert the ship is selected with the keyboard by the user
		
		Scanner input = new Scanner(System.in);
		
		String col_pos;
		int row_pos;
		int number_of_ships = 4;
		
		
		do {
			
		System.out.println("There are " + number_of_ships + " ships left to allocate");
			
			
		// Getting String input
        System.out.print("Enter a word between A - H in capital letters: ");
        col_pos = input.next();
        System.out.println("Text entered = " + col_pos);
        
        // Getting int input
        System.out.print("Enter a row number between 0 - 7: ");
        row_pos = input.nextInt();
        System.out.println("You entered " + row_pos);
        
	        if (marcableposition(m_playerboard, col_pos, row_pos)) {
				number_of_ships--;
				int converted_col = string_to_int(col_pos);
		        m_playerboard.getM_board()[row_pos][converted_col] = 1;
				
			}
	        
	        
        
        
		} while (number_of_ships != 0);
        
        
        
        
		
		
		
	}
	
	//MODIFICACIONES LIGERAS PARA AUTOMATED TESTING
	public String insertshipMock() {
		//This functions try to insert a ship in the board of the player
		//The position to insert the ship is selected with the keyboard by the user
		
		String allOutput = "";
		
		Scanner input = new Scanner(System.in);
		
		String col_pos;
		int row_pos;
		int number_of_ships = 4;
		
		
		do {
			
		System.out.println("There are " + number_of_ships + " ships left to allocate");
		allOutput += "There are " + number_of_ships + " ships left to allocate" + "\n";
			
		// Getting String input
        System.out.print("Enter a word between A - H in capital letters: ");
        allOutput += "Enter a word between A - H in capital letters: ";
        //col_pos = input.next();
        col_pos = in.getInputStr();
        System.out.println("Text entered = " + col_pos);
        allOutput += "Text entered = " + col_pos + "\n";
        
        // Getting int input
        System.out.print("Enter a row number between 0 - 7: ");
        allOutput += "Enter a row number between 0 - 7: ";
        
        //row_pos = input.nextInt();
        row_pos = in.getInputInt();
        System.out.println("You entered " + row_pos);
        allOutput += "You entered " + row_pos + "\n";
        
	        if (marcableposition(m_playerboard, col_pos, row_pos)) { 
	        	
				number_of_ships--;
				int converted_col = string_to_int(col_pos);
		        m_playerboard.getM_board()[row_pos][converted_col] = 1;
				
			}
	        
	        if (!string_to_intErrorMsg.equals(""))
        		allOutput += string_to_intErrorMsg;
	        

		} while (number_of_ships != 0);

		
		return allOutput;
	}
	

	public void CPUinsertship(int[][] shipsposition) {
		//This functions try to insert a ship in the board of the player
		
		
		String col_pos = null;
		int row_pos;
		int number_of_ships = 4;
		
		
		do {
		
			col_pos = int_to_string(shipsposition[number_of_ships - 1][1]);        

	        System.out.println("CPU entered = " + col_pos);
	        
	        // Getting int input
	        row_pos = shipsposition[number_of_ships - 1][0];
	        System.out.println("CPU entered " + row_pos);
        
        

        
	        if (marcableposition(m_playerboard, col_pos, row_pos)) {
				number_of_ships--;
				int converted_col = string_to_int(col_pos);
		        m_playerboard.getM_board()[row_pos][converted_col] = 1;
				
			}
	        
	        
        
        
		} while (number_of_ships != 0);
        
        
		
	}
	
	
	

	public Player() {
		
		m_playerboard = new Board();
		
	}
	
}
