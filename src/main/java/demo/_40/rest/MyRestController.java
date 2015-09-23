package demo._40.rest;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;

/**
 * {@link RestController} is a meta annotation composed of {@link Controller} and {@link ResponseBody}
 * <p/>
 * Created by nlabrot on 01/09/15.
 */
@RestController
public class MyRestController {

    @RequestMapping("/ws/rest/{msg}")
    public Map<String, String> rest(@PathVariable("msg") String msg) {
        return ImmutableMap.of("hello", msg);
    }



}
