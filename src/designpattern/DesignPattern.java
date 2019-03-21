package designpattern;

import designpattern.behavioral.*;
import designpattern.creational.*;
import designpattern.structural.*;

import static java.lang.System.out;

public class DesignPattern {

        public static void main(String[] args) throws InterruptedException {

                StringBuilder testStats = new StringBuilder();

                // creational
                testStats.append(Singleton.test());
                testStats.append("\n\n");

                testStats.append(BuilderTest.test());
                testStats.append("\n\n");

                testStats.append(PrototypeTest.test());
                testStats.append("\n\n");

                testStats.append(AbstractFactoryTest.test());
                testStats.append("\n\n");

                testStats.append(FactoryMethodTest.test());
                testStats.append("\n\n");

                // behavioral
                testStats.append(StateTest.doThing());
                testStats.append("\n\n");

                testStats.append(StrategyTest.test());
                testStats.append("\n\n");

                testStats.append(ObserverTest.test());
                testStats.append("\n\n");

                testStats.append(ChainOfResponsibilityTest.test());
                testStats.append("\n\n");

                testStats.append(CommandTest.test());
                testStats.append("\n\n");

                testStats.append(VisitorTest.test());
                testStats.append("\n\n");

                testStats.append(IteratorTest.test());
                testStats.append("\n\n");

                // structural
                testStats.append(FacadeTest.test());
                testStats.append("\n\n");

                testStats.append(DecoratorTest.test());
                testStats.append("\n\n");

                testStats.append(AdapterTest.test());
                testStats.append("\n\n");

                out.println(testStats.toString());
        }
}
