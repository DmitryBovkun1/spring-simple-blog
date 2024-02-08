package com.project.controllers;

import com.project.models.PasswordResetToken;
import com.project.models.User;
import com.project.repositories.PasswordResetTokenRepository;
import com.project.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Controller
public class ResetPasswordController {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/resetpassword")
    public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token);

        if (resetToken == null || resetToken.isExpired()) {
            model.addAttribute("status", "error");
            model.addAttribute("message", "Invalid or expired reset token.");
            return "reset-password-status";
        }

        model.addAttribute("status", "success");
        model.addAttribute("message", "");
        model.addAttribute("token", token);
        return "resetpassword";
    }

    @PostMapping("/resetpassword")
    public String processResetPassword(@RequestParam("token") String token,
                                       @RequestParam("password") String password,
                                       @RequestParam("confirmPassword") String confirmPassword,
                                       Model model) {
        PasswordResetToken resetToken = passwordResetTokenRepository.findByToken(token);

        if (resetToken == null || resetToken.isExpired()) {
            model.addAttribute("status", "error");
            model.addAttribute("message", "Invalid or expired reset token.");
            return "reset-password-status";
        }
        if (!password.equals(confirmPassword)) {
            model.addAttribute("status", "error");
            model.addAttribute("message", "Passwords do not match. Retry your attempt");
            return "reset-password-status";
        }

        User user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        resetToken.setExpiryDate(new Date());
        passwordResetTokenRepository.save(resetToken);

        model.addAttribute("status", "success");
        return "reset-password-status";
    }
}
