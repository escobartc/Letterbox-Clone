package com.example.letterboxclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.letterboxclone.domain.Constants
import com.example.letterboxclone.ui.composables.BottomBar
import com.example.letterboxclone.ui.composables.ImageLogo
import com.example.letterboxclone.ui.composables.ImageWithFade
import com.example.letterboxclone.ui.composables.LoginOptions
import com.example.letterboxclone.ui.theme.LetterboxCloneTheme
import com.example.letterboxclone.ui.theme.TextGray
import com.example.letterboxclone.ui.vm.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LetterboxCloneTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    bottomBar = { BottomBar() }
                ) { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ConstraintLayout {
                            val (image, logo, loginOptions, artwork) = createRefs()
                            val currentBackdrop by viewModel.currentBackdrop.observeAsState()
                            val currentTitle by viewModel.currentTitle.observeAsState()

                            currentBackdrop?.let { backdropPath ->
                                ImageWithFade(modifier = Modifier.constrainAs(image) {
                                    top.linkTo(parent.top)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                }, url = Constants.IMAGE_BASE + backdropPath)
                            }

                            ImageLogo(modifier = Modifier.constrainAs(logo) {
                                top.linkTo(image.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            })
                            LoginOptions(modifier = Modifier.constrainAs(loginOptions) {
                                top.linkTo(logo.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            })
                            currentTitle?.let { title ->
                                ArtworkMessage(title, modifier = Modifier.constrainAs(artwork) {
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    bottom.linkTo(parent.bottom)
                                })
                            }
                        }

                    }
                }
            }
        }
        hideSystemBars()
    }

    private fun hideSystemBars() {
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController?.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController?.hide(WindowInsetsCompat.Type.systemBars())
    }
}

@Composable
fun ArtworkMessage(movieName: String, modifier: Modifier) {
    Row(modifier = modifier.padding(vertical = 12.dp)) {
        Text(text = stringResource(id = R.string.artwork), color = TextGray)
        Spacer(modifier = modifier.size(2.dp))
        Text(text = movieName, modifier = Modifier, color = TextGray, fontWeight = FontWeight.Bold)
    }
}