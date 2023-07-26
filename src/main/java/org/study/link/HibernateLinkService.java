package org.study.link;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.study.storage.HibernateUtil;

import java.util.List;

public class HibernateLinkService implements LinkService {
	private Session openSession() {
		return HibernateUtil.getInstance().getSessionFactory().openSession();
	}

	@Override
	public Link getByShortLink(String shortLink) {
		try (Session session = openSession()) {
			return session.get(Link.class, shortLink);
		}
	}

	@Override
	public void save(Link link) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(link);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteByShortLink(String shortLink) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		session.remove(getByShortLink(shortLink));
		transaction.commit();
		session.close();
	}

	@Override
	public List<Link> listAllLink() {
		try (Session session = openSession()){
			return session.createQuery("from Link",Link.class).list();
		}
	}

	@Override
	public List<Link> search(String query) {
		String hql = "from Link where shortLink like '%"+ query +"%' or link like '%"+query+"%'";
		try (Session session = openSession()){
			return session.createQuery(hql,Link.class).list();
		}
	}
}
