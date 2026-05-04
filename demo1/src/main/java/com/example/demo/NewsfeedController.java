package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsfeedController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String viewNewsfeed(Model model) {
        // Lấy tất cả bài viết và sắp xếp theo thời gian mới nhất
        model.addAttribute("posts", postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")));
        return "index";
    }

    @PostMapping("/post/save")
    public String savePost(@RequestParam String author, @RequestParam String content) {
        Post newPost = new Post(author, content);
        postRepository.save(newPost);
        return "redirect:/"; // Lưu xong quay về trang chủ
    }
}
