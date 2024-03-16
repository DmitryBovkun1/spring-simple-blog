package project;
import com.project.models.Comment;
import com.project.models.Post;
import com.project.models.Tag;
import com.project.models.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostTests {

    @Test
    public void testGettersAndSetters() {
        Post post = new Post();

        Long id = 1L;
        String title = "Test Title";
        String body = "Test Body";
        Date createDate = new Date();
        Date modifyDate = new Date();
        String imageUrl = "test_image_url";
        User user = new User();
        List<Tag> tags = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();

        post.setId(id);
        post.setTitle(title);
        post.setBody(body);
        post.setCreateDate(createDate);
        post.setModifyDate(modifyDate);
        post.setImageUrl(imageUrl);
        post.setUser(user);
        post.setTags(tags);
        post.setComments(comments);

        assertEquals(id, post.getId());
        assertEquals(title, post.getTitle());
        assertEquals(body, post.getBody());
        assertEquals(createDate, post.getCreateDate());
        assertEquals(modifyDate, post.getModifyDate());
        assertEquals(imageUrl, post.getImageUrl());
        assertEquals(user, post.getUser());
        assertEquals(tags, post.getTags());
        assertEquals(comments, post.getComments());
    }

    @Test
    public void testToString() {
        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");

        assertEquals("Title: Test Title Body: Test Body", post.toString());
    }

    @Test
    public void testConstructorWithTags() {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("Tag 1"));
        tags.add(new Tag("Tag 2"));

        Post post = new Post("Title", "Body", tags, null, null, null);

        assertEquals(2, post.getTags().size());
    }

    @Test
    public void testDefaultConstructor() {
        Post post = new Post();

        assertNull(post.getId());
        assertNull(post.getTitle());
        assertNull(post.getBody());
        assertNull(post.getCreateDate());
        assertNull(post.getModifyDate());
        assertNull(post.getImageUrl());
        assertNull(post.getUser());
        assertNull(post.getTags());
        assertNull(post.getComments());
    }
}
