package designpattern.structural;

/**
 * attach additional responsibilities to an object dynamically
 * provide a flexible alternative to subclassing or extending functionality
 *
 * aka -> wrapper
 *
 */
public final class DecoratorTest {

        public static String test() {
                StringBuilder stats = new StringBuilder("Decorator\n");
                stats.append(
                        new DecoratorB(
                                new DecoratorA(
                                        new DecoratedModel()))
                        .method());
                return stats.toString();

        }
}

class DecoratedModel {

        public String method() {
                return toString() + "\n";
        }
}

class DecoratorA extends DecoratedModel {

        private DecoratedModel model;

        public DecoratorA(DecoratedModel m) {
                model = m;
        }

        @Override
        public String method() {
                return toString() + " (<< \n" + model.method() + " >>)\n";
        }

}

class DecoratorB extends DecoratedModel {

        private DecoratedModel model;

        public DecoratorB(DecoratedModel m) {
                model = m;
        }

        @Override
        public String method() {
                return toString() + " [.. \n" + model.method() + " ..]\n";
        }

}
