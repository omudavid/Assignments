package com.example.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClick.setOnClickListener{
            val animation = ObjectAnimator.ofFloat(img, View.TRANSLATION_X,400f)
            animation.duration = 1000
            animation.repeatCount = 1
            animation.repeatMode = ObjectAnimator.REVERSE

            animation.addListener( object : AnimatorListenerAdapter(){
                override fun onAnimationStart(animation: Animator?) {
                    btnClick.isEnabled = false
                }

                override fun onAnimationEnd(animation: Animator?) {
                    btnClick.isEnabled = true
                }
            })

            animation.start()

        }
    }



}