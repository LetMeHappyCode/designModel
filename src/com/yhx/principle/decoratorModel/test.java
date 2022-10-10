package com.yhx.principle.decoratorModel;

import java.time.LocalDateTime;

public class test {
    public static void main(String[] args) {


        System.out.println( LocalDateTime.now());
        System.out.println( LocalDateTime.now().minusDays(1));
        LocalDateTime time = LocalDateTime.now().minusDays(2);

        LocalDateTime before = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), 16, 0, 0);

        System.out.println(before);


        System.out.println(LocalDateTime.now().isAfter(before));


        if (!LocalDateTime.now().isAfter(before)) {
            System.out.println("chaoshi");;
        }

    }

}
