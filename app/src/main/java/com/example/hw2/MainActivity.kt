package com.example.hw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hw2.ui.theme.HW2Theme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HW2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = arrayOf(
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6,
                        R.drawable.p7
                        )
                    val names = arrayOf(
                        "旗後燈塔",
                        "西門紅樓",
                        "女皇頭",
                        "旗津風車公園",
                        "旗津彩虹教堂",
                        "逢甲夜市",
                        "饒河夜市"
                    )
                    val address = arrayOf(
                        "80541高雄市旗津區旗下巷34號",
                        "108台北市萬華區成都路10號",
                        "207新北市萬里區港東路167-1號",
                        "805高雄市旗津區旗津二路",
                        "805高雄市旗津區旗津三路990號",
                        "407台中市西屯區文華路",
                        "105台北市松山區饒河街"
                    )
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen") {
                            MainScreen(imageId, names,address,navController)
                        }
                        composable(route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ){ index ->
                            DetailScreen(
                                photos = imageId,
                                names = names,
                                address = address,
                                itemIndex = index.arguments?.getInt("index"),
                                navController = navController
                            )
                        }


                    }
            }
        }
    }
}


}
