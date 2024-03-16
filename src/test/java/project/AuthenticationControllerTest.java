package project;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashMap;

import com.project.controllers.AuthenticationController;
import com.project.models.User;
import com.project.repositories.UsersRepository;
import com.project.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private Model model;

    @InjectMocks
    private AuthenticationController authenticationController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin() {
        assertEquals("login", authenticationController.login());
    }

    @Test
    public void testDoLogin_Successful() {
        String username = "testUser";
        String password = "testPassword";
        User mockUser = new User();
        mockUser.setUsername(username);
        mockUser.setPassword("encodedPassword");

        when(usersRepository.findByUsername(username)).thenReturn(mockUser);
        when(passwordEncoder.matches(password, mockUser.getPassword())).thenReturn(true);

        HashMap<String, String> result = authenticationController.doLogin(username, password);

        assertEquals("ok", result.get("status"));
        verify(userService, times(1)).authenticate(mockUser);
    }

    @Test
    public void testDoLogin_Unsuccessful() {
        String username = "testUser";
        String password = "testPassword";

        when(usersRepository.findByUsername(username)).thenReturn(null);

        HashMap<String, String> result = authenticationController.doLogin(username, password);

        assertEquals("error", result.get("status"));
        verify(userService, never()).authenticate(any(User.class));
    }

    @Test
    public void testShowForm() {
        String viewName = authenticationController.showForm(model);
        assertEquals("users/create", viewName);
        verify(model, times(1)).addAttribute(eq("user"), any(User.class));
    }
}
