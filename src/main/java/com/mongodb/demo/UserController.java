package com.mongodb.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id) {
        User user = userService.findById(id);
        if (user == null) {
            user = new User();
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> removeUserById(@PathVariable String id) {
        User user = userService.findById(id);
        if (user == null) {
            user = new User();
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/Update")
    public ResponseEntity<User> updateUserById(@RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/SaveAll")
    public ResponseEntity<String> saveAll(@RequestBody List<User> users) {
        userService.saveAll(users);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(path = "/Save", method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) {

        User output = userService.save(user);
        return new ResponseEntity<User>(output, HttpStatus.OK);
    }

    @GetMapping("/All")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        if (users == null) {
            users = new ArrayList<>();
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/Search")
    public ResponseEntity<List<User>> search(@RequestParam String q) {
        List<User> users = userService.search(q);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/Exist")
    public ResponseEntity<Boolean> exist(@RequestParam String q) {
        return new ResponseEntity<>(userService.existsByEmail(q), HttpStatus.OK);
    }

}
