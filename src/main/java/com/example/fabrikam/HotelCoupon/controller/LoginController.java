package com.example.fabrikam.HotelCoupon.controller;

import com.example.fabrikam.HotelCoupon.dao.UserRepository;
import com.example.fabrikam.HotelCoupon.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserRepository repository;


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("loginUser", new User());
        return "login";
    }

    @RequestMapping("/formPost")
    public String login(User user, Model model, HttpServletRequest httpRequest) {
        String failedUrl = "redirect:/";
        String successUrl = "redirect:/guest";
        String username = user.getUsername();
        String password = user.getPassword();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return failedUrl;
        }
        ArrayList<User> searchedUsers = repository.findByUsername(username);
        if(searchedUsers.isEmpty()){
            return failedUrl;
        }
        for (User item : searchedUsers){
            if(item.getPassword().equalsIgnoreCase(password)){
                System.out.println("Login successfully.");
                httpRequest.getSession().setAttribute("user",user);
                return successUrl;
            }
        }
        return failedUrl;
    }
}
