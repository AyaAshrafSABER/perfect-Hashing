import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ReadKeysFile read = new ReadKeysFile();
		Integer[] inputs = read.readFile();
		HashTable2 hash = new HashTable2();
		hash.insetkey(inputs);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.printf("Time = %d ms \n", totalTime);
		System.out.println("Number of keys after duplicates removal : " + inputs.length);
		//System.out.println("Total size of table : " + hash.g);
		//System.out.println("Average number of rehashings per every O(N2) table : " + hash.getNumberOfrehashing());
		System.out.println("Number of rehashings : " + hash.getNumberOfrehashing());

	}

}
