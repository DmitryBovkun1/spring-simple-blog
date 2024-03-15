package project;
import static org.junit.jupiter.api.Assertions.*;

import com.project.BlogApp;
import com.project.models.FriendList;
import com.project.models.Post;
import com.project.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = BlogApp.class)
public class UserTests {

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        long id = 1L;
        String username = "testUser";
        String email = "test@example.com";
        String password = "password123";
        List<Post> posts = new ArrayList<>();
        List<FriendList> friends = new ArrayList<>();

        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setPosts(posts);
        user.setFriends(friends);

        assertEquals(id, user.getId());
        assertEquals(username, user.getUsername());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(posts, user.getPosts());
        assertEquals(friends, user.getFriends());
    }

    @Test
    public void testToString() {
        User user = new User("testUser", "test@example.com", "password123", new ArrayList<>());
        assertEquals("testUser email is test@example.com and its ID is 0", user.toString());
    }

    @Test
    public void testCopyConstructor() {
        User originalUser = new User("testUser", "test@example.com", "password123", new ArrayList<>());
        User copiedUser = new User(originalUser);

        assertEquals(originalUser.getId(), copiedUser.getId());
        assertEquals(originalUser.getUsername(), copiedUser.getUsername());
        assertEquals(originalUser.getEmail(), copiedUser.getEmail());
        assertEquals(originalUser.getPassword(), copiedUser.getPassword());
    }
}
