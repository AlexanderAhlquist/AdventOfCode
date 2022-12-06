package adventofcode_day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DaySix {
	public static void uniqueString(int length, char[] array) {
		for (int i = 0; i < array.length; i++) {
			char[] temp = Arrays.copyOfRange(array, i, i + length);
			HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
			for (int j = 0; j < temp.length; j++) {
				hm.put(temp[j], j);
			}
			if (hm.keySet().size() == length) {
				System.out.println(i + length);
				System.out.println(hm.keySet());
				break;
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(
				"C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_2022\\src\\adventofcode_day6\\daysixinput.txt");
		try (Scanner input = new Scanner(file)) {
			while (input.hasNext()) {
				String line = input.nextLine();
				char[] inp = line.toCharArray();
				
				uniqueString(4, inp);
				uniqueString(14, inp);
				
			}
		}
	}
}
