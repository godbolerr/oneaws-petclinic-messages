/**
 * 
 */
package com.work.petclinic.messages.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.work.petclinic.messages.model.Message;
import com.work.petclinic.messages.service.MessageService;

@RestController
@RequestMapping(value = "/msg")
public class MessageRestController {

	@Autowired
	MessageService msgService;

	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	public Message createMessage(@RequestBody Message msg) {
		return msgService.saveMessage(msg);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public Message getMessage(@PathVariable("id") Long id) {

		return msgService.findMessage(id);

	}

}
