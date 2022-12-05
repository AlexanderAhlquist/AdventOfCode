package adventofcode_day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayFive {
	public static void main(String[] args) {
		List<String[]> inputSections = new ArrayList<String[]>();
		File file = new File(
				"C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_2022\\src\\adventofcode_day5\\dayfiveinput.txt");
		{
			try (Scanner input = new Scanner(file)) {
				while (input.hasNext()) {
					String line = input.nextLine();
					while (!input.nextLine().isEmpty()) {
						String[] a = line.split("");
						System.out.println(Arrays.toString(a));
						inputSections.add(a);
						break;
					}
					
					System.out.println(inputSections);

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
