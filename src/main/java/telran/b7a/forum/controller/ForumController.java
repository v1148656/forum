package telran.b7a.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.forum.dto.ContentDto;
import telran.b7a.forum.dto.PostBodyDto;
import telran.b7a.forum.service.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController {
	ForumService forumService;
	
	@Autowired
	public ForumController(ForumService forumService) {
		this.forumService = forumService;
	}

	@PostMapping("/post/{author}")
	public ContentDto addPost(@PathVariable String author,@RequestBody PostBodyDto post) {
		return forumService.addNewPost(author, post);
	}
	
	@GetMapping("/post/{id}")
	public ContentDto findPostById(@PathVariable String id) {
		return forumService.getPost(id);
	}
	
}
