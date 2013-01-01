package com.cloudfoundry.tothought;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloudfoundry.tothought.entities.Post;
import com.cloudfoundry.tothought.entities.Series;
import com.cloudfoundry.tothought.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
@ContextConfiguration(locations="classpath:META-INF/test-context.xml")
public class PostRepositoryTest {

	@Autowired
	PostRepository repository;
	
	@Test
	public void test() {
		Series series = new Series();
		series.setTitle("Jpa Tutorial");
		
		Post post = new Post();
		post.setPostDate(new Date());
		post.setTitle("First Post");
		
		post.setSeries(series);
		
		repository.save(post);
		
		Post dbpost = repository.findOne(post.getPostId());
		assertNotNull(dbpost);
		assertNotNull(dbpost.getSeries());
		System.out.println(dbpost.getTitle());
	}

}
