package demo._41.jsonview;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import demo._41.domain.User;

/**
 * Created by nlabrot on 01/09/15.
 */
@RestController
public class JsonViewRestController {

    @RequestMapping("/ws/user/detail")
    @JsonView(value = User.All.class)
    public User detail() {
        return findUser();
    }

    @RequestMapping("/ws/user/summary")
    @JsonView(value = User.Summary.class)
    public User summary() {
        return findUser();
    }


    private User findUser() {
        return new User("first", "last", "address");
    }
}
