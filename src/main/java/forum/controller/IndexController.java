/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.controller;

import forum.entity.Utilisateur;
import forum.service.ForumService;
import forum.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kk
 */
@Controller
public class IndexController {
    
    @Autowired
    private ForumService forumService;
    
    @Autowired
    private SubjectService sujetService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToIndex(Model model){        
        model.addAttribute("forums", forumService.findAll());
        model.addAttribute("util", new Utilisateur());
        
        return "forum/list_forum";
    }
    
    @RequestMapping(value = "/{idForum}", method = RequestMethod.GET)
    public String goToForum(@PathVariable("idForum") long idForum, Model model){
        model.addAttribute("forum", forumService.findOne(idForum));
        model.addAttribute("util", new Utilisateur());
        
        return "forum/list_sujet";
    }
    
    @RequestMapping(value = "/sujet/{idSujet}", method = RequestMethod.GET)
    public String goToSujet(@PathVariable("idSujet") long idSujet, Model model){
        model.addAttribute("sujet", sujetService.findOne(idSujet));
        model.addAttribute("util", new Utilisateur());
        
        return "forum/list_message";
    }
}
