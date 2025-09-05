package home;

public class Example {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.add(13);
        list1.add(11);
        list1.add(10);
        list1.add(17);


        list.add(12);
        list.addAll(list1);
//        list.add(13);
//        list.add(14);
//        list.remove(0);
//        list.remove(1);
//        list.add(15);
        for (int i = 0; i <list.getSize(); i++) {
            System.out.println(list.getItem(i));
        }
        System.out.println(list);
    }
}
