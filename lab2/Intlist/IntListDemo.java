public class IntListDemo {
    public static void main(String[] args) {
        IntList l = new IntList(3, null);
        l = new IntList(2, l);
        l = new IntList(1, l);

        System.out.println(l.first + " " + l.rest.first + " " + l.rest.rest.first);

        IntList.dSquareList(l);
        System.out.println(l.first + " " + l.rest.first + " " + l.rest.rest.first);
    }
}
