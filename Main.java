package ALES;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Arvore arv1 = new Arvore();
        String res;
        ArrayList<String> resVet;

        String n1 = new String("A");
        String n2 = new String("B");
        String n3 = new String("C");
        String n4 = new String("D");
        String n5 = new String("E");
        String n6 = new String("F");
        String n7 = new String("G");
        String n8 = new String("H");
        String n9 = new String("I");
        String n10 = new String("J");
        String n11 = new String("K");


        arv1.add(n1, null);
        arv1.add(n2, n1);
        arv1.add(n3, n1);
        arv1.add(n4, n2);
        arv1.add(n5, n2);
        arv1.add(n6, n3);
        arv1.add(n7, n3);
        arv1.add(n8, n4);
        arv1.add(n9, n7);
        arv1.add(n10, n7);
        arv1.add(n11, n7);

        System.out.println("Traversal Pre:");
        System.out.println(arv1.traversalPre().toString());
        System.out.println("Traversal Pos:");
        System.out.println(arv1.traversalPos().toString());

    }
}

