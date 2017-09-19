package com.company;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(0, 1);
        list.add(3, 3);
        list.add(2);
        System.out.print("List elements: " );
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
        System.out.println("last index of '2':" + list.lastIndexOf(2));
        System.out.print("Remove '2' element" );
        list.remove(new Integer(2));
        System.out.print("List elements: " );
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        list2.add(0, 1);
        list2.add(3, 3);
        list2.addLast(2);
        System.out.print("List elements: " );
        for (int i = 0; i < list2.size(); i++)
            System.out.print(list2.get(i) + " ");
        System.out.println();
        System.out.println("last index of '2':" + list2.lastIndexOf(2));
        System.out.print("Remove '2' element" );
        list2.remove(new Integer(2));
        System.out.print("List elements: " );
        for (int i = 0; i < list2.size(); i++)
            System.out.print(list2.get(i) + " ");
        System.out.println();
    }

}
