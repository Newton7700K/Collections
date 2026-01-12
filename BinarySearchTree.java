import java.util.*;
/**
 * Write a description of class BinarySearchTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearchTree<E extends Comparable<E>>
{
    private Node<E> root;
    private int count = 0;
    
    public boolean insert(E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        } else if (false){ //search(element) equals element
            return false;
        } else if (root == null) {
            root = new Node(element);
        } else {
            root.insert(element);
        }
        count++;
        return true;
    }
    
    public E search(E element) {
        if (isEmpty()){
            throw new NullPointerException();
        } else if (element.equals(root.getElement())){
            return root.getElement();
        } else {
            root.search(element);
            return null;
        }
    }
    
    public E getMin(){
        return root.getMin();
    }
    
    public E getMax(){
        return root.getMax();
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public int size() {
        return count;
    }
    
    public E[] toArray(){
        E[] arr = new E[count];
        root.toString(arr);
    }
    
    public String toString() {
        return root.toString();
    }
    
    private class Node<E extends Comparable<E>> {
        private E element;
        private Node<E> left;
        private Node<E> right;
        
        private Node(E element){
            this.element = element;
        }
        
        private E getElement(){
            return element;
        }
        
        private Node<E> getLeft(){
            return left;
        }
        
        private Node<E> getRight(){
            return right;
        }
        
        private E getMin(){
            if (getLeft() == null){
                return getElement();
            } else {
                return left.getMin();
            }
        }
        
        private E getMax(){
            if (getRight() == null){
                return getElement();
            } else {
                return right.getMax();
            }
        }
        
        private void insert(E element){
            if (element.compareTo(this.element) < 0){
                if (left == null) {
                    left = new Node(element);
                } else {
                    left.insert(element);
                }
            } else {
                if (right == null) {
                    right = new Node(element);
                } else {
                    right.insert(element);
                }
            }
        }
        
        private E search(E element){
            if (element.compareTo(this.element) < 0) {
                if(getLeft() == null){
                    return null;
                } else if (getLeft().getElement().equals(element)){
                    return getLeft().getElement();
                } else {
                    return getLeft().search(element);
                }
            } else {
                if(getRight() == null){
                    return null;
                } else if (getRight().getElement().equals(element)){
                    return getRight().getElement();
                } else {
                    return getRight().search(element);
                }
            }
        }
        
        public void toArray(E[] arr){
            if (left != null){
                left.toArray(arr);
            }
            
            if (right != null){
                treeString += ", " + right.toString();
            }
            return treeString;
        }
        
        public String toString() {
            String treeString = "";
            if (left != null){
                treeString += left.toString() + ", ";
            }
            treeString += element + "";
            if (right != null){
                treeString += ", " + right.toString();
            }
            return treeString;
        }
    }
}