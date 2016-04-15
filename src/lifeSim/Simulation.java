package lifeSim;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Simulation {
	private final Map<Integer, Row> map = new HashMap<Integer, Row>();
	private final List<Cell> cells = new ArrayList<Cell>();
	private final List<Cell> extraCells = new ArrayList<Cell>();
	private int generation;
	
	public Simulation(){
		generation = 0;
	}
	
	public void alterCell(int row, int col, boolean state){
		Cell c = pingCell(row, col);
		c.setState(state);
		if(extraCells.contains(c)){
			extraCells.remove(c);
			cells.add(c);
		}
	}
	
	private Cell pingCell(int row, int col){
		if(!map.containsKey(row)){
			map.put(row, new Row());
		}
		Row auxRow = map.get(row);
		if(!auxRow.containsKey(col)){
			Cell newCell = new Cell(row, col);
			extraCells.add(newCell);
			auxRow.put(col, newCell);
		}
		return auxRow.get(col);
	}
	
	public void tick(){
		Iterator<Cell> i;
		i = extraCells.iterator();
		while(i.hasNext()){
			cells.add(i.next());
		}
		extraCells.clear();
		i = cells.iterator();
		while(i.hasNext()){
			i.next().tick();
		}
		generation++;
	}
	
	public void update(){
		Iterator<Cell> i = cells.iterator();
		Cell c;
		while(i.hasNext()){
			c = i.next();
			if(c.isAlive()){
				pingNeighbours(c);
			}
			
		}
	}
	
	private void pingNeighbours(Cell c){
		for(int dR = -1; dR <= 1; dR++){
			for(int dC = -1; dC <= 1; dC++){
				if(dR != 0 || dC != 0){
					pingCell(c.getRow() + dR, c.getCol() + dC).add();
				}
			}
		}
	}
	
	public String print(int startR, int startC, int height, int width){
		String display = "";
		for(int row = startR; row < startR + height; row++){
			for(int col = startC; col < startC + width; col++){
				display += getChar(row, col);
			}
			display += '\n';
		}
		return display;
	}
	
	private char getChar(int row, int col){
		Cell c = pingCell(row, col);
		if(extraCells.contains(c)){
			extraCells.remove(c);
			cells.add(c);
		}
		return c.display();
	}
	
	public int getGeneration(){
		return generation;
	}
}
