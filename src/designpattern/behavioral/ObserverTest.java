package designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * define a one-to-many dependency between objects so that one object changes
 * state, all its dependants are notified an updated automatically
 *
 * aka -> publish-subscribe
 *
 */
public final class ObserverTest {

        public static String test() {

                IPublisher publisher = new Publisher();
                ISubscriber subscriber = new Subscriber(publisher);

                publisher.subscribe(subscriber);
                publisher.subscribe(new Subscriber(publisher));
                publisher.subscribe(new Subscriber(publisher));
                publisher.subscribe(new Subscriber(publisher));
                publisher.subscribe(new Subscriber(publisher));

                publisher.publish(ObservableSubjects.A);
                publisher.publish(ObservableSubjects.B);
                publisher.unsubscribe(subscriber);
                publisher.publish(ObservableSubjects.A);
                publisher.subscribe(subscriber);
                publisher.publish(ObservableSubjects.C);
                publisher.publish(ObservableSubjects.B);


                return publisher.toString() + " "
                        + publisher.stats() + "\n";

        }
}

enum ObservableSubjects {
        A, B, C
}

interface IPublisher {
        void subscribe(ISubscriber subscriber);
        void unsubscribe(ISubscriber subscriber);
        void publish(final ObservableSubjects subject);
        void addStat(String stat);
        String stats();
}

class Publisher implements IPublisher {

        private List<ISubscriber> subscribers;
        private StringBuilder stringBuilder;

        public Publisher() {
                stringBuilder = new StringBuilder("Observer\n");
                subscribers = new ArrayList<>();
        }

        @Override
        public void subscribe(ISubscriber subscriber) {
                if (!subscribers.contains(subscriber))
                        subscribers.add(subscriber);
        }

        @Override
        public void unsubscribe(ISubscriber subscriber) {
                if (subscribers.contains(subscriber))
                        subscribers.remove(subscriber);
        }

        @Override
        public void publish(final ObservableSubjects subject) {
                subscribers.forEach((s) -> s.notify(subject));
                stringBuilder.append(subject.name());
                stringBuilder.append(" is published.\n");
        }

        @Override
        public void addStat(String stat) {
                stringBuilder.append(stat);
        }

        public String stats() {
                return stringBuilder.toString();
        }
}

interface ISubscriber {
        void notify(ObservableSubjects subject);
}

class Subscriber implements ISubscriber {
        private IPublisher publisher;

        public Subscriber(IPublisher publisher) {
                this.publisher = publisher;
        }

        @Override
        public void notify(ObservableSubjects subject) {
                publisher.addStat(toString() + "<" + subject.name() + " accepted.\n");
        }
}