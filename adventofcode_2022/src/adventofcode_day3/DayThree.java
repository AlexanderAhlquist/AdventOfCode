package adventofcode_day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayThree {

	public static void main(String[] args) throws FileNotFoundException {
		int sum = 0;
		int temp = 0;
		char[] inp;
		int[] firstCompartment;
		int[] secondCompartment;
		File file = new File(
				"C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_2022\\src\\adventofcode_day3\\daythreeinput.txt");
		try (Scanner input = new Scanner(file)) {
			while (input.hasNext()) {
				String line = input.nextLine();
				inp = line.toCharArray();
				int inpNum[] = new int[inp.length];
				for (int i = 0; i < inp.length; i++) {
					if ((int) inp[i] >= 97) {
						inpNum[i] = inp[i] - 96;
					} else if ((int) inp[i] < 97) {
						inpNum[i] = inp[i] - 38;
					}

				}
//				System.out.println(Arrays.toString(inpNum));
				firstCompartment = Arrays.copyOfRange(inpNum, 0, inpNum.length / 2);
				secondCompartment = Arrays.copyOfRange(inpNum, inpNum.length / 2, inpNum.length);
				Arrays.sort(firstCompartment);
				Arrays.sort(secondCompartment);
//				System.out.println(Arrays.toString(firstCompartment));
//				System.out.println(Arrays.toString(secondCompartment));
				for (int i = 0; i < firstCompartment.length; i++) {
					for (int j = 0; j < secondCompartment.length; j++) {
						if (firstCompartment[i] == secondCompartment[j]) {
							temp = firstCompartment[i];
//							System.out.println(firstCompartment[i]);
							break;
						}
					}
				}
				sum += temp;
				temp = 0;
				
			}
			System.out.println(sum);
		}
	}
}
