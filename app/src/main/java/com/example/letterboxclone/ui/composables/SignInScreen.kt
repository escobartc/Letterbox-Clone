package com.example.letterboxclone.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.letterboxclone.R

@Composable
fun SignInScreen() {

}

@Composable
fun SignInTo() {
    Column {
        ImageLogo(modifier = Modifier, id = R.drawable.dots)
        Text(text = stringResource(id = R.string.sign_in_to))
    }
}

