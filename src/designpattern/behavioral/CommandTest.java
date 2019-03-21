package designpattern.behavioral;

/**
 * encapsulate a request as an object thereby letting you parameterize clients
 * with different requests, queue or log requests, and support undoable
 * operations
 *
 *
 *
 */
public final class CommandTest {


        public static String test() {

                final CommandModel model = new CommandModel();

                invoke((c) -> c.execute(), new OpenCommand(model));
                invoke((c) -> c.execute(), new CloseCommand(model));

                return model.stats();

        }

        public static void invoke(ICommandInvoker invoker, ICommand command) {
                invoker.invoke(command);
        }

}

interface ICommandInvoker {
        void invoke(ICommand command);
}

class CommandModel {

        private StringBuilder stats;

        public CommandModel() {
                stats = new StringBuilder("Command\n");
        }

        public void open() {
                stats.append(toString() + " opened.\n");
        }

        public void close() {
                stats.append(toString() + " closed.\n");
        }

        public String stats() {
                return stats.toString();
        }
}

interface ICommand {
        void execute();
}

class OpenCommand implements ICommand {

        private CommandModel model;

        public OpenCommand(CommandModel model) {
                this.model = model;
        }

        @Override
        public void execute() {
                model.open();
        }
}

class CloseCommand implements ICommand {

        private CommandModel model;

        public CloseCommand(CommandModel model) {
                this.model = model;
        }

        @Override
        public void execute() {
                model.close();
        }
}