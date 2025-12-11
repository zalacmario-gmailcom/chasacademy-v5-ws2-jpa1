package se.chasacademy.databaser.wsjpa.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import se.chasacademy.databaser.wsjpa.blog.models.Comment;
import se.chasacademy.databaser.wsjpa.blog.models.Post;
import se.chasacademy.databaser.wsjpa.blog.repositories.CommentRepository;
import se.chasacademy.databaser.wsjpa.blog.repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {
	private PostRepository postRepository;
	private CommentRepository commentRepository;

	public BlogApplication(PostRepository postRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (Post current : postRepository.findAll()) {
			System.out.println("title: " + current.getTitle() + " published at: " + current.getPublishDate());
		}

		Optional<Post> firstPost = postRepository.findById(1L);
		if (firstPost.isPresent()) {
			Post first = firstPost.get();
			System.out.println("title: " + first.getTitle() + " published at: " + first.getPublishDate());
		}

		// - uppdatera inlägg
		if (firstPost.isPresent()) {
			Post first = firstPost.get();
			first.setTitle("Uppdaterad titel");
			postRepository.save(first);
			// lista kommentarer
			for (Comment comment : first.getComments()) {
				System.out.println("Comment: " + comment.getComment() +
						" is appropriate: " + (comment.isInappropriate() ? "No" : "Yes"));

				comment.setInappropriate(true);
				commentRepository.save(comment);
			}
		}

		// - ta bort inlägg
		boolean delete = false;
		if (delete) {
			postRepository.deleteById(1L);
		}

		// skapa ny post
		Post newPost = new Post("Hello JPA", "This is my first post saved with JPA!", "Admin");

		// spara posten
		postRepository.save(newPost);

	}
}
