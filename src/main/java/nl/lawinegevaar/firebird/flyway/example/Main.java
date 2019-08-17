package nl.lawinegevaar.firebird.flyway.example;

import org.flywaydb.core.Flyway;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		DatabaseProperties databaseProperties = DatabaseProperties.loadDefault();
		migrateDatabase(databaseProperties);
	}

	private static void migrateDatabase(DatabaseProperties databaseProperties) {
		Flyway flyway = Flyway.configure()
				.dataSource(
						databaseProperties.getUrl(),
						databaseProperties.getUser(),
						databaseProperties.getPassword())
				.load();
		// Clean is destructive, it will remove existing objects from the database
		//flyway.clean();
		flyway.migrate();
	}
}
