package com.rab3tech.admin.ui.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rab3tech.admin.service.CustomerLocationService;
import com.rab3tech.vo.LocationVO;



@Controller
@RequestMapping("/admin")
public class LocationController {
	 
	@Autowired
	private CustomerLocationService locationService;
	
	@GetMapping("/locations")
	public String showLocation(Model model) {
		List<LocationVO> locationVO = locationService.findLocation();
		model.addAttribute("locationVO", locationVO);
		return "admin/locations";		
	}
	
	@PostMapping("/locations")
	public String createLocation (@ModelAttribute LocationVO locationVO, Model model)throws IOException{
		locationService.update(locationVO);
		return "redirect:/admin/locations";
		
	}
}
