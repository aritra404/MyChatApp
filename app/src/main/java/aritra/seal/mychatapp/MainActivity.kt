package aritra.seal.mychatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aritra.seal.mychatapp.screen.LoginScreen
import aritra.seal.mychatapp.screen.SignUpScreen
import aritra.seal.mychatapp.ui.theme.MyChatAppTheme
import dagger.hilt.android.AndroidEntryPoint


sealed class DestinationScreen(var route: String){
    object SignUp : DestinationScreen("signup")
    object LogIn : DestinationScreen("login")
    object Profile : DestinationScreen("prof")
    object ChatList : DestinationScreen("chatList")
    object SingleChat : DestinationScreen("singleChat/{chatId}")
    {
        fun createRoute(id : String) = "singleChat/$id"
    }

    object StatusList : DestinationScreen("chatList")
    object SingleStatus : DestinationScreen("singleStatus/{chatId}")
    {
        fun createRoute(userId : String) = "singleChat/$userId"
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyChatAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  ChatAppNavigation()
                }
            }
        }
    }
}

@Composable
fun ChatAppNavigation(){

    val navController = rememberNavController()
    var vm = hiltViewModel<LCViewModel>()

    NavHost(navController = navController , startDestination = DestinationScreen.SignUp.route)
    {
        composable(DestinationScreen.SignUp.route){
            SignUpScreen(navController,vm)
        }
        composable(DestinationScreen.LogIn.route){
            LoginScreen(navController,vm)
        }
    }

}