package fr.dawan.bibliotheque.entities.exceptions;

public class IdNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public IdNotFoundException() {
        super();
    }

    public IdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
