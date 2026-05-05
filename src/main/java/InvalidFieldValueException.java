/**
 * Exception for invalid field values.
 */
public class InvalidFieldValueException extends IllegalArgumentException {

    public InvalidFieldValueException(String message) {
        super(message);
    }
}