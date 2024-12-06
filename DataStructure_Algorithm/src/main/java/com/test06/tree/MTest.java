package com.test06.tree;

public class MTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer, Data> tree = new BinarySearchTree<>();
        tree.add(1, new Data(1, "kjs"));
        tree.add(21, new Data(21, "psa"));
        tree.add(13, new Data(13, "lsm"));
        tree.add(5, new Data(5, "kjk"));
        tree.add(7, new Data(7, "ssh"));
        tree.add(2, new Data(2, "csw"));
        tree.add(89, new Data(89, "kej"));

        tree.print();
        System.out.println("Search: " + tree.search(5));
        System.out.println("Remove " + tree.remove(5));
        tree.print();
    }
}

class Data{
    private Integer no;
    private String name;

    public Data(Integer no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    Integer keyCode() {
        return no;
    }
    public String toString() {
        return name;
    }
}
