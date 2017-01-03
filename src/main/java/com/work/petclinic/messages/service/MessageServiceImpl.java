
package com.work.petclinic.messages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.petclinic.messages.model.Message;
import com.work.petclinic.messages.repository.MessageRepository;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	@Transactional
	public Message createMessage(Message message) throws DataAccessException {
		return messageRepository.save(message);
	}

	@Override
	@Transactional(readOnly = true)
	public Message getMessage(Long id) throws DataAccessException {
		return messageRepository.findOne(id);
	}

	@Transactional
	public Message updateMessage(Message message) throws DataAccessException {
		return messageRepository.save(message); // TODO Update this

	}

	@Transactional(readOnly = true)
	public Page<Message> getAllMessages(Integer page, Integer size) {

		return messageRepository.findAll(new PageRequest(page, size));

	}

	@Override
	@Transactional
	public Long deleteMessage(Long id) throws DataAccessException {

		messageRepository.delete(id);

		return id;
	}

	@Override
	public Page<Message> getAllMessagesByUser(String userName, Integer page, Integer size) {
		
		return  messageRepository.findAllByUser(userName,new PageRequest(page, size));
	}
}
