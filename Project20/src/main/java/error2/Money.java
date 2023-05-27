package error2;

import error2.exceptions.NotEnoughMoneyException;

public class Money {
    long amount = 0;

    public Money(long amount) {
        this.amount = amount;
    }
    public long pay(long amount){
        if (this.amount>=amount){
            this.amount+=amount;
        } else {
            throw new NotEnoughMoneyException(this.amount, amount);
        }
        return this.amount;
    }
}
