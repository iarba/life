package lifeSim;

public class Cell {
	// true = alive, false = dead
	private boolean state;
	private int neighbours;
	private int row, col;
	
	public Cell(int r, int c){
		state = false;
		row = r;
		col = c;
	}
	
	public void setState(boolean state){
		this.state = state;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public void tick(){
		state = (state && neighbours == 2) || neighbours == 3;
		neighbours = 0;
	}
	
	public void add(){
		neighbours++;
	}
	
	public char display(){
		if(state) return '#';
		return ' ';
	}
	
	public boolean isAlive(){
		return state;
	}
	
	public boolean equals(Cell c2){
		return this.row == c2.row && this.col == c2.col;
	}
}
