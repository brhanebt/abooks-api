package com.abooksapimvn.abooks.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abooksapimvn.abooks.model.User;
import com.abooksapimvn.abooks.service.UsersService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1")
public class UserController {

    private final UsersService usersService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    // findAll
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("users")
    public List<User> getAllUsers(){
        return usersService.getAllUsers();
    }

    // Retrieve by one user ID
    @GetMapping("users/{userId}")
    public User getAUser(@PathVariable Long userId) {
        return usersService.getUserById(userId);
    }

    // Multiple values: /users/by-ids?id=1&id=2&id=3
    // Example /api/v1/users/by-ids?id=1&id=2&id=3
    @GetMapping("users/by-ids")
    public List<User> getUsersByIds(@RequestParam("id") List<Long> idsList) {
        LOGGER.info(idsList.toString());
        return usersService.getAllUsersByIdList(idsList);
    }

    // Multiple values as array: /users/by-locations?location=nyc&location=la
    // Example:- /api/v1/users/by-locations?location=nyc,%20new%20york,%20usa&location=stockton,%20california,%20usa
    @GetMapping("users/by-locations")
    public List<User> getUsersByLocations(@RequestParam("location") List<String> locations) {
        LOGGER.info(locations.toString());
        return usersService.getAllUsersByLocations(locations);
    }

    // Multiple path variables: /users/123/books/456
    @GetMapping("users/{userId}/books/{bookId}")
    public String getUserBook(@PathVariable String userId, @PathVariable String bookId) {
        return "User: " + userId + ", Book: " + bookId;
    }

    // Multiple query parameters: /users/search?location=nyc&age=25
    @GetMapping("users/search")
    public String searchUsers(@RequestParam String location, @RequestParam Integer age) {
        return "Location: " + location + ", Age: " + age;
    }

    // Optional parameters: /users/filter?location=nyc&age=25 (age optional)
    @GetMapping("users/filter")
    public String filterUsers(@RequestParam String location, @RequestParam(required = false) Integer age) {
        return "Location: " + location + ", Age: " + (age != null ? age : "not specified");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping("users")
    public User addUser(@RequestBody User user) {
        return usersService.saveUser(user);
    }
    
}
