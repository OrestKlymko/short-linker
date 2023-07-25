package org.study;

import org.study.storage.DatabaseInitService;
import org.study.storage.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		new DatabaseInitService().initDB();

	}
}