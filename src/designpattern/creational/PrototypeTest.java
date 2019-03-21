package designpattern.creational;

/**
 * specify the kind of objects to create using a prototypical instance, and
 * create new objects by copying this prototype
 *
 *
 */
public final class PrototypeTest {

        public static String test() {
                ModelPrototype model1 = new ModelPrototype(30, "custom");
                ModelPrototype model2 = model1.clone();
                model2.makeAdvanced();
                ModelPrototype model3 = model2.clone();
                model3.makeEconomic();

                return "Prototype\n"
                        + model1.toString() + "\n"
                        + model2.toString() + "\n"
                        + model3.toString() + "\n";

        }

}

class ModelPrototype implements Cloneable {

        private int id;
        private String name;

        public ModelPrototype() {
                id = 70;
                name = "average";
        }

        public ModelPrototype(int id, String name) {
                this.id = id;
                this.name = name;
        }

        public ModelPrototype makeAdvanced() {
                this.id = 100;
                this.name = "advanced";
                return this;
        }

        public ModelPrototype makeEconomic() {
                this.id = 50;
                this.name = "economic";
                return this;
        }

        @Override
        public ModelPrototype clone() {
                return new ModelPrototype(id, name);
        }

        @Override
        public String toString() {
                return super.toString() + "<" + id + ", " + name + ">";
        }
}