package aritra.seal.mychatapp

import android.health.connect.datatypes.ExerciseRoute
import androidx.navigation.NavController

fun navigateTo(navController: NavController,route: String)
{
    navController.navigate(route){
        popUpTo(route)
        launchSingleTop= true
    }
}