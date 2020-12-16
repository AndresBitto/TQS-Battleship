package Battleship;

public class Board {
	
	
	
	private int m_board[][] = new int[8][8];
	
	private String m_adversaryboard[][] = new String[8][8];
	
	private int m_strikes = 0;
	
	
	
	
	
	
	public int getM_strikes() {
		return m_strikes;
	}

	public void setM_strikes(int m_strikes) {
		this.m_strikes = m_strikes;
	}

	public void generateboard() {
		//generates an empty board in order to start the match
		
		for (int row = 0; row < 8; row++) {

			for (int col = 0; col < 8; col++) {
				
				m_board[row][col] = 0; // 0 means you touched water
				m_adversaryboard[row][col] = " ";
				
			}
			
		}
		
		
	
	
		
	}

	public String[][] getM_adversaryboard() {
		return m_adversaryboard;
	}
/*
	public void setM_adversaryboard(String[][] m_adversaryboard) {
		this.m_adversaryboard = m_adversaryboard;
	}
*/
	public void printboard() {
		
		System.out.println("  A B C D E F G H");
		
		int row_number = 0;
		
		for (int row = 0; row < 8; row++) {
			
			System.out.print(row_number);
			System.out.print(" ");
			
			for (int col = 0; col < 8; col++) {
				
				System.out.print(m_board[row][col]);
				System.out.print(" ");
				
			}
			System.out.println();
			row_number++;
		}
	}
	
	public void printadversaryboard() {
		
		System.out.println("  A B C D E F G H");
		
		int row_number = 0;
		
		for (int row = 0; row < 8; row++) {
			
			System.out.print(row_number);
			System.out.print(" ");
			
			for (int col = 0; col < 8; col++) {
				
				System.out.print(m_adversaryboard[row][col]);
				System.out.print(" ");
				
			}
			System.out.println();
			row_number++;
		}
	}
	
	
	//MODIFICACIONES LIGERAS PARA AUTOMATED TESTING 
		public String printboardStr() {
			
			String finalOutput = "  A B C D E F G H\n";
			System.out.println("  A B C D E F G H");
			
			int row_number = 0;
			
			for (int row = 0; row < 8; row++) {
				
				System.out.print(row_number);
				System.out.print(" ");
				
				finalOutput = finalOutput + row_number + " ";
				
				for (int col = 0; col < 8; col++) {
					
					System.out.print(m_board[row][col]);
					System.out.print(" ");
					
					finalOutput = finalOutput + m_adversaryboard[row][col] + " ";
					
				}
				
				finalOutput = finalOutput + "\n";
				System.out.println();
				row_number++;
			}
			
			return finalOutput;
		}

		//MODIFICACIONES LIGERAS PARA AUTOMATED TESTING
		public String printadversaryboardStr() {
			
			String finalOutput = "  A B C D E F G H\n";
			
			System.out.println("  A B C D E F G H");
			
			int row_number = 0;
			
			for (int row = 0; row < 8; row++) {
				
				System.out.print(row_number);
				System.out.print(" ");
				
				finalOutput = finalOutput + row_number + " ";
				
				for (int col = 0; col < 8; col++) {
					
					System.out.print(m_adversaryboard[row][col]);
					System.out.print(" ");
					
					finalOutput = finalOutput + m_adversaryboard[row][col] + " ";
					
				}
				
				finalOutput = finalOutput + "\n";
				System.out.println();
				row_number++;
			}
			
			return finalOutput;
		}
	
	
	public Board() {
		generateboard();
	}

	public int[][] getM_board() {
		return m_board;
	}



}
