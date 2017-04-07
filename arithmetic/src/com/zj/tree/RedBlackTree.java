package com.zj.tree;

/**
 * 红黑树实现
 * 红黑二叉查找树 实现 2-3查找树
 * 优点： 结合了二叉查找树简洁高效的查找方法 和 2-3树中高效的平衡插入算法
 * 
 * @author Administrator
 *
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

	private final static boolean RED = true;
	private final static boolean BLACK = false;
	
	//根节点
	private Node root;
	
	class Node{
		
		private Key key;
		private Value value;

		//左右子树
		private Node left,right;
		
		//当前子树节点数
		private int n;
		
		//颜色值
		private boolean color;

		public Node(Key key, Value value, boolean color, int n) {
			this.key = key;
			this.value = value;
			this.color = color;
			this.n = n;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + ", n=" + n
					+ ", color=" + color + "]";
		}
		
	}
	
	public int size(Node n){
		if(n == null){
			return 0;
		}
		return n.n;
	}
	
	//判断节点颜色
	public boolean isRed(Node n){
		if (n == null) {
			return BLACK;
		}
		return n.color;
	}
	
	//左旋方法
	public Node rotateLeft(Node n){
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		
		x.n = n.n;
		n.n = size(n.left) + size(n.right) + 1;
		
		x.color = n.color;
		n.color = RED;
		
		return x;
	}
	
	//右旋方法
	public Node rotateRight(Node n){
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		
		x.n = n.n;
		n.n = size(n.left) + size(n.right) + 1;
		
		x.color = n.color;
		n.color = RED;
		return x;
	}
	
	//颜色转换
	public void flipColor(Node n){
		n.color = RED;
		n.left.color = BLACK;
		n.right.color = BLACK;
	}
	
	//插入方法
	public Node put(Key key, Value value){
		root = put(root, key, value);
		root.color = BLACK;
		return root;
	}
	
	public Node put(Node n, Key key, Value value){
		
		if (n == null) {
			return new Node(key, value, RED, 1);
		}
		
		int com = n.key.compareTo(key);
		if (com < 0) {
			n.right = put(n.right, key, value);
		} else if (com > 0) {
			n.left = put(n.left, key, value);
		} else {
			n.value = value;
		}
		
		if (isRed(n.right) && !isRed(n.left)) {
			n = rotateLeft(n);
		}
		if (isRed(n.left) && isRed(n.left.left)){
			n = rotateRight(n);
		}
		if (isRed(n.left) && isRed(n.right)) {
			flipColor(n);
		}
		
		n.n = size(n.left) + size(n.right) + 1;
		
		return n;
	}
	
	/**
	 * 先序遍历树
	 * @param root
	 */
	public void ergodic(Node root){
		
		if (root == null) {
			return;
		}
		System.out.println(root);
		if (root.left != null) {
			ergodic(root.left);
		}
		
		if (root.right != null) {
			ergodic(root.right);
		}
	}
	
	
	public static void main(String[] args) {
		RedBlackTree<Integer, Character> redBlack = new RedBlackTree<>();
		
		RedBlackTree.Node root = null;
		redBlack.ergodic(root);
		
		root = redBlack.put(19, 'S');
		redBlack.ergodic(root);
		
		root = redBlack.put(5, 'E');
		redBlack.ergodic(root);
		
		root = redBlack.put(1, 'A');
		redBlack.ergodic(root);
		
		root = redBlack.put(18, 'R');
		redBlack.ergodic(root);
		
		root = redBlack.put(3, 'C');
		redBlack.ergodic(root);
		
		root = redBlack.put(8, 'H');
		redBlack.ergodic(root);
		
		root = redBlack.put(24, 'X');
		redBlack.ergodic(root);
		
		root = redBlack.put(13, 'M');
		redBlack.ergodic(root);
		
		root = redBlack.put(16, 'P');
		redBlack.ergodic(root);
		
		root = redBlack.put(12, 'L');
		redBlack.ergodic(root);
	}
}
