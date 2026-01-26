import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int count = 0;

    public boolean insert(E element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            root = new Node<>(element);
        } else {
            if (!root.insert(element)) {
                return false;
            }
        }
        count++;
        return true;
    }

    public E search(E element) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return root.search(element);
    }

    public Iterator<E> iterator() {
        return new BSTIterator(root);
    }

    public E getMin() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return root.getMin();
    }

    public E getMax() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return root.getMax();
    }
    
    public int getDepth() {
        return root.getDepth(root);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public E[] toArray() {
        E[] arr = (E[]) new Comparable[count];
        root.toArray(arr, 0);
        return arr;
    } 

    public String toString() {
        return root.toString();
    }
    
    private static class Node<E extends Comparable<E>> {
        private E element;
        private Node<E> left;
        private Node<E> right;

        private Node(E element) {
            this.element = element;
        }

        private E getElement() {
            return element;
        }

        private Node<E> getLeft() {
            return left;
        }

        private Node<E> getRight() {
            return right;
        }

        private E getMin() {
            if (getLeft() == null) {
                return getElement();
            } else {
                return left.getMin();
            }
        }

        private E getMax() {
            if (getRight() == null) {
                return getElement();
            } else {
                return right.getMax();
            }
        }

        private int getDepth(Node node) {
            if (node == null) {
                return 0;
            } else if (getDepth(left) > getDepth(right)) {
                return 1 + getDepth(left);
            } else {
                return 1 + getDepth(right);
            }
        }
                
        private boolean insert(E element) {
            if (element.compareTo(this.element) < 0) {
                if (left == null) {
                    left = new Node<>(element);
                    return true;
                } else {
                    return left.insert(element);
                }
            } else if (element.compareTo(this.element) > 0) {
                if (right == null) {
                    right = new Node<>(element);
                    return true;
                } else {
                    return right.insert(element);
                }
            }
            return false;
        }

        private E search(E element) {
            if (element.compareTo(this.element) < 0) {
                if (left == null) {
                    return null;
                }
                return left.search(element);
            } else if (element.compareTo(this.element) > 0) {
                if (right == null) {
                    return null;
                }
                return right.search(element);
            }
            return element;
        }
        
        public int toArray(E[] arr, int idx) {
            if (left != null) {
                idx = left.toArray(arr, idx);
            }
            arr[idx++] = element;
            if (right != null) {
                idx = right.toArray(arr, idx);
            }
            return idx;
        }

        public String toString() {
            String treeString = "";
            
            if (left != null) {
                treeString += left.toString() + ", ";
            }
            treeString += element;
            if (right != null) {
                treeString += ", " + right.toString();
            }
            
            return treeString;
        }
        
        
    }

    class BSTIterator implements Iterator<E> {
        private Stack<Node<E>> stack;

        private BSTIterator(Node<E> root) {
            stack = new Stack<>();
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> node = stack.pop();
            return node.getElement();
        }
    }
}