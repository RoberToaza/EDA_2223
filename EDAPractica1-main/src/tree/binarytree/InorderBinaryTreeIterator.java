
package tree.binarytree;

import utils.Position;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author jvelez
 * @param <T>
 */
public class InorderBinaryTreeIterator<T> implements Iterator<Position<T>> {

    private Deque<Position<T>> nodeStack = new LinkedList<>();
    private final BinaryTree<T> tree;

    public InorderBinaryTreeIterator(BinaryTree <T> tree) {
        this(tree,tree.root());
    }


    public InorderBinaryTreeIterator(BinaryTree <T> tree, Position<T> node) {
        this.tree = tree;
        goToLastInLeft(node);
    }

    private void goToLastInLeft(Position<T> node) {
        nodeStack.addFirst(node);
        
        while (tree.hasLeft(node)) {
            node = tree.left(node);
            nodeStack.addFirst(node);
        }
    }
        
    @Override
    public boolean hasNext() {
        return (!nodeStack.isEmpty());
    }

    @Override
    public Position<T> next() {
        Position<T> aux = nodeStack.removeFirst();
        if (tree.hasRight(aux)) {
            goToLastInLeft(tree.right(aux));
        }
        
        return aux;
    }

   
}
