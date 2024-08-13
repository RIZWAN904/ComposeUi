package com.example.profilecard

import android.graphics.drawable.Icon
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecard.ui.theme.ProfileCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    profileScreen(painter = painterResource(R.drawable.download),name = "Rizwan Ahmed", title = "Android Internee")
                }
            }
        }
    }
}

@Composable
fun profileScreen(painter: Painter,name:String,title:String,modifier: Modifier=Modifier){
    Column ( modifier = Modifier.fillMaxSize()
        ,horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,) {
        Image(painter = painterResource(R.drawable.download),contentDescription = null)
        Text(text = name,
            fontSize = 34.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(16.dp))
        Text(text = title,
            fontSize = 18.sp,
            color = Color.DarkGray)

        profile(phone = "0310-2617300", share = "@AndroidDev.com", email = "rizwahahmed41@gmail.com", icon = painter )


    }

}

@Composable
fun profile(icon: Painter, phone:String, share:String, email: String, modifier: Modifier=Modifier){

    Column (Modifier.height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom){
        Row {
            Icon(painter = painterResource(R.drawable.baseline_phone_24
            ), contentDescription = null,tint = Color.DarkGray)
            Text(text = phone, color = Color.DarkGray,modifier=Modifier.padding(start = 8.dp))
        }
        Row {
            Icon(painter = painterResource(R.drawable.baseline_share_24
            ), contentDescription = null,tint = Color.DarkGray,modifier=Modifier.padding(start = 24.dp))
            Text(text = share, color = Color.DarkGray,modifier=Modifier.padding(start = 8.dp))
        }

        Row {
            Icon(painter = painterResource(R.drawable.baseline_email_24
            ), contentDescription = null, tint = Color.DarkGray)
            Text(text = email, color = Color.DarkGray)
        }


    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileCardTheme {
        profileScreen(painter = painterResource(R.drawable.baseline_photo_camera_24),name = "Rizwan", title = "Android Internee")
    }
}