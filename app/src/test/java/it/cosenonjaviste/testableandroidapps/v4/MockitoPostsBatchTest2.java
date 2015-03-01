package it.cosenonjaviste.testableandroidapps.v4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import it.cosenonjaviste.testableandroidapps.model.Post;
import it.cosenonjaviste.testableandroidapps.model.PostResponse;
import it.cosenonjaviste.testableandroidapps.v3.WordPressService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoPostsBatchTest2 {

    @Mock WordPressService wordPressService;

    @Mock EmailSender emailSender;

    private PostsBatch postsBatch;

    @Before public void init() {
        postsBatch = new PostsBatch(wordPressService, emailSender);
    }

    @Test
    public void testExecute() {
        when(wordPressService.listPosts())
                .thenReturn(new PostResponse(new Post(), new Post(), new Post()));

        postsBatch.execute();

        verify(emailSender, times(3)).sendEmail(any(Post.class));
    }
}
