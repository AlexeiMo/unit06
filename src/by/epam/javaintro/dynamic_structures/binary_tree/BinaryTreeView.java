package by.epam.javaintro.dynamic_structures.binary_tree;

public class BinaryTreeView {
    public static final BinaryTreeView view = new BinaryTreeView();

    private BinaryTreeView() {}

    public void printTree(BinaryTree tree) {
        if (tree.root.right != null) {
            printTree(tree.root.right, true, "");
        }
        printNodeValue(tree.root);
        if (tree.root.left != null) {
            printTree(tree.root.left, false, "");
        }
    }
    private void printNodeValue(BinaryNode node) {
        if (node.key == null) {
            System.out.print("<null>");
        } else {
            System.out.print(node.key.toString());
        }
        System.out.print("\n");;
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(BinaryNode node, boolean isRight, String indent) {
        if (node.right != null) {
            printTree(node.right, true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");;
        } else {
            System.out.print(" \\");;
        }
        System.out.print("----- ");;
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, indent + (isRight ? " |      " : "        "));
        }
    }
}
