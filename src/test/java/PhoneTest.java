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
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Manufacturer manufacturer = new Manufacturer("Apple", "USA");
        Phone phone = new Phone("Apple", "iPhone 15", 999.99, 2023,
                128, PhoneType.SMARTPHONE, manufacturer);

        assertThrows(IllegalArgumentException.class, () -> {
            phone.setPrice(-10);
        });
    }

    /**
     * Checks exception when constructor data is invalid.
     */
    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        Manufacturer manufacturer = new Manufacturer("Samsung", "South Korea");

        assertThrows(IllegalArgumentException.class, () -> {
            new Phone("", "Galaxy", -5, 1999,
                    -10, PhoneType.SMARTPHONE, manufacturer);
        });
    }
}