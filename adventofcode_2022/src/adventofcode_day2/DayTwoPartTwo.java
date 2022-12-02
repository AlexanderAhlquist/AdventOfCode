package adventofcode_day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwoPartTwo {

	public static void main(String[] args) {
		int sum = 0;
		File file = new File("C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_2022\\src\\adventofcode_day2\\daytwoinput.txt");
		try (Scanner input = new Scanner(file)) {
			while (input.hasNext()) {
				String line = input.nextLine();
				switch (line) {
					case "A X": sum += 3;
					break;
					case "B X": sum += 1;
					break;
					case "C X": sum += 2;
					break;
					case "A Y": sum += 4;
					break;
					case "B Y": sum += 5;
					break;
					case "C Y": sum += 6;
					break;
					case "A Z": sum += 8;
					break;
					case "B Z": sum += 9;
					break;
					case "C Z": sum += 7;
					break;
					default: break;
				}
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
