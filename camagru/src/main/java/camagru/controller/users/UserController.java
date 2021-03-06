package camagru.controller.users;

import camagru.Message;
import camagru.User;
import camagru.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/users", produces="application/json")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
    private User user;
    private Message response;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUser")
    public User getUser(@RequestParam("id") int id) {
        this.user = userRepository.getUser(id);
        return (this.user);
    }

    @GetMapping("/getAllUsernames")
    public List<String> getAllUsers() {
        return (userRepository.getAllUserNames());
    }

    @GetMapping("/getAll")
    public List<Map<String, Object>> getAll() {
        return (userRepository.getAll());
    }

    @GetMapping("/confirm")
    public Message confirmRegister(@RequestParam String key) {
        return (userRepository.confirmRegister(key));
    }

    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public HashMap<String, Object> login(@RequestBody User user) {
        return (userRepository.authenticate(user.getEmail(), user.getPassword()));
    }

    @PostMapping(path = "/forgot", consumes = "application/json", produces = "application/json")
    public void resetPassword(@RequestBody User user) {
        userRepository.resetPassword(user);
    }

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public Message create(@RequestBody User user) {
        return (userRepository.createUser(user));
    }

    @PostMapping(path = "/updateEmail", consumes = "application/json", produces = "application/json")
    public Message updateEmail(@RequestBody User user) {
        return (userRepository.updateEmail(user));
    }

    @PostMapping(path = "/updateUsername", consumes = "application/json", produces = "application/json")
    public Message updateUsername(@RequestBody User user) {
        return (userRepository.updateUsername(user));
    }

    @PostMapping(path = "/updatePassword", consumes = "application/json", produces = "application/json")
    public Message updatePassword(@RequestBody Map<String, String> data) {
        User user = new User();
        String oldPass;

        user.setPassword(data.get("new_password"));
        user.setId(Integer.parseInt(data.get("id")));
        oldPass = data.get("old_password");
        return (userRepository.updatePassword(user, oldPass));
    }

    @PostMapping(path = "/updateNotificationPreference", consumes = "application/json", produces = "application/json")
    public Message updateNotificationPreferennce(@RequestBody User user) {
        return (userRepository.updateNotificationPreferences(user));
    }
}