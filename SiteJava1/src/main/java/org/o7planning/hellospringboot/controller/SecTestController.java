package org.o7planning.hellospringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.o7planning.hellospringboot.entities.Categorie;
import org.o7planning.hellospringboot.entities.Produit;
import org.o7planning.hellospringboot.entities.Roles;
import org.o7planning.hellospringboot.entities.Users;
import org.o7planning.hellospringboot.services.CategorieService;
import org.o7planning.hellospringboot.services.ProduitService;
import org.o7planning.hellospringboot.services.RolesService;
import org.o7planning.hellospringboot.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Secured("ROLE_ADMIN")
public class SecTestController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private RolesService roleService;

	@GetMapping("/ajoutcat")
	public String newcat(ModelMap model) {
		Categorie categorie= new Categorie();

		model.addAttribute("categorie",categorie);
		return "ajoutcat";
	}

	@GetMapping("/editcategorie/{id}")
	public String editcategorie(@PathVariable long id,ModelMap model) {
		Categorie categorie= categorieService.chercherUneCat(id);
		model.addAttribute("Categorie",categorie);
		return "editcategorie";
	}

	@GetMapping("/deletecat/{id}")
	public String deletecat(@PathVariable long id) {

		Categorie categorie=categorieService.chercherUneCat(id);
		categorieService.delete(categorie);
		return "redirect:/index";
	}

	@PostMapping(value="/savecat")
	public String saveCat(@Valid Categorie categorie,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {

		if(result.hasErrors()) {
			return "ajoutcat";
		}
		categorieService.save(categorie);
		return "redirect:/index";
	}

	@PostMapping(value="/ajoutsave")
	public String saveRegistration(@Valid Produit produit,BindingResult result,Long cat,ModelMap model,RedirectAttributes redirectAttributes) {

		if(result.hasErrors()) {
			System.out.println("has errors");
			return "ajout";
		}
		produit.setCategorie(categorieService.chercherUneCat(cat));
		produitService.save(produit);
		return "redirect:/index";
	}

	@GetMapping("/ajout")
	public String newRegistration(ModelMap model) {
		Produit produit= new Produit();
		model.addAttribute("listCategorie",categorieService.listDesCategorie());
		model.addAttribute("produit",produit);
		return "ajout";
	}

	@GetMapping("/editproduit/{id}")
	public String editproduit(@PathVariable long id,ModelMap model) {
		model.addAttribute("listCategorie",categorieService.listDesCategorie());
		Produit produit= produitService.chercherUnProduit(id);
		model.addAttribute("Produit",produit);
		return "editproduit";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {

		Produit produit=produitService.chercherUnProduit(id);
		produitService.delete(produit);
		return "redirect:/index";
	}
	@GetMapping("/users")
	public String userinfo(ModelMap model) {
		model.addAttribute("listRole",roleService.listDesRoles());
		model.addAttribute("listUser",usersService.listDesUsers());
		return "users";
	}
	@GetMapping("/edituser/{name}")
	public String edituserid(@PathVariable String name,ModelMap model) {
		model.addAttribute("listRole",roleService.listDesRoles());
		Users user=usersService.chercherUnUserByName(name);
		model.addAttribute("User", user);
		return "edituser";
	}

	@PostMapping(value="/addrole")
	public String addRole(Long id_user,ModelMap model,String roleP, RedirectAttributes redirectAttributes) {

		Users users = usersService.chercherUnUser(id_user);
		List<Roles> liste = new ArrayList<>();
		liste.add(roleService.chercherUnRoleParRole(roleP));
		users.setRole(liste);
		usersService.save(users);
		return "redirect:/users";
	}

}
