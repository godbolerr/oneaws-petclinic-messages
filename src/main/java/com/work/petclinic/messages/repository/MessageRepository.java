
package com.work.petclinic.messages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.work.petclinic.messages.model.Message;

public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {

	Page<Message> findAllByUser(String userName,Pageable request);

}
