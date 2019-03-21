package designpattern.creational;

/**
 * provide an interface for creating families of related or dependant objects
 * without specifying their concrete classes
 * - a system should be independent of how its products are created, composed,
 *   and represented
 * - a system should be configured with one multiple families of products
 * - a family of related product objects is designed to be used together, and
 *   you need to enforce this constraint
 * - you want to provide a class library of products, and you want to reveal
 *   just their interfaces, not their implementations
 *
 */
public final class AbstractFactoryTest {

        public static String test() {
                StringBuilder stats = new StringBuilder("AbstractFactory\n");

                IAbstractFactory abstractFactory = new AbstractFactory();
                stats.append(abstractFactory + "\n");

                FactoryA factoryA = (FactoryA) abstractFactory
                        .createFactory(Factories.FACTORA);
                stats.append(factoryA + "\n");
                FactorA factorA = factoryA.createFactorA();
                stats.append(factorA + "\n");

                FactoryB factoryB = (FactoryB) abstractFactory
                        .createFactory(Factories.FACTORB);
                stats.append(factoryB + "\n");
                FactorB factorB = factoryB.createFactorB();
                stats.append(factorB + "\n");

                return stats.toString();

        }

}

enum Factories {
        FACTORA, FACTORB, FACTORC, FACTORD
}

interface IAbstractFactory {
        IAbstractFactory createFactory(Factories type);
}

class AbstractFactory implements IAbstractFactory {

        @Override
        public IAbstractFactory createFactory(Factories type) {
                switch (type) {
                        case FACTORB:
                                return new FactoryB();

                        case FACTORA:
                        default:
                                return new FactoryA();

                }
        }
}

class FactoryA extends AbstractFactory {

        public FactorA createFactorA() {
                return new FactorA();
        }

}

class FactoryB extends AbstractFactory {

        public FactorB createFactorB() {
                return new FactorB();
        }
}

class FactorA {

}

class FactorB {

}
