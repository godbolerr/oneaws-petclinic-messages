/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.work.petclinic.messages.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.petclinic.messages.model.Message;
import com.work.petclinic.messages.model.User;
import com.work.petclinic.messages.model.UserProfile;
import com.work.petclinic.messages.repository.AuthorityRepository;
import com.work.petclinic.messages.repository.MessageRepository;
import com.work.petclinic.messages.repository.UserRepository;

/**
 * Mostly used as a facade for all controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 * @author Arnaldo Piccinelli
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;
	

	@Override
	@Transactional(readOnly = true)
	public Collection<Message> findMessages() throws DataAccessException {
		return null;
	}

	@Override
	@Transactional
	public Message saveMessage(Message message) throws DataAccessException {
		return null;// messageRepository.save(message);
	}

	@Override
	@Transactional(readOnly = true)
	public Message findMessage(Long id) throws DataAccessException {
		return null;//messageRepository.findById(id);
	}
	

	@Override
	@Transactional(readOnly = true)
	public User findUser(String useName) {
		return userRepository.findByUsername(useName);
	}

	@Override
	@Transactional(readOnly = true)
	public User createUser() {
		return new User();
	}

	@Override
	@Transactional(readOnly = true)
	public UserProfile createUserProfile(User user) {
		return new UserProfile(user);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		user.addAuthority(authorityRepository.findByAuthority("ROLE_USER"));
		return userRepository.save(user);
	}
	

}
