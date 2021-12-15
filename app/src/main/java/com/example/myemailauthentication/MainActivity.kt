package com.example.myemailauthentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {



    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }
    val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnEmial = findViewById<Button>(R.id.btnEmail)

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        if(FirebaseAuth.getInstance().currentUser == null){
            btnEmial.setOnClickListener {
                signInLauncher.launch(signInIntent)
            }
        }else{
            btnEmial.text ="Sign out"
            btnEmial.setOnClickListener {
                AuthUI.getInstance().signOut(this)
            }
        }
    }
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
        }
        else {
        }
    }
}

//        btn_Emial.setOnClickListener {
//            signInLauncher.launch(signInIntent)
//        }
//            btn_Emial.text ="Sign out"
//            btn_Emial.setOnClickListener {
//                FirebaseAuth.getInstance().signOut()
//            }

// Successfully signed in) {
//         btn_Emial.text ="Sign in"
////            btn_Emial.setOnClickListener {
//////                signInLauncher.launch(signInIntent)
////            }
//    private fun createSignInIntent() {
////        val providers = arrayListOf(
////            AuthUI.IdpConfig.EmailBuilder().build())
////
////        val signInIntent = AuthUI.getInstance()
////            .createSignInIntentBuilder()
////            .setAvailableProviders(providers)
////            .build()
////        signInLauncher.launch(signInIntent)
//    }
//
//
//btn_Emial.setOnClickListener {
//     val signInLauncher = registerForActivityResult(
//        FirebaseAuthUIActivityResultContract()
//    ) { res ->
//        this.onSignInResult(res)
//    }
//    btn_Emial.setOnClickListener {
//        val providers = arrayListOf(
//            AuthUI.IdpConfig.EmailBuilder().build())
//
//        val signInIntent = AuthUI.getInstance()
//            .createSignInIntentBuilder()
//            .setAvailableProviders(providers)
//            .build()
//        signInLauncher.launch(signInIntent)
//    }
//}