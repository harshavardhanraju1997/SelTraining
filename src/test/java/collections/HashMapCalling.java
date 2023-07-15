package collections;

import java.util.HashMap;

public class HashMapCalling {
    public static void main(String[] args) throws InterruptedException {
        String k=HashMap1.users().get("Ram");
        String r=HashMap1.users().get("Sham");
        System.out.println("Ram : "+k);
        System.out.println("Sham : "+r);
        Thread.sleep(1);

    }
}
