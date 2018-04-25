
/**
 * @author AyaOsman implements O(N^2) space insertion for static set of keys.
 *
 */
public class HashTable2 implements IHashTable {
	private Integer[] keys;
	private UniversalH universalH;
	int counter = 0;
	@Override
	public void insetkey(Integer[] input) {
		int sizeK = input.length;
		intializeHashFunction(input, sizeK);
		intializeSetOFKeys(sizeK);
		for (int i = 0; i < sizeK; i++) {
			int hash = universalH.getHashValue(input[i]);
			if (keys[hash] == null || keys[hash] == input[i]) {
				keys[hash] = input[i];
			} else {
				counter++;
				universalH.ubdateHash();
				intializeSetOFKeys(sizeK);
				i = -1;
			}
		}

	}

	private void intializeSetOFKeys(Integer size) {
		keys = new Integer[size * size];

	}
	public int getNumberOfrehashing() {
		return counter;
	}
	private void intializeHashFunction(Integer[] input, int length) {
		universalH = new UniversalH(input, length*length);
	}

	@Override
	public boolean findKey(Integer key) {
		if (keys[universalH.getHashValue(key)] == key) {
			return true;
		}
		return false;
	}

}
