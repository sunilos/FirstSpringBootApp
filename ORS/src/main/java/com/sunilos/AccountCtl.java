package com.sunilos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Account")
public class AccountCtl {

	@Autowired
	private AccountService service = null;

	@GetMapping("get/{id}")
	public Map<String, Object> get(@PathVariable Long id) {

		Account a = service.get(id);

		Map<String, Object> response = new HashMap<String, Object>();

		if (a != null) {
			response.put("success", true);
			response.put("data", a);
		} else {
			response.put("success", false);
			response.put("message", "Account not found");
		}

		return response;
	}

	@GetMapping("delete/{id}")
	public Map<String, Object> delete(@PathVariable Long id) {

		Account a = service.get(id);

		Map<String, Object> response = new HashMap<String, Object>();

		if (a == null) {
			response.put("success", false);
			response.put("message", "Account not found");
		} else {
			service.delete(id);
			response.put("success", true);
			response.put("data", a);
		}
		return response;
	}

	@PostMapping("save")
	public Map<String, Object> save(@RequestBody Account a) {

		Long id = a.getId();

		if (id > 0) {
			service.update(a);
		} else {
			service.add(a);
		}

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("message", "Data is saved");
		response.put("data", a);
		return response;
	}

	@PostMapping("search")
	public Map<String, Object> search(@RequestBody Account a) {
		List<Account> list = service.search(a);

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("data", list);

		return response;
	}

}
