package com.rab3tech.admin.service;

import java.util.List;

import com.rab3tech.vo.LocationVO;

public interface CustomerLocationService {
	public List<LocationVO> findLocation();
	void update(LocationVO locationVO);

	
}
