/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.MessageDAO;
import forum.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author kk
 */
public class MessageService {
    @Autowired
    private MessageDAO messageDAO;

    public <S extends Message> S save(S s) {
        return messageDAO.save(s);
    }

    public Message findOne(Long id) {
        return messageDAO.findOne(id);
    }

    public Iterable<Message> findAll() {
        return messageDAO.findAll();
    }

    public void delete(Long id) {
        messageDAO.delete(id);
    }

    public void deleteAll() {
        messageDAO.deleteAll();
    }
    
}
