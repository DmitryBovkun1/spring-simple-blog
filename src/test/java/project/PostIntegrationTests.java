package project;

import com.project.BlogApp;
import com.project.models.User;
import com.project.repositories.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApp.class)
@AutoConfigureMockMvc
public class PostIntegrationTests {

    String TOKEN_ATTR_NAME = "org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN";
    HttpSessionCsrfTokenRepository httpSessionCsrfTokenRepository = new HttpSessionCsrfTokenRepository();
    CsrfToken csrfToken = httpSessionCsrfTokenRepository.generateToken(new MockHttpServletRequest());

    @Autowired
    private MockMvc mvc;

    @Autowired
    UsersRepository usersRepository;

    // Sanity Test, just to make sure the mvc bean is working
    @Test
    public void contextLoads() throws Exception {
        assertThat(mvc).isNotNull();
    }

    // https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/util/AntPathMatcher.html
    @Test
    public void testShowCreatePostPage() throws Exception {
        this.mvc.perform(get("/posts/create"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    public void testCreateAPost() throws Exception {
        User testUser = new User();
        testUser.setUsername("fer");
        testUser.setEmail("fer@example.com");
        testUser.setPassword("password");
        usersRepository.save(testUser);

        assertThat(testUser.getId()).isNotNull();

        this.mvc.perform(post("/posts/create")
                        .sessionAttr(TOKEN_ATTR_NAME, csrfToken)
                        .param(csrfToken.getParameterName(), csrfToken.getToken())
                        .param("title", "test post")
                        .param("body", "lorem")
                        .param("tags", "1")
                        .param("user", String.valueOf(testUser.getId()))
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/"));

        usersRepository.delete(testUser);
    }


}