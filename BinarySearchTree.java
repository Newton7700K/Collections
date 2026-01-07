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
        return true;
    }
    
    public E search(E element) {
        if (isEmpty()){
            throw new NullPointerException();
        } else if (element.equals(root.getElement())){
            return root.getElement();
        } else {
            root.search(element);
        }
    }
    
    public boolean isEmpty(){
        return count == 0;
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
        
        private boolean insert(E element){
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
    }
}