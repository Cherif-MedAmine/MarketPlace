package tn.esprit.marketplace.exception;

public class GenericException extends RuntimeException {
    private String MESSAGE;

    public GenericException(String MESSAGE) {
        super(MESSAGE);

    }
}
