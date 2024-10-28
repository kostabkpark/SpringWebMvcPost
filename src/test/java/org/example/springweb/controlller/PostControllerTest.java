package org.example.springweb.controlller;

import org.example.springweb.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PostControllerTest {
    PostController postController;

    void PostControllerTest(PostController postController){
        this.postController = postController;
    }
    @Test
    public void testPostController() {

    }
}