import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for Phone validation.
 */
class PhoneTest {

    /**
     * Checks exception when invalid price is set.
     */
    @Test
    void shouldThrowExceptionWhenInvalidPriceInSetter() {
        Phone phone = new Phone("Apple", "iPhone 15", 999.99, 2023);

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setPrice(-10);
        });
    }

    /**
     * Checks exception when constructor data is invalid.
     */
    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("", "Galaxy", -5, 1999);
        });
    }
}