package application.android.com.viewpagerdemo.activity

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import application.android.com.viewpagerdemo.R

/**
 * Created by alphabet on 2019/1/9.
 */
class ShareActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        //设置允许通过ActivityOptions.makeSceneTransitionAnimation发送或者接收Bundle
//        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
//        //设置使用TransistionManager进行动画，不设置的话系统会使用一个默认的TransitionManager
//        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_share)
    }



//    @RequiresApi(Build.VERSION_CODES.KITKAT)
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//        setContentView(R.layout.activity_1)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            val explode = Fade()
//            explode.setDuration(2000)
//            window.enterTransition = explode
//            val changeBounds = ChangeBounds()
//            changeBounds.setDuration(2000)
//            window.sharedElementEnterTransition = changeBounds
//            window.allowEnterTransitionOverlap = true
//            window.allowReturnTransitionOverlap = true
//        }
//    }
}