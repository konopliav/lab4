import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for Phone validation.
 */
class PhoneTest {

    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Phone phone = new SmartPhone("Apple", "iPhone 15", 999.99, 2023,
                128, "iOS", true);

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setPrice(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new SmartPhone("", "Galaxy", -5, 1999,
                    -10, "Android", true);
        });
    }
}