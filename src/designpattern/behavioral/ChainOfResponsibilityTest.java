package designpattern.behavioral;

/**
 * avoid coupling the sender of a request to its receiver by giving more than
 * one object a chance to handle the request chain the receiving objects and
 * pass the request along the chain until an object handles it
 *
 * - more than one object may handle a request, and the handler is not known a
 *   priori. the handler should be ascertained automatically
 * - you want to issue a request to one of several objects without specifying
 *   the receiver explicitly
 * - the set of objects that can handle  request should be specified dynamically
 *
 *
 */
public final class ChainOfResponsibilityTest {

        public static String test() {
                ChainModel cm = new ChainModel();

                IChain chain1 = new ChainA();
                IChain chain2 = new ChainB();
                IChain chain3 = new ChainA();

                chain1.setNext(chain2.setNext(chain3));

                chain1.execute(cm);
                return cm.stats();
        }

}


interface IChain {
        void execute(ChainModel model);
        IChain setNext(IChain chain);
}

class ChainModel {
        private StringBuilder stats;

        public ChainModel() {
                stats = new StringBuilder("ChainOfResponsibility\n");
        }

        protected void addStat(String stat) {
                stats.append(stat);
                stats.append("\n");
        }

        public String stats() {
                return stats.toString();
        }

}

abstract class AbstractChain implements IChain {

        private IChain nextChain;

        @Override
        public IChain setNext(IChain chain) {
                nextChain = chain;
                return this;
        }

        protected void executeNext(ChainModel chain) {
                if (nextChain != null)
                        nextChain.execute(chain);
        }
}

class ChainA extends AbstractChain {

        @Override
        public void execute(ChainModel model) {
                model.addStat(toString() + " executed.");
                //
                executeNext(model);
        }

}

class ChainB extends AbstractChain {

        @Override
        public void execute(ChainModel model) {
                model.addStat(toString() + " executed.");
                executeNext(model);
        }

}