import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for saving phone objects to database.
 */
public class DatabaseManager {

    private String url;
    private String user;
    private String password;

    /**
     * Creates database manager using properties file.
     *
     * @param configPath path to db.properties
     */
    public DatabaseManager(String configPath) {
        loadConfig(configPath);
    }

    private void loadConfig(String configPath) {
        java.util.Properties properties = new java.util.Properties();

        try {
            FileInputStream input = new FileInputStream(configPath);
            properties.load(input);
            input.close();

            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            System.out.println("Cannot read database config: " + e.getMessage());
        }
    }

    /**
     * Saves phone to database.
     *
     * @param phone phone object
     * @param quantity quantity of phones
     */
    public void insertPhone(Phone phone, int quantity) {
        String sql = "INSERT INTO phones " +
                "(type, brand, model, price, year, memory, operating_system, has_five_g, " +
                "has_torch, keyboard_type, has_cooling_system, battery_capacity, " +
                "has_esim, security_level, quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, getType(phone));
            statement.setString(2, phone.getBrand());
            statement.setString(3, phone.getModel());
            statement.setDouble(4, phone.getPrice());
            statement.setInt(5, phone.getYear());
            statement.setInt(6, phone.getMemory());

            if (phone instanceof SmartPhone) {
                SmartPhone smartPhone = (SmartPhone) phone;
                statement.setString(7, smartPhone.getOperatingSystem());
                statement.setBoolean(8, smartPhone.isHasFiveG());
            } else {
                statement.setString(7, null);
                statement.setObject(8, null);
            }

            if (phone instanceof KeypadPhone) {
                KeypadPhone keypadPhone = (KeypadPhone) phone;
                statement.setBoolean(9, keypadPhone.isHasTorch());
                statement.setString(10, keypadPhone.getKeyboardType());
            } else {
                statement.setObject(9, null);
                statement.setString(10, null);
            }

            if (phone instanceof GamingPhone) {
                GamingPhone gamingPhone = (GamingPhone) phone;
                statement.setBoolean(11, gamingPhone.isHasCoolingSystem());
                statement.setInt(12, gamingPhone.getBatteryCapacity());
            } else {
                statement.setObject(11, null);
                statement.setObject(12, null);
            }

            if (phone instanceof BusinessPhone) {
                BusinessPhone businessPhone = (BusinessPhone) phone;
                statement.setBoolean(13, businessPhone.isHasESim());
                statement.setString(14, businessPhone.getSecurityLevel());
            } else {
                statement.setObject(13, null);
                statement.setString(14, null);
            }

            statement.setInt(15, quantity);

            statement.executeUpdate();

            statement.close();
            connection.close();

            System.out.println("Phone saved to database.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private String getType(Phone phone) {
        if (phone instanceof GamingPhone) {
            return "GAMINGPHONE";
        }

        if (phone instanceof BusinessPhone) {
            return "BUSINESSPHONE";
        }

        if (phone instanceof SmartPhone) {
            return "SMARTPHONE";
        }

        if (phone instanceof KeypadPhone) {
            return "KEYPADPHONE";
        }

        return "PHONE";
    }
}