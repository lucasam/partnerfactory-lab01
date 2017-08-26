package br.com.ximp.demo.repository;

import br.com.ximp.demo.model.BlogPost;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "blogPost")
public interface BlogPostRepository  extends PagingAndSortingRepository<BlogPost, Integer> {
}
