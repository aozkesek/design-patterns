package designpattern.creational;

/**
 * define an interface for creating an object, but let subclass decide which
 * class to instantiate
 *
 * - a class can not anticipate the class of objects it must be create
 * - a class wants its subclasses to specify the objects it creates
 * - classes delegate responsibility to one of several helper sub classes, and
 *   you want to localize the knowledge of which helper subclass is the delegate
 *
 */
public final class FactoryMethodTest {

        public static String test() {
                StringBuilder stats = new StringBuilder("Factory\n");

                FactorC factorC =
                        (FactorC) Factory.createFactor(Factories.FACTORC);
                stats.append(factorC + "\n");

                FactorD factorD =
                        (FactorD) Factory.createFactor(Factories.FACTORD);
                stats.append(factorD + "\n");

                return stats.toString();
        }

}

class Factory {

        public static IFactor createFactor(Factories type) {
                switch (type) {
                        case FACTORD:
                                return new FactorD();

                        case FACTORC:
                        default:
                                return new FactorC();
                }
        }

}

interface IFactor {

}

class FactorC implements IFactor {

}

class FactorD implements IFactor {

}
