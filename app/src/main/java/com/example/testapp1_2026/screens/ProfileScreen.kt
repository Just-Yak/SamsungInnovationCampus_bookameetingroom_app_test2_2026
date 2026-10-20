package com.example.testapp1_2026.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.example.testapp1_2026.R
import com.example.testapp1_2026.components.ShowProfileField
import com.example.testapp1_2026.ui.theme.White



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    val fraction = scrollBehavior.state.collapsedFraction

    var isEditable by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .padding(),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "Username",
                        fontSize = lerp(24.sp, 20.sp, fraction),
                        color = Color.White,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White,
                        )
                    }
                },
                actions = {
                  IconButton(onClick = {}) {
                      Icon(
                          Icons.AutoMirrored.Filled.Logout,
                          contentDescription = "Logout",
                          tint = Color.White,
                      )
                  }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Blue,
                ),
                scrollBehavior = scrollBehavior
            )
        },
        containerColor = Color.White
    ) {
        padding -> Box(modifier = Modifier.fillMaxWidth()){
            Image(
                painter = painterResource(R.drawable.ProfilePicture),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .alpha(1f - fraction),
            )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            ShowProfileField("Number", "88005353535", isEditable = isEditable)
            ShowProfileField("Email", "email@gmail.com", isEditable = isEditable)
            ShowProfileField("Info", "info", isEditable = isEditable)
        }
        FloatingActionButton(onClick = {},
            containerColor = Color.Cyan,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.TopEnd)
                .alpha(1f - fraction)
                .offset(x = (-16.dp), y = 150.dp)
        ){
//            Icon(Icons.Default.CameraAlt, contentDescription = "ProfilePicture", tint = Color.White)
        }
    }
    }
}

@Preview(showBackground = true, name = "Profile")
@Composable
fun ShowProfile(){
    MaterialTheme{
        ProfileScreen()
    }
}
