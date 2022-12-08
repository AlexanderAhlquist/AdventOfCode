package adventofcode_day7;

import java.util.ArrayList;

public class TreeNode {
	public Object data;
	public TreeNode parent;
	public ArrayList<TreeNode> children;

	public TreeNode(Object data) {
		this.data = data;
		this.children = new ArrayList<TreeNode>();
		this.parent = this;
	}

	public TreeNode addChild(TreeNode child) {
		this.children.add(child);
		this.parent = this;
		return child;

	}

	public TreeNode addChild(Object childData) {
		TreeNode child = new TreeNode(childData);
		this.children.add(child);
		this.parent = this;
		return child;
	}
	public TreeNode getParent(TreeNode child) {
		return child.parent;
	}
}
