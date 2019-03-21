package designpattern.creational;


/**
 * Separate the construction of complex object from its representation, so
 * that the same construction process can create different representation
 *
 * - the algorithm of the creation a complex object should be independent of
 *   the parts that make up the object and how they are assembled
 * -
 */
public final class BuilderTest {

        public static String test() {
                BuildableModelBuilder builder = new BuildableModelBuilder();
                BuildableModel modelA = builder
                        .buildPartA(10)
                        .buildPartB('c')
                        .buildPartC("ahmet")
                        .build();
                BuildableModel modelB = builder
                        .buildPartA(20)
                        .buildPartB('m')
                        .buildPartC("merve")
                        .build();
                return "Builder\n"
                        + modelA.toString() + "\n"
                        + modelB.toString() + "\n";

        }

}

class BuildableModelBuilder {
        private int partA;
        private char partB;
        private String partC;

        public BuildableModelBuilder buildPartA(int partA) {
                this.partA = partA;
                return this;
        }

        public BuildableModelBuilder buildPartB(char partB) {
                this.partB = partB;
                return this;
        }

        public BuildableModelBuilder buildPartC(String partC) {
                this.partC = partC;
                return this;
        }

        public BuildableModel build() {
                return new BuildableModel(this);
        }

        public int getPartA() {
                return partA;
        }

        public char getPartB() {
                return partB;
        }

        public String getPartC() {
                return partC;
        }
}

class BuildableModel {
        private int partA;
        private char partB;
        private String partC;

        public BuildableModel(int partA, char partB, String partC) {
                this.partA = partA;
                this.partB = partB;
                this.partC = partC;
        }

        public BuildableModel(BuildableModelBuilder builder) {
                this(builder.getPartA(),
                        builder.getPartB(),
                        builder.getPartC());
        }

        @Override
        public String toString() {
                return super.toString() + " " +
                        partA + ", " +
                        partB + ", " +
                        partC;
        }

}


