package org.study.link;

import java.util.List;

public interface LinkService {
	Link getByShortLink(String shortLink);
	void save(Link link);
	void deleteByShortLink(String shortLink);
	List<Link> listAllLink();
	List<Link> search(String query);
}
