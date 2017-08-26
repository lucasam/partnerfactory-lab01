package br.com.ximp.demo.repository;

import br.com.ximp.demo.model.BlogPost;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RepositoryEventHandler(BlogPost.class)
public class BlogPostRepositoryEventHandler {

    @HandleBeforeCreate
    public void handleBlogPostSave(BlogPost blogPost) {
        try {
            blogPost.setServerSourceInfo(InetAddress.getLocalHost().toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            // Give up
        }
    }
}
