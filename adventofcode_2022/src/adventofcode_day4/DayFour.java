package adventofcode_day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayFour {
	public static void main(String[] args) throws FileNotFoundException {
		String[] arr;

		int pairs = 0;
		int overlap = 0;
		File file = new File(
				"C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_2022\\src\\adventofcode_day4\\dayfourinput.txt");
		{
			try (Scanner input = new Scanner(file)) {
				while (input.hasNext()) {
					String line = input.nextLine();
					arr = line.split("[,-]");
//					System.out.println(Arrays.toString(arr));
					int[] arrNums = new int[arr.length];
					for (int i = 0; i < arr.length; i++) {
						arrNums[i] = (Integer.parseInt(arr[i]));
					}
					System.out.println(Arrays.toString(arrNums));
					if (arrNums[0] >= arrNums[2] && arrNums[1] <= arrNums[3]) {
						pairs++;
					} else if (arrNums[0] <= arrNums[2] && arrNums[1] >= arrNums[3]) {
						pairs++;
					}

					if (arrNums[0] <= arrNums[3] && arrNums[1] >= arrNums[2]) {
						overlap++;
					} else if (arrNums[2] <= arrNums[1] && arrNums[3] >= arrNums[1]) {
						overlap++;
					}

				}
				System.out.println(overlap);
				System.out.println(pairs);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}