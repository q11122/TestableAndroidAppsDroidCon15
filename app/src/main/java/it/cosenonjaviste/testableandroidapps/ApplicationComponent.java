package it.cosenonjaviste.testableandroidapps;

import javax.inject.Singleton;

import dagger.Component;
import it.cosenonjaviste.testableandroidapps.model.WordPressService;
import it.cosenonjaviste.testableandroidapps.v3.PostListActivity;
import it.cosenonjaviste.testableandroidapps.v3.ShareActivity;
import it.cosenonjaviste.testableandroidapps.v5.PostListPresenter;
import it.cosenonjaviste.testableandroidapps.v5.SharePresenter;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(PostListActivity activity);

    void inject(ShareActivity activity);


    void inject(it.cosenonjaviste.testableandroidapps.v4.PostListActivity postListActivity);

    void inject(it.cosenonjaviste.testableandroidapps.v4.ShareActivity shareActivity);


    void inject(it.cosenonjaviste.testableandroidapps.v5.PostListActivity postListActivity);

    PostListPresenter getPostListPresenter();

    void inject(it.cosenonjaviste.testableandroidapps.v5.ShareActivity shareActivity);

    SharePresenter getSharePresenter();


    void inject(it.cosenonjaviste.testableandroidapps.v6.PostListActivity postListActivity);

    it.cosenonjaviste.testableandroidapps.v6.PostListPresenter getPostListPresenterV6();

    void inject(it.cosenonjaviste.testableandroidapps.v6.ShareActivity shareActivity);

    it.cosenonjaviste.testableandroidapps.v6.SharePresenter getSharePresenterV6();


    WordPressService getWordPressService();

    ShareExecutor getShareExecutor();

    SchedulerManager getSchedulerManager();


    void inject(it.cosenonjaviste.testableandroidapps.v8.PostListActivity postListActivity);

    it.cosenonjaviste.testableandroidapps.v8.PostListPresenter getPostListPresenterV8();

    void inject(it.cosenonjaviste.testableandroidapps.v8.ShareActivity shareActivity);

    it.cosenonjaviste.testableandroidapps.v8.SharePresenter getSharePresenterV8();


    it.cosenonjaviste.testableandroidapps.v9.PostListPresenter getPostListPresenterV9();

    it.cosenonjaviste.testableandroidapps.v9.SharePresenter getSharePresenterV9();


    it.cosenonjaviste.testableandroidapps.v10.PostListPresenter getPostListPresenterV10();

    it.cosenonjaviste.testableandroidapps.v10.SharePresenter getSharePresenterV10();
}
