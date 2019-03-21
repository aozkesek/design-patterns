package designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * provide a way to access to elements of an aggregate object sequentially
 * without exposing its underlying representation
 *
 * aka -> cursor
 *
 *
 */
public final class IteratorTest {

        public static String test() {
                StringBuilder stats = new StringBuilder("Iterator\n");
                IteratableModelContainer container = new IteratableModelContainer();

                for (int i = 0; i < 10; i++)
                        container.add(new IteratableModel());

                stats.append(container.first() + "\n");
                while(container.hasNext()) {
                        stats.append(container.next() + "\n");
                }

                return stats.toString();
        }
}

interface IIterator {
        boolean hasNext();
        IteratableModel next();
        IteratableModel get();
        IteratableModel first();
}

class IteratableModel {

}

class IteratableModelContainer implements IIterator {
        private List<IteratableModel> models;
        private IteratableModel current;

        public IteratableModelContainer() {
                models = new ArrayList<>();
        }

        public void add(IteratableModel model) {
                if (model == null)
                        return;
                models.add(model);
                current = model;
        }

        @Override
        public boolean hasNext() {
                return models.size() > models.indexOf(current) + 1;
        }

        @Override
        public IteratableModel next() {
                int index = models.indexOf(current);
                if (models.size() > index + 1) {
                        current = models.get(index + 1);
                        return current;
                } else {
                        return null;
                }
        }

        @Override
        public IteratableModel get() {
                if (current == null)
                        if (models.size() > 0)
                                current = models.get(0);
                return current;
        }

        @Override
        public IteratableModel first() {
                if (models.size() > 0)
                        current = models.get(0);
                return current;
        }
}