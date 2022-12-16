package adventofcode_day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Node;

public class DaySeven {
	public TreeNode root;

	public DaySeven(TreeNode root) {
		this.root = root;
	}

	public void print() {
		print(this.root, 0);
	}

	public void print(TreeNode current, int level) {
		String levelMarks = "";
		for (int i = 0; i < level; i++) {
			levelMarks += "- ";
		}
		System.out.println(levelMarks + current.data);
		for (TreeNode child : current.children) {
			print(child, level + 1);
			
		}
	}
	public int count(TreeNode current) {
		if ((current.data instanceof String) == false) {
			return (int)current.data;
		}else {
			int sum = 0;
			for(TreeNode c : current.children) {
				sum += count(c);
				
			}
			if (sum < 100000) {
				return sum;
			}
			else {sum =0;}
			return sum;
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		TreeNode root = new TreeNode("/");
		TreeNode current = new TreeNode(null);
		File file = new File(
				"C:\\Users\\Alexander Ahlquist\\Desktop\\AdventOfCode\\adventofcode_2022\\src\\adventofcode_day7\\testday7.txt");
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String line = input.nextLine();

			if (line.equals("$ cd /")) {
				root = new TreeNode(line.substring(5));
				current = root;
				System.out.println("Creating a new tree");
			} else if (line.equals("$ cd ..")) {
				current = current.parent;
				System.out.println("Going up a level");
			} else if (line.substring(0, 4).equals("$ cd")) {
				
				current = current.addChild(line.substring(5));
				
				System.out.println("Created new node");
			} else if (line.matches(".*\\d.*")) {
				current.addChild(Integer.parseInt(line.replaceAll("[^0-9]", "")));
				System.out.println("Added data");
			}
			
		}
		DaySeven tree = new DaySeven(root);
		tree.print(root, 1);
		System.out.println(tree.count(root));
	}
}