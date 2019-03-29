package ru.sbt.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sbt.lab2.domain.entity.User;
import ru.sbt.lab2.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private UserRepository userRep;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "test");
        return "main";
    }

    @PostMapping
    public String addUser(
            @RequestParam(value = "login", required = true) String login,
            @RequestParam(value = "password", required = false) String password,
            Map<String, Object> model
    ) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userRep.save(user);
        return "main";
    }

    public String showUser(Map<String, Object> model) {
        Iterable<User> users = userRep.findAll();
        model.put("users", users);
        return "main";
    }

}
