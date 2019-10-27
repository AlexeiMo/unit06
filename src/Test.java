import by.epam.javaintro.dynamic_structures.binary_tree.BinaryTree;
import by.epam.javaintro.dynamic_structures.array_list.ArrayList;
import by.epam.javaintro.dynamic_structures.binary_tree.BinaryTreeView;

import java.util.Collections;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        byte choice = in.nextByte();
        switch(choice) {
            case 1: {
                ArrayList<String> strings = new ArrayList<>();
                strings.add("string1");
                strings.add(1,"string2");
                System.out.println(strings.toString());
                String a = strings.removeLast();
                System.out.println(a);
                strings.add("string3");
                strings.add("string4");
                System.out.println(strings.toString());
                strings.clear();
                System.out.println(strings.toString());
                break;
            }
            case 2: {
                int numToAdd = 100;
                ArrayList<Integer> vals = new ArrayList<Integer>();
                for (int i = 1; i < numToAdd; i += 2) {
                    vals.add(i);
                }
                Collections.shuffle(vals);
                Integer[] add = vals.toArray(new Integer[]{});

                BinaryTree<Integer> bst = new BinaryTree<Integer>();

                for (int i : add) {
                    bst.add(i);
                }
                BinaryTreeView view = BinaryTreeView.view;
                view.printTree(bst);
            }
        }
    }
}
