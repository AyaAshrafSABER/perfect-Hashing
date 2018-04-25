
public interface IHashTable {
	/**
	 *Insert a static set of keys in hash table. 
	 */
	public void insetkey(Integer[] keys);
	/**
	 * @param key
	 look up for key in hash table.
	 * @return 
	 true if  the key is found 
	 false if it is not found.
	 */
	public boolean findKey(Integer key);

}
