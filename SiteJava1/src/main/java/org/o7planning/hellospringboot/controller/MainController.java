package org.o7planning.hellospringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.o7planning.hellospringboot.entities.Categorie;
import org.o7planning.hellospringboot.entities.Roles;
import org.o7planning.hellospringboot.entities.Users;
import org.o7planning.hellospringboot.services.CategorieService;
import org.o7planning.hellospringboot.services.ProduitService;
import org.o7planning.hellospringboot.services.RolesService;
import org.o7planning.hellospringboot.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {
	@Autowired
private ProduitService produitService;
	@Autowired
private CategorieService categorieService;
	@Autowired
private UsersService usersService;
	@Autowired
private RolesService roleService;

	
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
@GetMapping("/index")
public String index(Model model,HttpSession session) {
	
	session.setAttribute("user", getConnectedUser());
	model.addAttribute("listProduit",produitService.listDesProduit());
	model.addAttribute("listCategorie",categorieService.listDesCategorie());

	
	return "index";
}


@PostAuthorize("hasAnyRole('USER', 'ADMIN')")
@GetMapping("/catprod/{id}")
public String detail(@PathVariable Long id, ModelMap model) {
	
	Categorie categorie= categorieService.chercherUneCat(id);
	model.addAttribute("Categorie",categorie);
	model.addAttribute("ProdCat", produitService.listProduitParCategorie(id));
	return "catprod";
	
}


@RequestMapping("/login")
public String login() {
	return "login";
}

private Authentication getConnectedUser() {
	return SecurityContextHolder.getContext().getAuthentication();
}

@RequestMapping(value="/")
public String home() {
	
	return "bienvenue";
}
@RequestMapping(value="/403")
public String accessDenied() {
	return "403";
}
@RequestMapping(value = "/register", method = RequestMethod.GET)
public String showRegistrationForm(WebRequest request, ModelMap model) {
    Users user = new Users();
    model.addAttribute("user", user);
//    model.addAttribute("listRole", roleService.listDesRoles());
    return "register";
}
@PostMapping(value="/saveuser")
public String saveUser(@Valid Users users,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
	
	if(result.hasErrors()) {
		return "register";
	}
	PasswordEncoder encoder = new BCryptPasswordEncoder(10);
	users.setPass(encoder.encode(users.getPass()));
	List<Roles> list = new ArrayList<>();
	list.add(roleService.chercherUnRoleParRole("USER"));
	users.setRole(list);
	usersService.save(users);
	System.out.println();
	return "redirect:/login";
}
@GetMapping(value = "/resetpass")
public String resetpass(WebRequest request, ModelMap model,Users user) {
//    model.addAttribute("listUser", usersService.listDesUsers());
    return "resetpass";
}
@PostMapping(value="/savepass")
public String saveUser(String passU,String mdp,ModelMap model) {
	
	Users users = usersService.chercherUnUserByName(passU);
	PasswordEncoder encoder = new BCryptPasswordEncoder(10);
	users.setPass(encoder.encode(mdp));
	usersService.save(users);
	return "redirect:/login";
}

}


