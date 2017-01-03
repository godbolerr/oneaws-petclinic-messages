package com.work.petclinic.messages.service;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;

import com.work.petclinic.messages.model.Message;

public interface MessageService {
	

	public Message createMessage(Message message) throws DataAccessException;
	
	public Message updateMessage(Message message) throws DataAccessException;
	
	public Long deleteMessage(Long id) throws DataAccessException;

	public Message getMessage(Long id) throws DataAccessException;
	
	public Page<Message> getAllMessages(Integer page, Integer size);
	
	public Page<Message> getAllMessagesByUser(String userName,Integer page, Integer size);

	
}
