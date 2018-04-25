import java.util.ArrayList;

public class Node implements INode{
	private ArrayList<Integer> collisions;
	private HashTable2 secondLevelHashing;

	public Node () {
		collisions = new ArrayList<Integer>();
		secondLevelHashing = new HashTable2();
	} 
	
	@Override
	public void addkey (Integer key) {
		collisions.add(key);
	}
	@Override
	public boolean isEmpty() {
		return collisions.size() == 0;
	}
	@Override
	public void buildsecondLevel() {
		Integer[] newSet = convertToArray();
		secondLevelHashing.insetkey(newSet);
	}
	@Override
	public HashTable2 getSecondLevelTable(){
		return (HashTable2) this.secondLevelHashing;
	}
	public ArrayList<Integer> getCollisions() {
		return this.collisions;
	}
	private Integer[] convertToArray() {
		Integer[] ret = new Integer[collisions.size()]; 
		for (int i = 0; i < collisions.size() ; i++) {
			ret[i] = collisions.get(i);
		}
		return ret;
		
	}
 }

