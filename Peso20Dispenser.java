public class Peso20Dispenser implements DispenseChain {

    @Override
    public void setNextChain(DispenseChain nextChain) {
        // Last in chain, no next handler needed
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 20) {
            int num = cur.getAmount() / 20;
            int remainder = cur.getAmount() % 20;
            System.out.println("Dispensing " + num + " 20 bills");
            if (remainder != 0) {
                System.out.println("Remaining amount " + remainder + " cannot be dispensed.");
            }
        } else {
            System.out.println("Remaining amount " + cur.getAmount() + " cannot be dispensed.");
        }
    }
}