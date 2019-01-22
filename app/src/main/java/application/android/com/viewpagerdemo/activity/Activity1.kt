package application.android.com.viewpagerdemo.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.view.Window
import application.android.com.viewpagerdemo.R
import kotlinx.android.synthetic.main.activity_1.*

class Activity1 : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置允许通过ActivityOptions.makeSceneTransitionAnimation发送或者接收Bundle
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        //设置使用TransistionManager进行动画，不设置的话系统会使用一个默认的TransitionManager
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_1)
        ivIcon.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val intent = Intent(this, ShareActivity::class.java)
                val transitionActivityOptions =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                this, ivIcon, ivIcon.transitionName)

                ActivityCompat.startActivity(
                        this, intent, transitionActivityOptions.toBundle())
            }
        }
    }
}
