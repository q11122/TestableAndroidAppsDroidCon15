package it.cosenonjaviste.testableandroidapps.v6;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import it.cosenonjaviste.testableandroidapps.model.Post;
import it.cosenonjaviste.testableandroidapps.model.PostResponse;
import it.cosenonjaviste.testableandroidapps.v3.WordPressService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PostsBatchTest {

    @Inject WordPressService wordPressService;

    @Inject EmailSender emailSender;

    @Inject PostsBatch postsBatch;

    @Before public void init() {
        Dagger_TestComponent.create().inject(this);
    }

    @Test
    public void testExecute() {
        when(wordPressService.listPosts())
                .thenReturn(new PostResponse(new Post(), new Post(), new Post()));

        postsBatch.execute();

        verify(emailSender, times(3)).sendEmail(any(Post.class));
    }
}
