import java.util.Random;

public class UniversalH {

	private int p = Integer.MIN_VALUE, a, b;
	private int m;
	private Random rand;

	public UniversalH(Integer[] keys, int tableSize) {
		rand = new Random();
		m = tableSize;
		p = getPrime(keys);
		a = getFirstValue();
		b = getSecValue();
	}

	private int getSecValue() {
		return b = rand.nextInt(p - 1);
	}

	private int getFirstValue() {
		a = 1 + rand.nextInt(p - 1);
		if (a > p - 1) {
			a -= 1;
		}
		return a;
	}

	private int getPrime(Integer[] keys) {
		int maxKey = getMaxKey(keys);
		int i = maxKey + 1;
		while (true) {
			if (isPrime(i)) {
				return i;
			}
			i++;
		}
	}

	private boolean isPrime(int n) {
		if (n % 2 == 0) {
			return false;
		}

		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private int getMaxKey(Integer[] keys) {
		int n = Integer.MIN_VALUE;
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] >= n) {
				n = keys[i];
			}
		}
		return n;
	}

	public int getHashValue(int k) {
		return ((((a * k + b) % p) % m) + m) % m;

	}

	public void ubdateHash() {
		a = getFirstValue();
		b = getSecValue();
	}

}
