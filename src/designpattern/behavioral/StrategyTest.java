package designpattern.behavioral;

/**
 * define a family of algorithms, encapsulate each one, and make them
 * interchangeable
 * strategy lets the algorithm vary independently from clients that use it
 *
 */
public final class StrategyTest {

        public static String test() {
                Strategic strategic = new Strategic();
                strategic.operate(StrategyA.getInstance());
                strategic.operate(StrategyB.getInstance());
                strategic.operate(StrategyA.getInstance());
                strategic.operate(StrategyA.getInstance());
                return strategic.toString() + " "
                        + strategic.getStats() + "\n";
        }

}

class Strategic {

        StringBuilder stats;

        public Strategic() {
                stats = new StringBuilder("Strategy\n");
        }

        public void operate(IStrategy strategy) {

                strategy.method(this);
        }

        public String getStats() {
                return stats.toString();
        }

}

interface IStrategy {
        void method(Strategic strategic);
        IStrategy getStrategy();
}

class StrategyA implements IStrategy {

        private static StrategyA instance = null;

        private StrategyA() {

        }

        public static StrategyA getInstance() {
                if (instance != null)
                        return instance;
                synchronized (StrategyA.class) {
                        if (instance == null)
                                instance = new StrategyA();
                }
                return instance;
        }

        @Override
        public void method(Strategic strategic) {
                strategic.stats.append(" <A> ");
        }

        @Override
        public IStrategy getStrategy() {
                return getInstance();
        }
}

class StrategyB implements IStrategy {

        private static StrategyB instance = null;

        private StrategyB() {

        }

        public static StrategyB getInstance() {
                if (instance != null)
                        return instance;
                synchronized (StrategyB.class) {
                        if (instance == null)
                                instance = new StrategyB();
                }
                return instance;
        }

        @Override
        public void method(Strategic strategic) {
                strategic.stats.append(" [B] ");
        }

        @Override
        public IStrategy getStrategy() {
                return getInstance();
        }
}
