package com.rab3tech.customer.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.admin.dao.repository.LocationRepository;
import com.rab3tech.customer.service.LocationService;
import com.rab3tech.dao.entity.Location;
import com.rab3tech.vo.LocationVO;
import com.rab3tech.vo.LoginVO;
import com.rab3tech.vo.UpdateLocationVO;


@Service
@Transactional
public class LocationServiceImpl implements LocationService{
	
  @Autowired
  private LocationRepository locationRepository;

	@Override
	public List<LocationVO> findLocations() {
				
		List<Location> locations = locationRepository.findAll();
		List<LocationVO> locationVOs = new ArrayList<LocationVO>();
		for(Location location : locations) {
			LocationVO locationVO = new LocationVO();
			BeanUtils.copyProperties(location, locationVO);
			LoginVO loginVO=new LoginVO();
			BeanUtils.copyProperties(location.getLogin(), loginVO);
			loginVO.setUsername(location.getLogin().getLoginid());
			System.out.println("=======================" + loginVO.getUsername());
			locationVO.setLogin(loginVO);
			
			locationVOs.add(locationVO);
		}
		// TODO Auto-generated method stub
		return locationVOs;
	}

	@Override
	public String addLocation(String alcode, String alocation) {
		String result = "";
		Optional<Location>  optional= locationRepository.findByLcode(alcode);
		if(optional.isPresent()) {
			result =  "Sorry, the location code exists already";	
		}else {
		
			Location location= new Location();
			location.setLcode(alcode);
			location.setLocation(alocation);
			location.setDoe(new Timestamp(new Date().getTime()));
			
			locationRepository.save(location);
			
			result =  "success";
		}
		
		return result;
				
		
	}
	
	@Override
	public String updateLocation(UpdateLocationVO updateLocationVO) {
		String result = "";
		Optional<Location>  optional= locationRepository.findById(updateLocationVO.getId());
		if(optional.isPresent()) {
			Location location=optional.get();
			location.setLcode(updateLocationVO.getLcode());
			location.setLocation(updateLocationVO.getLocation());
			location.setDom(new Timestamp(new Date().getTime()));
			
			result =  "success";
		}else {
			result =  "Sorry, the location cannot be updated";	
		}
		
		return result;
				
		
	}
	
	@Override
	public List<String> findLocation(){
		List<String> location = locationRepository.findLocation();
		return location;
	}

}
