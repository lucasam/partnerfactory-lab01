package br.com.ximp.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String message;

    private String serverSourceInfo;

}
