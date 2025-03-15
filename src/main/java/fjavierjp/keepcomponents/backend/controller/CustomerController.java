package fjavierjp.keepcomponents.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController
{
	@GetMapping("/customers")
	public String index()
	{
		return "views/customers/index";
	}
}
