package adventofcode_day1;

import java.io.File;
import java.io.FileNotFoundException;
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
		int highest = 0;
		int tempsum = 0;
		int highestElf=0;
		int elfCount=0;
		File file = new File("C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_day1\\src\\adventofcode_day1\\dayoneinput.txt");
		try (Scanner input = new Scanner(file)) {
			//goes through the .txt file line by line
			while (input.hasNext()) {
				String line = input.nextLine();
				if (!line.isEmpty()) {
					//if the next line is not empty, meaning additional calories from the same elf, the value of the calories is added to a temporary variable
					tempsum += Integer.parseInt(line);
				}
				else if(line.isEmpty()) {
					//if the next line is empty, that means the current elf will have no more calories added to their total
					//we can add 1 to the elfCount since we have counted their items.
					elfCount ++;
					if (tempsum > highest) {
						//if the sum of the calories is higher than the current highest value, the highest value is replaced
						//and the highestElf is replaced with the current elfCount.
						highest = tempsum;
						highestElf = elfCount;
						//tempsum is set back to 0.
						tempsum = 0;
					}
					else {
						//if the elf does not have a higher value calorie count, the tempsum is set back to zero.
						tempsum = 0;
					}
				}

			}
			//prints the total elf count, the highest calorie elf position out of all the elves, and the highest calorie count.
			System.out.println(elfCount + " "+ highestElf + " "+ highest);
		} catch (NumberFormatException | FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}

	}

}
