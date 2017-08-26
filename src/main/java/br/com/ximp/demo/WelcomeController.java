package br.com.ximp.demo;

import br.com.ximp.demo.model.BlogPost;
import br.com.ximp.demo.repository.BlogPostRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@Controller
public class WelcomeController {

    BlogPostRepository repository;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model, ViewResolverRegistry registry) {
        try {
            model.put("hostname", InetAddress.getLocalHost().toString());
            return "welcome";
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}