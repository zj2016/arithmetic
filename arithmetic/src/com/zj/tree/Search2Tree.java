package com.zj.tree;
/**
 * 2叉搜索树
 * @author Administrator
 *
 */
public class Search2Tree<Key extends Comparable<Key>, Value> {

	//根节点
	private Node root;
	
	/*
	 * 节点
	 */
	private class Node{
	
		//节点key
		private Key key;
		
		//节点value
		private Value value;
		
		//节点左子节点
		private Node left;
		
		//节点右子节点
		private Node right;
		
		//节点子节点数目（包括本身）
		private int size;
		
		public Node(Key key, Value value, int size){
			this.key = key;
			this.value = value;
			this.size = size;
		}
	}
	
	/**
	 * 查询二叉树总节点数目
	 * @return
	 */
	public int size(){
		return size(root);
	}
	
	/**
	 * 查询指定节点的子节点数目
	 * @param root	节点
	 * @return
	 */
	public int size(Node x){
		if(root == null){
			return 0;
		}
		return root.size;
	}
	
	/**
	 * 查询二叉树是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size() == 0;
	}
	
	/**
	 * 看查询二叉树是否包含key指定的节点
	 * @param key
	 * @return
	 */
	public boolean contains(Key key){
		if(key == null){
			throw new IllegalArgumentException("key is null");
		}
		return get(key) == null;
	}

	/**
	 * 根据key，拿到指定节点的value
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		if(key == null){
			throw new NullPointerException("key is null");
		}
		return get(root, key);
	}
	
	/**
	 * 从指定节点的子树中获得key指定节点的value
	 * @param x		节点
	 * @param key	
	 * @return
	 */
	private Value get(Node x, Key key){
		if(x == null){
			return null;
		}
		int r = key.compareTo(x.key);
		if (r < 0){
			return get(x.left, key);
		} else if (r > 0){
			return get(x.right, key);
		} else {
			return x.value;
		}
	}
	
	public void put(Key key, Value value){
		if (key == null){
			throw new NullPointerException("key is null");
		}
		root = put(root, key, value);
	}
	
	public Node put(Node x, Key key, Value value){
		if (x == null){
			return new Node(key, value, 1);
		}
		int result = key.compareTo(x.key);
		if(result < 0){
			x.left =  put(x.left, key, value);
		} else if (result > 0){
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		return x;
	}
	
}
