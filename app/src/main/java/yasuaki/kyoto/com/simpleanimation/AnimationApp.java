package yasuaki.kyoto.com.simpleanimation;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Yasuaki on 2017/03/21.
 */

public class AnimationApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //BuildConfig.DEBUG デバッグなフレーバー時のみ行う
        if (BuildConfig.DEBUG) {
            //プラント済みのTreeを全部根こそぎにする
            Timber.uprootAll();
            //Tree のインスタンスを 植える
            //DebugTree →デバッグビルド用のTree。このTree をどのクラスからコールしても、TAG を暗黙裡に推理して当てはめてくれる
            Timber.plant(new Timber.DebugTree());
        }
    }
}

