package com.example.letterboxclone.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
        Divider(modifier = Modifier.fillMaxWidth(), color = BottomBarColor.copy(alpha = 0.2f))

        Row(modifier = Modifier.fillMaxWidth().clickable {

        }) {
            Text(
                text = stringResource(id = R.string.sign_in),
                modifier = Modifier.padding(12.dp),
                color = TextGray
            )
        }

        Divider(
            modifier = Modifier
                .padding(
                    start = 12.dp
                )
                .fillMaxWidth(), color = BottomBarColor.copy(alpha = 0.4f)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.create_account),
                modifier = Modifier.padding(12.dp),
                color = TextGray
            )
        }

        Divider(
            modifier = Modifier
                .padding(
                    start = 12.dp
                )
                .fillMaxWidth(), color = BottomBarColor.copy(alpha = 0.4f)
        )

        Row(modifier = Modifier.fillMaxWidth()) {

            Text(
                text = stringResource(id = R.string.open_the_tour),
                modifier = Modifier.padding(12.dp),
                color = TextGray
            )
        }

        Divider(modifier = Modifier.fillMaxWidth(), color = BottomBarColor.copy(alpha = 0.2f))

    }

}

@Composable
fun ImageLogo(modifier: Modifier, @DrawableRes id: Int) {
    Image(painterResource(id = id), contentDescription = "logo", modifier = modifier)
}
