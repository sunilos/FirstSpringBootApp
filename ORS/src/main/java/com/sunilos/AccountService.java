package com.sunilos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO dao = null;

	@Transactional
	public Account get(long id) {
		return dao.get(id);
	}

	@Transactional
	public long add(Account a) {
		return dao.add(a);
	}

	@Transactional
	public long update(Account a) {
		return dao.update(a);
	}

	@Transactional
	public Account delete(long id) {
		return dao.delete(id);
	}

	@Transactional
	public List<Account> search(Account a) {
		return dao.search(a);
	}

}
