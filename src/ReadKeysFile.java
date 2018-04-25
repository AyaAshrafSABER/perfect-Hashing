import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadKeysFile {
	private String filePath = "res/keys.txt";

	public Integer[] readFile() {
		StringBuffer stringBuffer = new StringBuffer();
		String line = "";

		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			while ((line = bufferedReader.readLine()) != null) {

				stringBuffer.append(line).append("\n");
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String str = stringBuffer.toString();
		while (!Character.isDigit(str.charAt(str.length() - 1))) {
			str = str.substring(0, stringBuffer.length() - 2);

		}

		return removeDuplicates(str);

	}

	private Integer[] removeDuplicates(String str) {
		String[] string = str.split(",");
		boolean[] check = new boolean[string.length];
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < string.length; i++) {
			int index = Integer.parseInt(string[i]);
			if (index >= check.length) {
				check = Arrays.copyOf(check, index + 5);
			}
			if (check[index] == true) {
				continue;
			} else {
				list.add(Integer.parseInt(string[i]));

				check[index] = true;
			}
		}

		//Integer[]string = new String[list.size()];
		Integer[]integer = new Integer[list.size()];


		list.toArray(integer);
		return integer;

	}
}
