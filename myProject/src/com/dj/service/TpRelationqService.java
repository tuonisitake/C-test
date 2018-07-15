package com.dj.service;

import org.springframework.transaction.annotation.Transactional;

import com.dj.dao.TpRelationqDao;

@Transactional
public class TpRelationqService {
	private TpRelationqDao tpRelationqDao;

	public void setTpRelationqDao(TpRelationqDao tpRelationqDao) {
		this.tpRelationqDao = tpRelationqDao;
	}
	

}
