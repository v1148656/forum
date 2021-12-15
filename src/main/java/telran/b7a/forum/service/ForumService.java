package telran.b7a.forum.service;

import telran.b7a.forum.dto.ContentDto;
import telran.b7a.forum.dto.PostBodyDto;

public interface ForumService {
	ContentDto addNewPost(String author, PostBodyDto post);

	ContentDto getPost(String id);

}
