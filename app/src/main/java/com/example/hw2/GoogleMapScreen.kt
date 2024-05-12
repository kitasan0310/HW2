package com.example.hw2

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.google.android.gms.maps.MapView

@Composable
fun GoogleMapScreen(
    address: String,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            MapView(context).apply {
                // 初始化 Google 地图
                onCreate(null)
                getMapAsync { googleMap ->
                    // 在地图准备完成后执行其他操作
                    // 例如添加标记等
                }
            }
        }
    )
}
