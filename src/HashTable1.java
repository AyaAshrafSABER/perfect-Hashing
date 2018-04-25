import java.util.ArrayList;

/**
 * @author 
 * implement o(N)  space insertion.
 */
public class HashTable1 implements IHashTable {
	
	/**
	 * 
	 */
	private Node [] keys;
	/**
	 * 
	 */
	private UniversalH hashFunction; 
	private ArrayList<Integer> collisionsRehashing = new ArrayList<>();

	@Override
	public void insetkey(Integer[] input) {
		int sizeK = input.length;
		intializeSetOFKeys(sizeK);
		intializeHashFunction(input, sizeK);
		for (int i = 0; i < sizeK ; i++) {
			int hash = hashFunction.getHashValue(input[i]);
			if(keys[hash] == null) {
				keys[hash] = new Node();
			}
			//System.out.println(hash);
			keys[hash].addkey(input[i]);
		}
		handleCollisons(input);
		int size = calculateSize(); 
		//System.out.println(size);
		if (size > (keys.length * keys.length)) {
			this.insetkey(input);
		}
	}
	
	public int calculateSize() {
		int size = keys.length;
		for (int i = 0; i < keys.length; i++) {
			if (!(keys[i] == null)) {
				int sizeCol = keys[i].getCollisions().size();
				size += sizeCol*sizeCol;
			}
		}
		return size;
	}

	private void handleCollisons(Integer[] input) {
		for (int i = 0; i < input.length; i++) {
			if (!(keys[i] == null)) {
				keys[i].buildsecondLevel();
				collisionsRehashing.add(keys[i].getSecondLevelTable().getNumberOfrehashing());
			}
		}
	}
	
	public int getAverageNumberOfRehashing(){
		int sum = 0;
		for(int i : collisionsRehashing) {
			sum += i;
		}
		
		return sum / collisionsRehashing.size();
	}

	private void intializeSetOFKeys(Integer size) {
		keys = new Node[size];
/*		for (int i = 0; i < size; i++) {
			keys[i] = new Node();
		}*/

	}

	private void intializeHashFunction(Integer[] input, int length) {
		hashFunction = new UniversalH(input, length);
	}
	@Override
	public boolean findKey(Integer key) {
		if (!keys[hashFunction.getHashValue(key)].isEmpty()){
			return keys[hashFunction.getHashValue(key)].getSecondLevelTable().findKey(key);
		}
		return false;
	}


}
