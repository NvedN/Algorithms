package leetcode;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

class Child extends Super{
    Integer aB = 0;

    public static void main(String[] args) {
        int a =  getA();

        Predicate<Object> p = Predicate.isEqual(2).and(Predicate.isEqual(null));
        System.out.println(p.test(2));

    }


    public void test(String... a){
        Optional<String> test = "".describeConstable();
       String b = String.valueOf(Optional.of(test));
        for (String e : a){

        }
    }

}
