import java.util.Objects;

/**
 * Represents a phone manufacturer.
 */
public class Manufacturer {

    private String name;
    private String country;

    /**
     * Creates a manufacturer.
     *
     * @param name manufacturer name
     * @param country manufacturer country
     */
    public Manufacturer(String name, String country) {
        setName(name);
        setCountry(country);
    }

    /**
     * Copy constructor.
     *
     * @param other manufacturer to copy
     */
    public Manufacturer(Manufacturer other) {
        if (other == null) {
            throw new IllegalArgumentException("Manufacturer cannot be null.");
        }

        this.name = other.name;
        this.country = other.country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Manufacturer name cannot be empty.");
        }

        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty.");
        }

        this.country = country;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Manufacturer)) {
            return false;
        }

        Manufacturer manufacturer = (Manufacturer) obj;

        return Objects.equals(name, manufacturer.name)
                && Objects.equals(country, manufacturer.country);
    }
}