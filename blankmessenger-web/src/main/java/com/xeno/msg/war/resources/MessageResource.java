package com.xeno.msg.war.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xeno.msg.ejb.models.Message;
import com.xeno.msg.ejb.services.MessageService;

@Path("/messages")
public class MessageResource {
	
	@Inject
	MessageService msgSvc;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return msgSvc.getMessage();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML	)
	@Path("/{messageId}")
	public Message getMessagesById(@PathParam("messageId") long messageId) {
		return msgSvc.getMsgById(messageId);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_XML	)
	@Path("/{messageId}")
	public Message deleteMsgById(@PathParam("messageId") long messageId) {
		return msgSvc.deleteMsgById(messageId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML	)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg) {
		return msgSvc.addMsg(msg);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message msg) {
		return this.msgSvc.updateMsgById(messageId, msg);
	}
}
