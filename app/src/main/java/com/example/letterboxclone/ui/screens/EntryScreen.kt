package com.example.letterboxclone.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.letterboxclone.R
import com.example.letterboxclone.domain.Constants
import com.example.letterboxclone.ui.composables.BottomBar
import com.example.letterboxclone.ui.composables.ImageLogo
import com.example.letterboxclone.ui.composables.ImageWithFade
import com.example.letterboxclone.ui.composables.LoginOptions
import com.example.letterboxclone.ui.theme.TextGray
import com.example.letterboxclone.ui.vm.LoginViewModel


@Composable
fun EntryScreen(navController: NavController) {
    val viewModel: LoginViewModel = hiltViewModel()

    Scaffold(
        bottomBar = { BottomBar() }
    ) { paddingValues ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {

            val (image, logo, loginOptions, artwork) = createRefs()
            val currentBackdrop by viewModel.currentBackdrop.observeAsState()
            val currentTitle by viewModel.currentTitle.observeAsState()

            if (currentBackdrop != null) {
                ImageWithFade(
                    modifier = Modifier.constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                    url = Constants.IMAGE_BASE + currentBackdrop
                )
            }

            ImageLogo(
                modifier = Modifier
                    .constrainAs(logo) {
                        top.linkTo(image.bottom, margin = (-24).dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .height(150.dp),
                id = R.drawable.logo
            )

            LoginOptions(
                modifier = Modifier.constrainAs(loginOptions) {
                    top.linkTo(logo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            currentTitle?.let { title ->
                ArtworkMessage(
                    movieName = title,
                    modifier = Modifier.constrainAs(artwork) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                )
            }
        }
    }
}

@Composable
fun ArtworkMessage(movieName: String, modifier: Modifier) {
    Row(modifier = modifier.padding(vertical = 12.dp)) {
        Text(
            text = stringResource(id = R.string.artwork), color = TextGray, fontSize = 12.sp
        )
        Spacer(modifier = modifier.size(2.dp))
        Text(
            text = movieName,
            modifier = Modifier,
            color = TextGray,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}