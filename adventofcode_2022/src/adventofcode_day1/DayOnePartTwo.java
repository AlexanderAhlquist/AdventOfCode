package adventofcode_day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * Solution by Alexander Ahlquist
 * 12/1/2022
 * as part of Advent of Code 2022
 * www.adventofcode.com
 * For part two, I had to find the elves that provided the top 3 highest calories, and return a sum of those calories. 
 */
public class DayOnePartTwo {

	public static void main(String[] args) {
		Integer tempSum = 0;
		HashMap<Integer, Integer> elfCalories = new HashMap<Integer, Integer>();
		Integer elfCount=0;
		File file = new File("C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_day1\\src\\adventofcode_day1\\dayoneinput.txt");
		try (Scanner input = new Scanner(file)) {
			while (input.hasNext()) {
				String line = input.nextLine();
				if (!line.isEmpty()) {
					tempSum += Integer.parseInt(line);
				}
				else if(line.isEmpty()) {
					elfCount ++;
					elfCalories.put(elfCount, tempSum);
					tempSum = 0;
				}
			}
			List<Integer> elfCaloriesByValue = new ArrayList<>(elfCalories.values());
			Collections.sort(elfCaloriesByValue, Collections.reverseOrder());
			System.out.println(elfCaloriesByValue.get(0) + elfCaloriesByValue.get(1) + elfCaloriesByValue.get(2));
		} catch (NumberFormatException | FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}

	}

}
