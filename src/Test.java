public class Test {
    static int add(int... ints) {
        int res = 0;
        for (int anInt : ints) {
            res += anInt;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(add(1, 2, 3, 4, 5));
        int[] a = {1, 10, 100, 1000};
        System.out.println(add(a));
    }
}
