package com.work.petclinic.messages.api.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.work.petclinic.messages.exception.DataFormatException;
import com.work.petclinic.messages.model.Message;
import com.work.petclinic.messages.service.MessageService;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/rest/v1/messages")
@Api(value = "messages", description = "Message API")
public class MessageController extends AbstractRestHandler {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a message resource.", notes = "Returns the URL of the new resource in the Location header.")
    public
    @ResponseBody
    Message createMessage(@RequestBody Message message,
                                 HttpServletRequest request, HttpServletResponse response) {
    	
        Message createdMessage = this.messageService.createMessage(message);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdMessage.getId()).toString());
        return createdMessage;
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all hotels.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Message> getAllMessages(@ApiParam(value = "The page number (zero-based)", required = true)
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @ApiParam(value = "Tha page size", required = true)
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.messageService.getAllMessages(page, size);
    }
    
    @RequestMapping(value = "/user/{userName}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all hotels.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Message> getAllMessagesForUser(
						    		@ApiParam(value = "User for which messages should be retrieved.", required = true)
						            @PathVariable("userName") String userName,    		
    								  @ApiParam(value = "The page number (zero-based)", required = true)
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @ApiParam(value = "Tha page size", required = true)
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
        return this.messageService.getAllMessagesByUser(userName,page, size);
    }
    
   
    

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single message.", notes = "You have to provide a valid message ID.")
    public
    @ResponseBody
    Message getMessage(@ApiParam(value = "The ID of the message.", required = true)
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
       Message message = this.messageService.getMessage(id);
    	
        return message;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a message resource.", notes = "You have to provide a valid message ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateMessage(@ApiParam(value = "The ID of the existing message resource.", required = true)
                                 @PathVariable("id") Long id, @RequestBody Message message,
                                 HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.messageService.getMessage(id));
        if (id != message.getId()) throw new DataFormatException("ID doesn't match!");
        this.messageService.updateMessage(message);
    }

    //todo: @ApiImplicitParams, @ApiResponses
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a message resource.", notes = "You have to provide a valid message ID in the URL. Once deleted the resource can not be recovered.")
    public void deleteMessage(@ApiParam(value = "The ID of the existing message resource.", required = true)
                                 @PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        checkResourceFound(this.messageService.deleteMessage(id));
        this.messageService.deleteMessage(id);
    }
}
