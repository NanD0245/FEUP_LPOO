public class IcecreamMachine {
    Icecream icecream;

    IcecreamMachine(Icecream icecream) {this.icecream = icecream; }


    public IcecreamMachine executeCommand(Command command) {
        command.execute(icecream);
        return this;
    }

    public void undoLastCommand() { icecream.undoLast(); }
}
