package net.appfold.javase8forthereallyimpatient.ch01;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;

public class Ch01Ex01 {

    public static void main(String[] args) {

        final long currentThreadId = currentThread().getId();
        final Set<Long> usedThreadIds = new CopyOnWriteArraySet<>();

        final Integer[] array = {2, 3, 1};
        out.println(Arrays.toString(array));

        Arrays.sort(array, (i1, i2) -> {
            usedThreadIds.add(currentThread().getId());
            return -i1.compareTo(i2);
        });
        out.println(Arrays.toString(array));

        out.println("Main thread id        : " + currentThreadId);
        out.println("Other used threads ids: " + usedThreadIds);
    }
}
