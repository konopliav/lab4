import java.util.UUID;

/**
 * Interface for objects with UUID.
 */
public interface Identifiable {

    /**
     * Returns object UUID.
     *
     * @return UUID
     */
    UUID getUuid();
}