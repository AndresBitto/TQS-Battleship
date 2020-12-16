package Battleship;

public class MockInput implements ConsoleInput {

	String[] usrInputStr;
	int[] usrInputInt;
	int indexStr = 0;
	int indexInt = 0;
	
	MockInput (String[] UserStr, int[] UserInt) {
		this.usrInputStr = UserStr;
		this.usrInputInt = UserInt;
	}
	
	@Override
	public String getInputStr() {
		String str = usrInputStr[indexStr];
		indexStr++;
		return str;
	}
	
	@Override
	public int getInputInt() {
		int num = usrInputInt[indexInt];
		indexInt++;
		return num;
	}
	
}
