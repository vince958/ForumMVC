/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.controller;

import forum.entity.Utilisateur;
import forum.service.ForumService;
import forum.service.UtilisateurService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kk
 */
@Controller
public class UserController {

    @Autowired
    private UtilisateurService userService; // c'est un exemple! en regle generale, pas de controller dans un dao, plutot des services.
    
    @Autowired
    private ForumService forumService;
    /*
     @RequestMapping(value = "/lister", method = RequestMethod.GET)// la route
     public String list(Model model){
     model.addAttribute("users", userService.findAll());
        
     return "user/user_list";//la vue à afficher;
     }
    
     @RequestMapping(value= "/ajouter", method = RequestMethod.GET)
     public String ajout(Model model){
     Utilisateur utilisateur = use/inscriptionrService.findOne(1L);
     model.addAttribute("util", utilisateur);
        
     return "user/user_ajout";
     }
    
     @RequestMapping(value = "/ajouterPost", method = RequestMethod.POST)
     public String ajout(@ModelAttribute("util") Utilisateur u, Model model){
     model.addAttribute("NOM", u.getLogin());
     model.addAttribute("PRENOM", u.getMdp());
        
     return "user/user_ajout";
     }/inscription
     */

    @RequestMapping(value = "/connexion", method = RequestMethod.POST)
    public String connexion(@Valid @ModelAttribute("util") Utilisateur u, BindingResult result, HttpSession session, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("forums", forumService.findAll());
            return "forum/list_forum";
        }

        Utilisateur utilisateur = userService.findOneByLogin(u.getLogin());
        if (utilisateur != null && utilisateur.getMdp().equals(u.getMdp())) {
            session.setAttribute("isLogged", true);
            session.setAttribute("userLogin", utilisateur.getLogin());
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public String deconnexion(HttpSession request) {
        request.invalidate();

        return "redirect:/";
    }

    @RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public String goToInscription(Model model) {
        model.addAttribute("util", new Utilisateur());
        List<Utilisateur.TypeConnexion> typeList = new ArrayList<>(2);
        typeList.add(Utilisateur.TypeConnexion.PREMIUM);
        typeList.add(Utilisateur.TypeConnexion.UTILISATEUR);
        model.addAttribute("typeList", typeList);
        return "user/user_inscription";
    }

    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String inscription(@Valid @ModelAttribute("util") Utilisateur u, BindingResult result, HttpSession session, Model model) {

        if (result.hasErrors()) {
            List<Utilisateur.TypeConnexion> typeList = new ArrayList<>(2);
            typeList.add(Utilisateur.TypeConnexion.PREMIUM);
            typeList.add(Utilisateur.TypeConnexion.UTILISATEUR);
            model.addAttribute("typeList", typeList);
            return "user/user_inscription";
        }

        userService.save(u);

        session.setAttribute("isLogged", true);
        session.setAttribute("userLogin", u.getLogin());
        return "redirect:/";
    }

//    @RequestMapping(value = "/ajouterGet", method = RequestMethod.GET)
//    public String ajout
}
