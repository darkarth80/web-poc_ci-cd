package com.softtek.consumewebservice;

import javax.servlet.http.HttpServletRequest;

import com.softtek.consumewebservice.dto.Walmart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumedController {

    @Value("${web.protocol}")
    private String protocol;

    @Value("${web.hostname}")
    private String hostname;

    @Value("${web.port}")
    private String port;

    @Value("${web.context}")
    private String context;
    
	@GetMapping("/")
	public String greeting(@RequestParam(name="obj", required=false) String obj, Model model, HttpServletRequest request) {
        port = (!port.equals("") ? port : String.valueOf(request.getLocalPort()));
        StringBuilder url = new StringBuilder()
        .append(protocol).append(hostname).append(":").append(port).append("/").append(context).append("/");
        System.out.println("url: "+url.toString());
		Walmart wal = new RestTemplate().getForEntity(url.toString(), Walmart.class).getBody();
		model.addAttribute("obj", wal);
		return "consume";
	}

}
