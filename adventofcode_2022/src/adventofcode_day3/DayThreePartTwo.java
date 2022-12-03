package adventofcode_day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayThreePartTwo {

	public static void main(String[] args) throws FileNotFoundException {
		int sum = 0;
		int temp = 0;
		char[] inp;
		int[] firstGroup = null;
		int[] secondGroup = null;
		int[] thirdGroup = null;
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
				if (firstGroup == null) {
					firstGroup = Arrays.copyOfRange(inpNum, 0, inpNum.length);
				}
				else if (secondGroup == null) {
					secondGroup = Arrays.copyOfRange(inpNum, 0, inpNum.length);
				}
				else if (thirdGroup == null) {
					thirdGroup = Arrays.copyOfRange(inpNum, 0, inpNum.length);
					Arrays.sort(firstGroup);
					Arrays.sort(secondGroup);
					Arrays.sort(thirdGroup);
//					System.out.print(Arrays.toString(firstGroup));
//					System.out.print(Arrays.toString(secondGroup));
//					System.out.print(Arrays.toString(thirdGroup));
					for (int i = 0; i < firstGroup.length; i++) {
						for (int j = 0; j < secondGroup.length; j++) {
							for (int k = 0; k < thirdGroup.length; k++) {
								if (firstGroup[i] == secondGroup[j] && secondGroup[j] == thirdGroup[k]) {
									temp = firstGroup[i];
									break;
								}
							}
						}
					}
					sum += temp;
					temp = 0;
					firstGroup = null;
					secondGroup = null;
					thirdGroup = null;
					
				}
				
				
			}
			System.out.println(sum);
		}
	}
}
