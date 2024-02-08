package com.project.controllers;

import com.project.models.Comment;
import com.project.models.Post;
import com.project.models.User;
import com.project.repositories.PostRepository;
import com.project.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.repositories.CommentRepository;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class CommentsController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/comments")
    @ResponseBody
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    @GetMapping("/comments/children/{id}")
    @ResponseBody
    public List<Comment> getChildren(@PathVariable long id){
        return commentRepository.findByParent(commentRepository.getOne(id));
    }
    @PostMapping("/addComment")
    public String addComment(@RequestParam("postId") Long postId,
                             @RequestParam("newComment") String newComment,
                             Principal principal) {
        User currentUser = usersRepository.findByUsername(principal.getName());

        Post post = postRepository.findById(postId).orElseThrow(EntityNotFoundException::new);

        Comment comment = new Comment();
        comment.setBody(newComment);
        comment.setUser(currentUser);
        comment.setPost(post);
        comment.setCreatedAt(new Date());

        commentRepository.save(comment);

        return "redirect:/posts/" + postId;
    }
}
