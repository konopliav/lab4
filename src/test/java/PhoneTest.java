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
        Phone phone = new Phone("Apple", "iPhone 15", 999.99, 2023, 128);

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
            new Phone("", "Galaxy", -5, 1999, -10);
        });
    }

    /**
     * Checks exception when invalid memory is set.
     */
    @Test
    void shouldThrowExceptionWhenInvalidMemoryInSetter() {
        Phone phone = new Phone("Samsung", "Galaxy S24", 899.99, 2024, 256);

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setMemory(0);
        });
    }
}