import java.util.Random;

public class MatrixMethod {
	
	private short  [][] h ; 
	private short [][] k;
	private int m;
	private Random rand;
	private double b;
	
	public MatrixMethod (int size) {
		m = size;
		b = 0;
		k = new short[32][1];
		rand = new Random();
		generateRandomHash();
	}

	private void generateRandomHash() {
	    b = Math.ceil(Math.log(m) / Math.log(2));
		h = new short[(int) b][32];
	    System.out.println(b);

		for (int i = 0; i < b; i++){
		    for (int j = 0; j < 32; j++){
		        h[i][j] = (short) rand.nextInt(2);
		    }
		}
		
	}
	//get hash value
	public int getHashValue(String key) {
		String keyB = Integer.toBinaryString(Integer.parseInt(key));
	    int bSize = keyB.length();

		generateKeyMatrix(keyB, bSize);

		short [][] index = new short[(int) b][1];
		for (int i = 0; i < b; i++) { // aRow
            for (int j = 0; j < 32; j++) { // aColumn
                index[i][0] += h[i][j] * k[j][0];
            }
            index[i][0] = (short) (index[i][0] % 2);
        }
    
		return getIntValue(index);
		
	}
	//get index value
	private int getIntValue(short[][] index) {
		int size = index.length;

		int num = 0;
		int factor = 0;
		for(int i = size -1 ; i >= 0; i--) {
			num += (int) (index[i][0] * Math.pow(2, factor));
			factor ++;
		}
		 num  = num % m;
		System.out.println(num);

		return num;
	}
	//new hash function
	public void regenerateHashMatrix () {
		h = new short[(int) b][32];
		for (int i = 0; i < b; i++)
		    for (int j = 0; j < 32; j++)
		        h[i][j] = (short) rand.nextInt(2);
	}
	//get matrix of bits
	private void  generateKeyMatrix(String keyB, int bSize) {
			int j = 32 - bSize;
			for(int i = 0; i <32; i++) {
				if( i < j) {
					k[i][0] = 0;
				} else {
					
					k[i][0] = (short) Character.getNumericValue(keyB.charAt(i - j));
			    }
				System.out.println(k[i][0]);

		   }
	}

}
