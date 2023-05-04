package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("")
    public String displayAddUserForm(){

        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("errorMessage", "Your passwords didn't match. Please try again.");
        Boolean verifyCheck;
       if(verify.equals(user.getPassword())){
           verifyCheck = true;
           model.addAttribute("verifyCheck", verifyCheck);
           return "user/index";
       } else {
           verifyCheck = false;
           model.addAttribute("verifyCheck", verifyCheck);
           return "user/add";
       }
    }
}
