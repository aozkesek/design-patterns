package designpattern.structural;

/**
 * convert the interface of a class into another interface clients expect
 *
 * - you want to use an existing class, but its interface does not match the one
 *   you need
 * - you want to create a reusable class that cooperates with unrelated or
 *   unforeseen classes
 */
public final class AdapterTest {

        public static String test() {

                StringBuilder stats = new StringBuilder("Adapter\n");

                IAdapter adapter = new Adapter(new Adapted());
                adapter.expectedMethod(stats);

                return stats.toString();
        }
}

class Adapted {

        public void anExistingMethod() {

        }
}

interface IAdapter {
        void expectedMethod(StringBuilder stats);
}

class Adapter implements IAdapter {
        private Adapted adapted;

        public Adapter() {
                this(new Adapted());
        }

        public Adapter(Adapted adapted) {
                this.adapted = adapted;
        }

        @Override
        public void expectedMethod(StringBuilder stats) {
                stats.append(this + " expected(){exist()}\n");
                stats.append(adapted + "\n");
                adapted.anExistingMethod();
        }
}