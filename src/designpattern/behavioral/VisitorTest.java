package designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * represent an operation to be performed on the elements of an object structure
 * it lets you define a new operation without changing the classes of the
 * elements
 *
 * - an object structure contains many classes of object with differing
 *   interfaces, and you want to perform operations on the objects that depend
 *   on heir concrete classes
 * - many distinct and unrelated operations need to be performed on objects in
 *   an object structure, and you want to avoid polluting their classes with
 *   these operations
 * - the objects structure is rarely changed but the operations over the
 *   structure are often changed
 *
 */
public final class VisitorTest {

        public static String test() {

                final ModelVisitor visitor = new ModelVisitor();

                List<IVisitModel> modelList = new ArrayList<>();
                modelList.add(new VisitModelA());
                modelList.add(new VisitModelA());
                modelList.add(new VisitModelB());
                modelList.add(new VisitModelA());
                modelList.add(new VisitModelB());
                modelList.add(new VisitModelB());
                modelList.add(new VisitModelB());
                modelList.add(new VisitModelA());

                modelList.forEach((vm) -> vm.accept(visitor));

                return visitor.stats();

        }
}

interface IVisitor {
        void visit(VisitModelA visitA);
        void visit(VisitModelB visitB);

}

class ModelVisitor implements IVisitor {

        private StringBuilder stats;

        public ModelVisitor() {
                stats = new StringBuilder("Visitor\n");
        }

        @Override
        public void visit(VisitModelA visitA) {
                stats.append(visitA.toString() + " accepted.\n");
        }

        @Override
        public void visit(VisitModelB visitB) {
                stats.append(visitB.toString() + " accepted.\n");
        }

        public String stats() {
                return toString() + " "
                        + stats.toString();
        }
}

interface IVisitModel {
        void accept(IVisitor visitor);
}

class VisitModelA implements IVisitModel {

        @Override
        public void accept(IVisitor visitor) {
                visitor.visit(this);
        }
}

class VisitModelB implements IVisitModel {

        @Override
        public void accept(IVisitor visitor) {
                visitor.visit(this);
        }
}