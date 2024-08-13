package com.example.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
        setContent {
            ProfileCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    profileScreen(
                        painter = painterResource(R.drawable.download),
                        name = "Rizwan Ahmed",
                        title = "Android Intern"
                    )
                }
            }
        }
    }
}

@Composable
fun profileScreen(painter: Painter, name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .height(150.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = name,
            fontSize = 34.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        profile(
            phone = "0310-2617300",
            share = "@AndroidDev.com",
            email = "rizwahahmed41@gmail.com",
            icon = painter
        )
    }
}

@Composable
fun profile(icon: Painter, phone: String, share: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.height(300.dp).padding(start = 50.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(R.drawable.baseline_phone_24),
                contentDescription = "Phone Icon",
                tint = Color.DarkGray
            )
            Text(text = phone, color = Color.DarkGray, modifier = Modifier.padding(start = 8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(R.drawable.baseline_share_24),
                contentDescription = "Share Icon",
                tint = Color.DarkGray
            )
            Text(text = share, color = Color.DarkGray, modifier = Modifier.padding(start = 8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(R.drawable.baseline_email_24),
                contentDescription = "Email Icon",
                tint = Color.DarkGray
            )
            Text(text = email, color = Color.DarkGray, modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileCardTheme {
        profileScreen(
            painter = painterResource(R.drawable.baseline_photo_camera_24),
            name = "Rizwan",
            title = "Android Intern"
        )
    }
}
