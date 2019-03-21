package designpattern.behavioral;

/**
 * allow an object to alter its behaviour when its internal state changes
 * the object will appear to change its class
 *
 * state objects are often singleton
 *
 */
public final class StateTest {

        public static String doThing() {
                StatableThing thing = new StatableThing();
                thing.up();
                thing.down();
                thing.setState(States.STATEB);
                thing.up();
                thing.down();
                return thing.toString() + " "
                        + thing.getString() + "\n";
        }


}

interface IState {
        void thingUp(StatableThing thing);
        void thingDown(StatableThing thing);
}

enum States {
        STATEA, STATEB
}

class StatableThing {
        StringBuilder stringBuilder;
        IState state;

        public StatableThing() {
                state = StateA.getInstance();
                stringBuilder = new StringBuilder("State\n");
        }

        public String getString() {
                return stringBuilder.toString();
        }

        public void setState(States s) {
                switch(s) {
                        case STATEB:
                                state = StateB.getInstance();
                                break;

                        case STATEA:
                        default:
                                state = StateA.getInstance();
                }
        }

        public void up() {
                state.thingUp(this);
        }

        public void down() {
                state.thingDown(this);
        }

}

class StateA implements IState {

        private static StateA stateA = null;

        private StateA() { }

        public static StateA getInstance() {

                if (stateA != null)
                        return stateA;

                synchronized (StateA.class) {
                        if (stateA == null)
                                stateA = new StateA();
                }

                return stateA;
        }

        @Override
        public void thingUp(StatableThing thing) {
                thing.stringBuilder.append("|up");;
        }

        @Override
        public void thingDown(StatableThing thing) {
                thing.stringBuilder.append("|down");
        }

}

class StateB implements IState {

        private static StateB stateB = null;

        private StateB() { }

        public static StateB getInstance() {

                if (stateB != null)
                        return stateB;

                synchronized (StateB.class) {
                        if (stateB == null)
                                stateB = new StateB();
                }

                return stateB;
        }

        @Override
        public void thingUp(StatableThing thing) {
                thing.stringBuilder.append("|up...");
        }

        @Override
        public void thingDown(StatableThing thing) {
                thing.stringBuilder.append("|down...");
        }

}
