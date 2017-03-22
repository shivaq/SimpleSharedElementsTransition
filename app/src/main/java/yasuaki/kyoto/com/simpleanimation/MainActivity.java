package yasuaki.kyoto.com.simpleanimation;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private boolean mHoldForTransition;

    @BindView(R.id.img_travis) ImageView imgTravis;
    @BindView(R.id.txt_travis_comment) TextView txtTravis;
    @BindView(R.id.button_to_second) Button btnToSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        TypedArray typedArray = obtainStyledAttributes(null, R.styleable.Transition, 0, 0);
        mHoldForTransition = typedArray.getBoolean(R.styleable.Transition_sharedElementTransitions, false);
        typedArray.recycle();

//        ViewCompat.setTransitionName(imgTravis, "imageViewTravis");
    }

    @OnClick(R.id.button_to_second)
    void onItemClicked() {
        Intent intent = new Intent(this, SecondActivity.class);

        ActivityOptionsCompat optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        new Pair<View, String>(imgTravis, getString(R.string.transition_travis)),
                        new Pair<View, String>(txtTravis, getString(R.string.transition_travis_comment)));

        ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
    }
}
