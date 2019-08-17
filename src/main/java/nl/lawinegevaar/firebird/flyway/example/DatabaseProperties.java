package nl.lawinegevaar.firebird.flyway.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.util.Objects.requireNonNull;

public class DatabaseProperties {

	private final Properties properties;

	private DatabaseProperties(Properties properties) {
		this.properties = requireNonNull(properties, "properties");
	}

    public String getUrl() {
        return properties.getProperty("db.url");
    }

    public String getUser() {
        return properties.getProperty("db.user");
    }

    public String getPassword() {
        return properties.getProperty("db.password");
    }

    public static DatabaseProperties loadDefault() throws IOException {
        try (InputStream inputStream = DatabaseProperties.class.getResourceAsStream("/database.properties")) {
        	return load(inputStream);
		}
    }

    public static DatabaseProperties load(InputStream inputStream) throws IOException {
		Properties properties = new Properties();
		properties.load(inputStream);
		return new DatabaseProperties(properties);
    }
}
