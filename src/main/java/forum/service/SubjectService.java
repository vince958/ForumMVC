/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.SubjectDAO;
import forum.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kk
 */
@Service
public class SubjectService {
    
    @Autowired
    private SubjectDAO sujetDAO;

    public <S extends Subject> S save(S s) {
        return sujetDAO.save(s);
    }

    public Subject findOne(Long id) {
        return sujetDAO.findOne(id);
    }

    public Iterable<Subject> findAll() {
        return sujetDAO.findAll();
    }

    public void delete(Long id) {
        sujetDAO.delete(id);
    }

    public void deleteAll() {
        sujetDAO.deleteAll();
    }
    
    
}
