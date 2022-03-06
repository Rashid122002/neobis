package kg.neobis.cardealership.Exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message, Long id) {
        super(message + id);
    }
    public EntityNotFoundException(String message, Integer id) {
        super(message + id);
    }
}
