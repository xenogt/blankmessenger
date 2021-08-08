package com.xeno.msg.ejb.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.xeno.msg.ejb.models.Message;

@Stateless
public class MessageService {
	private long idCount = 1L;
	List<Message> list = new ArrayList<Message>();
	public MessageService() {
		Message m1 = new Message(this.idCount++, "omg", "andy");
		Message m2 = new Message(this.idCount++, "wtf", "jack");
		list.add(m1);
		list.add(m2);
	}
	
	public String sayHello() {
		return "wat is going on?";
	}
	public List<Message> getMessage() {
		
		return list;
	}
	
	public Message getMsgById(long id) {
		for(Message a: list) {
			if(a.getId()==id)
				return a;
		}
		return null;
	}
	
	public Message addMsg(Message msg) {
		Message m = this.buildNewMsg(msg);
		this.list.add(m);
		return m;
	}
	
	public Message updateMsgById(long id, Message msg) {
		for(Message a: list) {
			if(a.getId()==id) {
				boolean updated = false;
				if(!msg.getAuthor().equals(a.getAuthor())) {					
					a.setAuthor(msg.getAuthor());
					updated = true;
				}
				if(!msg.getMsg().equals(a.getMsg())) {
					a.setMsg(msg.getMsg());
					updated = true;
				}
				if(updated) {
					a.setCreated(new Date());
					return msg;					
				} else 
					return null;
			}
		}
		return null;
	}
	
	public Message deleteMsgById(long id) {
		for(Message a: list) {
			if(a.getId()==id) {
				list.remove(a);
				return a;
			}
		}
		return null;
	}
	
	private Message buildNewMsg(Message m) {
		return new Message(this.idCount++, m.getMsg(), m.getAuthor());
	}
}
