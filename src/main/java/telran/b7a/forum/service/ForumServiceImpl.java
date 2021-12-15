package telran.b7a.forum.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.b7a.forum.dao.ForumMongoRepository;
import telran.b7a.forum.dto.ContentDto;
import telran.b7a.forum.dto.PostBodyDto;
import telran.b7a.forum.dto.exception.PostNotFoundException;
import telran.b7a.forum.model.Post;

@Service
public class ForumServiceImpl implements ForumService {
	
	ForumMongoRepository forumRepository;
	ModelMapper modelMapper;

	@Autowired
	public ForumServiceImpl(ForumMongoRepository forumRepository, ModelMapper modelMapper) {
		this.forumRepository = forumRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ContentDto addNewPost(String author, PostBodyDto postBody) {
		Post post = modelMapper.map(postBody, Post.class);
		post.setAuthor(author);
		post.setDateCreated(LocalDateTime.now());
		forumRepository.save(post);
		return modelMapper.map(post, ContentDto.class);
	}

	@Override
	public ContentDto getPost(String id) {
		Post post = forumRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
		return modelMapper.map(post, ContentDto.class);
	}
	
}
