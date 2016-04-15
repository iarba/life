package lifeSim;
import java.util.Map;
import java.util.HashMap;

public class Row {
	private final Map<Integer, Cell> row = new HashMap<Integer, Cell>();
	
	public Row(){
	}
	
	public void put(int position, Cell c){
		row.put(position, c);
	}
	
	public Cell get(int position){
		if(containsKey(position)){
			return row.get(position);	
		}
		return null;
	}
	
	public boolean containsKey(int position){
		return row.containsKey(position);
	}
}
