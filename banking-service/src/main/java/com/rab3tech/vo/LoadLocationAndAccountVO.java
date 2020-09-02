package com.rab3tech.vo;

import java.util.List;

import lombok.Data;


@Data
public class LoadLocationAndAccountVO {

	private List<LocationVO> locationNames;
	private List<AccountTypeVO> accountNames;
	
	
	
}
