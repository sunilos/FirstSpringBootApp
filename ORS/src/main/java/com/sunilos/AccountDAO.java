package com.sunilos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	public Account get(long id) {

		// Session session = entityManager.unwrap(Session.class);
		// SessionFactory sessionFactory =
		// entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);

		Session session = entityManager.unwrap(Session.class);
		Account a = session.get(Account.class, id);
		return a;
	}

	public Account delete(long id) {
		Session session = entityManager.unwrap(Session.class);
		Account a = session.get(Account.class, id);
		session.delete(a);
		return a;
	}

	public long add(Account a) {
		Session session = entityManager.unwrap(Session.class);
		session.save(a);
		return a.getId();
	}

	public long update(Account a) {
		Session session = entityManager.unwrap(Session.class);
		session.update(a);
		return a.getId();
	}

	public List<Account> search(Account a) {
		Session session = entityManager.unwrap(Session.class);
		Criteria c = session.createCriteria(Account.class);
		if (a.getName() != null) {
			c.add(Expression.like("name", a.getName()));
		}
		if (a.getAccountNo() != null) {
			c.add(Expression.eq("accountNo", a.getAccountNo()));
		}
		if (a.getBalance() > 0) {
			c.add(Expression.ge("balance", a.getBalance()));
		}

		List<Account> list = c.list();

		return list;
	}
}
