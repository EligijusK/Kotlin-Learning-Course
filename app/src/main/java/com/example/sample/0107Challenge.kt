package com.example.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.red30.R
import com.example.red30.compose.ui.theme.Red30TechTheme

@Composable
fun Challenge0107(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .height(90.dp)
                        .width(90.dp)
                        .padding(4.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(R.mipmap.ic_launcher_foreground), // R means res which is resource
                    contentDescription = stringResource(R.string.logo),
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = stringResource((R.string.tagline)),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource((R.string.about_header_label)),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge,
                    color = colorResource(R.color.md_theme_outline),
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                    ),
                    text = stringResource((R.string.about_content)),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start,
                    color = colorResource(R.color.md_theme_outline),
                    lineHeight = 15.sp,
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun Challenge0107Preview() {
    Red30TechTheme {
        Challenge0107()
    }
}
