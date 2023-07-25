package org.study.storage;
import org.flywaydb.core.Flyway;


public class DatabaseInitService {
	public void initDB(){
		Flyway flyway = Flyway.configure()
				.dataSource(StorageConstants.CONNECTION_URL,"","")
				.load();

		flyway.migrate();
	}
}
