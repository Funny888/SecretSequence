package com.funny.splash.screen

import android.os.CountDownTimer
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.funny.local.ds.R as LocalDs


@Composable
fun SplashScreen(next: () -> Unit) {
    Surface(modifier = Modifier.background(Color.Cyan)) {
        val infiniteTransition = rememberInfiniteTransition("rotation")
        val rotationAnimate by infiniteTransition.animateFloat(
            0F, 360F,
            animationSpec = infiniteRepeatable(
                tween(1000, easing = LinearEasing), repeatMode = RepeatMode.Restart
            )
        )

        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = LocalDs.drawable.yin_and_yang_symbol),
                contentDescription = "logo_splash",
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer {
                        rotationZ = rotationAnimate
                    }
            )
        }

        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                next.invoke()
            }
            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }
}


@Preview(showBackground = true, backgroundColor = android.graphics.Color.CYAN.toLong())
@Composable
private fun Preview() {
    SplashScreen {}
}