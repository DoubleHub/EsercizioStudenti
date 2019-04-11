package life.or2;

public class BadIdentifierException extends RuntimeException {

    public BadIdentifierException() {
        super("Identifier must start with M!");
    }

}
