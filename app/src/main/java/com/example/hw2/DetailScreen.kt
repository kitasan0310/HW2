package com.example.hw2

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import android.widget.Toast.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    photos: Array<Int>,
    names: Array<String>,
    address: Array<String>,
    itemIndex: Int?,
    navController: NavController

) {
    val context = LocalContext.current
    Column(
        modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            IconButton(
                onClick = {
                    navController.navigateUp()
                }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        }


        Box(
            modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = photos[itemIndex!!]),
                contentDescription = names[itemIndex],
                modifier.clip(RoundedCornerShape(16.dp))
            )
        }
        Text(text = names[itemIndex!!], fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = address[itemIndex], fontSize = 18.sp)
        Button(
            onClick = {
                val mapUrl = "https://www.google.com/maps/search/?api=1&query=${address[itemIndex!!]}"
                val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(mapUrl))

                // 检查是否有应用程序可以处理该 Intent
                if (mapIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(mapIntent)
                } else {
                    // 如果没有应用程序可以处理该 Intent，显示一个提示消息
                    Toast.makeText(
                        context,
                        "没有找到适合的应用程序来处理地图导航",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("导航到此处")
        }

    }
}







