package com.project.controllers;

import com.project.models.PasswordResetToken;
import com.project.models.User;
import com.project.repositories.PasswordResetTokenRepository;
import com.project.repositories.UsersRepository;
import com.project.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Controller
public class ForgotPasswordController {
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam("email") String email, HttpServletRequest request, Model model) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            model.addAttribute("error", "We didn't find this user");
            return "forgot-password";
        }

        PasswordResetToken token = new PasswordResetToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiryDate(calculateExpiryDate());
        passwordResetTokenRepository.save(token);
        /*
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("your-email@example.com"); // встановіть правильний емейл
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Password Reset");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        mailMessage.setText("You can reset your password by clicking on the following link: " + url + "/resetpassword?token=" + token.getToken());

        try {
            emailService.sendEmail(mailMessage);
            model.addAttribute("resetSuccess", "Password reset email sent successfully.");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to send password reset email.");
        }
        */
        model.addAttribute("resetSuccess", "Password reset email sent successfully.");
        return "forgot-password";
    }

    private Date calculateExpiryDate() {
        long nowMillis = System.currentTimeMillis();
        long fourHoursInMillis = 4 * 60 * 60 * 1000;
        return new Date(nowMillis + fourHoursInMillis);
    }
}
