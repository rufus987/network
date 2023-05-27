package error2.exceptions;

public class NotEnoughMoneyException extends Error {
    public NotEnoughMoneyException(long got, long expected) {
        System.out.printf("Денег нет! Got: %d, Exception: %d ", got, expected);
    }
}
