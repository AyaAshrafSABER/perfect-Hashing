import java.util.ArrayList;

public interface INode {
	/**
	 * @param key
	 add keys with collision to bin to construct
	 static set of keys to build second level of hashing
	 */
	public void addkey (Integer key);
	/**
	 * @return
	 * check if the bin is empty or not 
	 */
	public boolean isEmpty();
	/**
	 * build second level of hashing using o(N^2) hash table with collide keys
	 */
	public void buildsecondLevel();
	/**
	 * @return
	 second level of hash.
	 */
	public IHashTable getSecondLevelTable();
	/**
	 * @return
	 array of collide element
	 */
	public ArrayList<Integer> getCollisions();	

}
