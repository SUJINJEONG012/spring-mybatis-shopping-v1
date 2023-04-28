package com.mybatis.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.AttachMapper;
import com.mybatis.shopping.model.AttachImageVo;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class AttachServiceImpl implements AttachService{

	@Autowired
	private AttachMapper attachMapper;
	
	@Override
	public List<AttachImageVo> getAttachList(int bookId) {
		log.info("getAttchList.........");
		return attachMapper.getAttachList(bookId);
	}

	
}
