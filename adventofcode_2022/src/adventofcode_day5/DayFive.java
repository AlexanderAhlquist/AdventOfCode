package adventofcode_day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class DayFive {
	public static List<List<String>> moveBox(String[] instruction, List<List<String>> input) {
		int moveQuantity = Integer.parseInt(instruction[0]);
		int removeFrom = Integer.parseInt(instruction[1]) - 1;
		int destination= Integer.parseInt(instruction[2]) - 1;
		for (int i = 0; i < moveQuantity; i++) {
			input.get(destination).add(0, input.get(removeFrom).remove(0));
		}
		return input;
	}
	public static void main(String[] args) {
		List<String[]> inputParsed = new ArrayList<String[]>();
		List<String[]> startingBoxStacksParsed = new ArrayList<String[]>();
		int section = 0;
		File file = new File(
				"C:\\Users\\ahlqu\\OneDrive\\Desktop\\Java Projects\\AdventOfCode\\adventofcode_2022\\src\\adventofcode_day5\\dayfiveinput.txt");
		{
			try (Scanner input = new Scanner(file)) {
				while (input.hasNext()) {
					String line = input.nextLine();
					if (section == 0) {
						if (!line.isEmpty()) {
							String[] a = line.split("");
							String[] b = new String[(a.length / 4) + 1];
							int x = 0;
//							System.out.println(Arrays.toString(a));
							for (int i = 0; i < a.length; i++) {

								if (i % 4 == 1) {
									b[x] = a[i];
									x++;
								}
							}
							startingBoxStacksParsed.add(b);
//							System.out.println(Arrays.toString(b));
//							startingBoxStacks.add(a);
						} else {
							section++;
						}
					} else if (section == 1) {
						String[] temp;
						String temp2;
						temp2 = line.replace("move ", "");
						temp2 = temp2.replace(" from ", ",");
						temp2 = temp2.replace(" to ", ",");
						temp = temp2.split(",");
						inputParsed.add(temp);
					}
				}
				inputParsed.removeAll(Arrays.asList(" ", null));
				List<List<String>> boxStackList = new ArrayList<List<String>>();
				for (int i = 0; i < startingBoxStacksParsed.size(); i++) {
					String[] temp = startingBoxStacksParsed.get(i);
					List<String> temp2 = new ArrayList<String>();
					for (int j = 0; j < startingBoxStacksParsed.size(); j++) {
						temp2.add(temp[j]);

					}
					boxStackList.add(i, temp2);
				}
				List<List<String>> boxArrays = new ArrayList<List<String>>();
				for (int i = 0; i < boxStackList.get(0).size(); i++) {
					List<String> col = new ArrayList<String>();
					for (List<String> row : boxStackList) {
						col.add(row.get(i));
					}
					col.removeAll(Arrays.asList(" ", null));
					boxArrays.add(col);
				}
				for (int i = 0; i < boxArrays.size(); i++) {
					System.out.println((boxArrays.get(i)));
				}
				for (int i = 0; i < inputParsed.size(); i++) {
					System.out.println(Arrays.toString(inputParsed.get(i)));
					moveBox(inputParsed.get(i), boxArrays);
				}
				for (int i = 0; i < boxArrays.size(); i++) {
					System.out.println((boxArrays.get(i)));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
