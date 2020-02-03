package com.sunilos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "College")
public class CollegeCtl {

	private static HashMap<Long, College> data = new HashMap<Long, College>();

	static {
		data.put(1L, new College(1, "IIT", "Mumbai"));
		data.put(2L, new College(2, "IIM", "Delhi"));
		data.put(3L, new College(3, "AIMS", "Delhi"));
	}

	@GetMapping("get/{id}")
	public Map<String, Object> get(@PathVariable Long id) {

		College c = data.get(id);

		Map<String, Object> response = new HashMap<String, Object>();

		if (c != null) {
			response.put("success", true);
			response.put("data", c);
		} else {
			response.put("success", false);
			response.put("message", "College not found");
		}

		return response;
	}

	@GetMapping("delete/{id}")
	public Map<String, Object> delete(@PathVariable Long id) {

		College c = data.get(id);

		Map<String, Object> response = new HashMap<String, Object>();

		if (c == null) {
			response.put("success", false);
			response.put("message", "College not found");
		} else {
			data.remove(id);
			response.put("success", true);
			response.put("data", c);
		}
		return response;
	}

	@PostMapping("save")
	public Map<String, Object> save(@RequestBody College c) {

		Long id = c.getId();

		Map<String, Object> response = new HashMap<String, Object>();

		if (id > 0) {
			data.remove(id);
			data.put(id, c);
		} else {
			c.setId(data.size() + 1);
			data.put(id, c);
		}
		response.put("success", true);
		response.put("message", "Data is saved");
		response.put("data", c);
		return response;
	}

	@PostMapping("search")
	public Map<String, Object> search(@RequestBody College c) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("data", data);
		return response;
	}

}
