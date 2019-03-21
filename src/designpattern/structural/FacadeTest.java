package designpattern.structural;

/**
 * provide a unified interface to a set of interfaces in a subsystem.
 * define a higher-level interface that makes the subsystem easier to use
 *
 *
 */
public final class FacadeTest {

        public static String test() {
                ISysFacade sysFacade = new Sys(new SubSysOne(), new SubSysTwo());
                sysFacade.operation();
                return sysFacade.stats();
        }
}

interface ISysFacade {
        void operation();
        String stats();
}

interface ISubSysOne {
        void anOperation();
        void anotherOperation();
        String stats();
}

interface ISubSysTwo {
        void otherOperation();
        String stats();
}

class SubSysOne implements ISubSysOne {

        private StringBuilder stats;

        public SubSysOne() {
                stats = new StringBuilder();
        }

        @Override
        public void anOperation() {
                stats.append(toString() + " + oneOperation,\n");
        }

        @Override
        public void anotherOperation() {
                stats.append(toString() + " + twoOperation,\n");
        }

        @Override
        public String stats() {
                return stats.toString();
        }
}

class SubSysTwo implements ISubSysTwo {

        private StringBuilder stats;

        public SubSysTwo() {
                stats = new StringBuilder();
        }

        @Override
        public void otherOperation() {
                stats.append(toString() + " + twoOperation,\n");
        }

        @Override
        public String stats() {
                return stats.toString();
        }
}

class Sys implements ISysFacade {

        private ISubSysTwo subTwo;
        private ISubSysOne subOne;

        public Sys(ISubSysOne one, ISubSysTwo two) {
                subOne = one;
                subTwo = two;
        }

        @Override
        public void operation() {
                subOne.anOperation();
                subTwo.otherOperation();
                subOne.anotherOperation();
        }

        @Override
        public String stats() {
                return toString() + "\n" +
                        subOne.stats() + "\n" + subTwo.stats();
        }
}