package it.cosenonjaviste.testableandroidapps.v6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;

import org.parceler.Parcels;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import it.cosenonjaviste.testableandroidapps.ApplicationComponent;
import it.cosenonjaviste.testableandroidapps.CnjApplication;
import it.cosenonjaviste.testableandroidapps.R;
import it.cosenonjaviste.testableandroidapps.RetainedFragment;
import rx.functions.Actions;


public class ShareActivity extends ActionBarActivity {

    public static final String MODEL = "model";

    @InjectView(R.id.share_title) EditText titleEditText;

    @InjectView(R.id.share_body) EditText bodyEditText;

    private SharePresenter presenter;

    public static void createAndStart(Context context, ShareModel model) {
        Intent intent = new Intent(context, ShareActivity.class);
        populateIntent(intent, model);
        context.startActivity(intent);
    }

    public static void populateIntent(Intent intent, ShareModel model) {
        intent.putExtra(MODEL, Parcels.wrap(model));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApplicationComponent component = ((CnjApplication) getApplicationContext()).getComponent();
        component.inject(this);

        setContentView(R.layout.activity_detail);
        ButterKnife.inject(this);

        RetainedFragment<SharePresenter> retainedFragment = RetainedFragment.getOrCreate(this, "retained");
        presenter = retainedFragment.get();
        if (presenter == null) {
            presenter = component.getSharePresenterV6();
            retainedFragment.init(presenter, Actions.empty());
        }

        Bundle bundle = savedInstanceState != null ? savedInstanceState : getIntent().getExtras();
        ShareModel model = Parcels.unwrap(bundle.getParcelable(MODEL));

        presenter.init(this, model);
    }

    public void updateUi(ShareModel model) {
        titleEditText.setText(model.getTitle());
        bodyEditText.setText(model.getBody());
        titleEditText.setError(getErrorString(model.getTitleError()));
        bodyEditText.setError(getErrorString(model.getBodyError()));
    }

    private String getErrorString(int error) {
        return error == 0 ? null : getString(error);
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.updateModel(titleEditText.getText().toString(), bodyEditText.getText().toString());
        outState.putParcelable(MODEL, Parcels.wrap(presenter.getModel()));
    }

    @OnFocusChange({R.id.share_title, R.id.share_body}) void validateFields() {
        presenter.validateFields(titleEditText.getText().toString(), bodyEditText.getText().toString());
    }

    @OnClick(R.id.share_button) void share() {
        presenter.share(titleEditText.getText().toString(), bodyEditText.getText().toString());
    }
}
