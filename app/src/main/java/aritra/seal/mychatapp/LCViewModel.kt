package aritra.seal.mychatapp

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LCViewModel @Inject constructor(
    val auth : FirebaseAuth
) : ViewModel() {
    init {

    }



    fun SignUp(name : String, number:String , email:String, password: String)
    {
        auth.createUserWithEmailAndPassword(email, password) .addOnCompleteListener {

            if (it.isSuccessful){
                Log.d("Tag","SignUp :User Logged in")

            }
        }
    }
}

