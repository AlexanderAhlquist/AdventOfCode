package adventofcode_day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Solution by Alexander Ahlquist
 * 12/1/2022
 * as part of Advent of Code 2022
 * www.adventofcode.com
 * For part one, I had to find the elf with the highest calorie count given a list of values. Each elf was separated by an empty line in a .txt file.
 */
public class DayOne {

	
	public static void main(String[] args) {
		int tempsum = 0;
		int[] topThree = new int[3];
		File file = new File("C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_2022\\src\\adventofcode_day1\\dayoneinput.txt");
		try (Scanner input = new Scanner(file)) {
			while (input.hasNext()) {
				String line = input.nextLine();
				if (!line.isEmpty()) {
					tempsum += Integer.parseInt(line);
				}
				else{
					if (topThree[0] < tempsum) {
						topThree[0] = tempsum;
						Arrays.sort(topThree);
						tempsum = 0;
					}
					tempsum = 0;
				}
			}
			System.out.println(topThree[2]);
			System.out.println(topThree[0]+ topThree[1] + topThree[2]);
		} catch (NumberFormatException | FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}

	}

}
