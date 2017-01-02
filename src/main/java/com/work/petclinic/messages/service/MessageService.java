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

import org.springframework.dao.DataAccessException;

import com.work.petclinic.messages.model.Message;
import com.work.petclinic.messages.model.User;
import com.work.petclinic.messages.model.UserProfile;

/**
 * Mostly used as a facade for all controllers.
 *
 * @author Michael Isvy
 * @author Arnaldo Piccinelli
 */
public interface MessageService {
	// Message
	public Collection<Message> findMessages() throws DataAccessException;

	public Message saveMessage(Message message) throws DataAccessException;

	public Message findMessage(Long id) throws DataAccessException;
	
	// User
	public User createUser();

	public User saveUser(User user) throws DataAccessException;

	public User findUser(String username) throws DataAccessException;

	public UserProfile createUserProfile(User user);



}
