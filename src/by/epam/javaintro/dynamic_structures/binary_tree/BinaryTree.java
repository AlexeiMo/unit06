package by.epam.javaintro.dynamic_structures.binary_tree;

public class BinaryTree<E extends Comparable<E>> {

    BinaryNode<E> root = null;

    public int size() {
        if (root == null) { return 0; }

        return root.size();
    }

    public void add (E k) {
        if (root == null) {
            root = new BinaryNode<E>(k);
            return;
        }

        root = root.add(root,k);
    }

    public boolean contains (E k) {
        return contains(root, k);
    }

    public boolean contains (BinaryNode<E> parent, E k) {
        if (parent == null) { return false; }

        int rc = k.compareTo(parent.key);
        if (rc == 0) {
            return true;
        } else if (rc < 0) {
            return contains(parent.left, k);
        } else {
            return contains(parent.right, k);
        }
    }


    public int height () {
        if (root == null) { return 0; }

        return height(root);
    }

    int height (BinaryNode<E> n) {
        if (n == null) { return 0; }

        return 1 + Math.max( height(n.left), height(n.right));
    }

}

class BinaryNode<E extends Comparable<E>> {
    final E key;
    BinaryNode<E> left;
    BinaryNode<E> right;

    BinaryNode(E k) {
        this.key= k;
    }

    int size() {
        return 1 + size(left) + size(right);
    }

    int size(BinaryNode<E> n) {
        if (n == null) { return 0; }
        return n.size();
    }

    void add (E k) {
        int rc = k.compareTo(key);
        if (rc <= 0) {
            left = add(left, k);
        } else {
            right = add(right, k);
        }
    }

    BinaryNode<E> add(BinaryNode<E> parent, E k) {
        if (parent == null) {
            return new BinaryNode<E>(k);
        }

        parent.add(k);
        return parent;
    }
}
