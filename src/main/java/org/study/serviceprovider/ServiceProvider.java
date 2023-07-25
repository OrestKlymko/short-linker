package org.study.serviceprovider;

import org.study.link.HibernateLinkService;
import org.study.link.LinkService;

import java.util.HashMap;
import java.util.Map;

public class ServiceProvider {
	private static Map<Class <? extends Object>,Object> SERVICES = new HashMap<>();

	static {
		SERVICES.put(LinkService.class, new HibernateLinkService());
	}


	@SuppressWarnings("unchecked")
	public  static <T> T get(Class<T> tClass){
		return (T) SERVICES.get(tClass);
	}
}
