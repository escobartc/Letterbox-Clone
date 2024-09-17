package com.example.letterboxclone.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.letterboxclone.R
import com.example.letterboxclone.ui.theme.BottomBarColor
import com.example.letterboxclone.ui.theme.TextGray

@Composable
fun LoginOptions(modifier: Modifier) {

    Column(modifier.fillMaxWidth()) {
        Divider(modifier = Modifier.fillMaxWidth(), color = BottomBarColor.copy(alpha = 0.5f))

        Text(
            text = stringResource(id = R.string.sign_in),
            modifier = Modifier.padding(12.dp),
            color = TextGray
        )
        Divider(
            modifier = Modifier
                .padding(
                    start = 12.dp
                )
                .fillMaxWidth(), color = BottomBarColor.copy(alpha = 0.5f)
        )
        Text(
            text = stringResource(id = R.string.create_account), modifier = Modifier.padding(12.dp),
            color = TextGray
        )
        Divider(
            modifier = Modifier
                .padding(
                    start = 12.dp
                )
                .fillMaxWidth(), color = BottomBarColor.copy(alpha = 0.5f)
        )
        Text(
            text = stringResource(id = R.string.open_the_tour), modifier = Modifier.padding(12.dp),
            color = TextGray
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = BottomBarColor.copy(alpha = 0.5f))

    }

}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(painterResource(id = R.drawable.logo), contentDescription = "logo", modifier = modifier)
}
