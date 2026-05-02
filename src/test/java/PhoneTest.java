import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for Phone validation.
 */
class PhoneTest {

    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Phone phone = new Phone("Apple", "iPhone 15", 999.99, 2023,
                128, PhoneType.SMARTPHONE);

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setPrice(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("", "Galaxy", -5, 1999,
                    -10, PhoneType.SMARTPHONE);
        });
    }
}