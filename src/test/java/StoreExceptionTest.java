import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StoreExceptionTest {

    @Test
    void shouldThrowObjectNotFoundExceptionWhenDeletingNonExistingPhone() {
        Store store = new Store();

        Phone phone = new SmartPhone(
                "Apple",
                "iPhone 15",
                999.99,
                2023,
                128,
                "iOS",
                true
        );

        assertThrows(ObjectNotFoundException.class, () -> {
            store.delete(phone);
        });
    }

    @Test
    void shouldThrowInvalidFieldValueExceptionWhenPhoneHasInvalidPrice() {
        assertThrows(InvalidFieldValueException.class, () -> {
            new SmartPhone(
                    "Samsung",
                    "Galaxy S24",
                    -100,
                    2024,
                    256,
                    "Android",
                    true
            );
        });
    }
}