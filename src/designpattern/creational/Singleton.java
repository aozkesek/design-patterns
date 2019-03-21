package designpattern.creational;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ensure a class has only one instance, and provide a global point of access
 * to it.
 */
public final class Singleton {

        public static Runnable lambdaSingleton(final int i, final StringBuffer stats) {
                return () ->
                        stats.append(i + "-) " +
                                LocalDateTime.now() + " " +
                                SingletonOfThing.getInstance() + " " +
                                LocalDateTime.now() + "\n");
        }

        public static String test() throws InterruptedException {
                StringBuffer stats = new StringBuffer("Singleton\n");

                ExecutorService executor = Executors.newFixedThreadPool(16);

                for (int i = 10; i < 100; i++)
                        executor.submit(lambdaSingleton(i, stats));

                Thread.sleep(500);

                executor.shutdown();

                return stats.toString();

        }


}

class SingletonOfThing {
        private static volatile SingletonOfThing instance = null;

        private SingletonOfThing() {

        }

        public static SingletonOfThing getInstance() {

                if (instance != null)
                        return instance;

                synchronized(Singleton.class) {

                        if (instance == null) {

                                instance = new SingletonOfThing();

                                try {
                                        Thread.sleep(150);
                                } catch (InterruptedException e) { }
                        }
                }

                return instance;
        }
}