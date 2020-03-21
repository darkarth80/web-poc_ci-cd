package com.softtek.consumewebservice;

import com.softtek.consumewebservice.dto.Walmart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumedController {

    @Value("${web.url}")
    private String url;
    
	@GetMapping("/")
	public String greeting(@RequestParam(name="obj", required=false) String obj, Model model) {
		Walmart wal = new RestTemplate().getForEntity(url, Walmart.class).getBody();
		model.addAttribute("obj", wal);
		return "consume";
	}

}
