package com.example.bettercallsaul.uilayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.bettercallsaul.R
import com.example.bettercallsaul.datalayer.BetterCallSaulModel

@Composable
fun SuccessScreen(betterCallSaulList: List<BetterCallSaulModel>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(7.dp)) {
        items(betterCallSaulList) { betterCallSaul ->
            SuccessCard(betterCallSaul = betterCallSaul)
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SuccessCard(betterCallSaul: BetterCallSaulModel) {

    Card(modifier = Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(3.dp)) {

        Row(
            modifier = Modifier.padding(7.dp)
        ) {
            GlideImage(
                model = betterCallSaul.characterImage,
                contentDescription = "The Simpsons Image",
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(7.dp))

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(

                ) {
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Name: ")
                        }
                        append(text = betterCallSaul.characterName)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Birthday: ")
                        }
                        append(text = betterCallSaul.characterBirthday)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Occupation: ")
                        }
                        append(text = betterCallSaul.characterOccupation)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Status: ")
                        }
                        append(text = betterCallSaul.characterStatus)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Nickname: ")
                        }
                        append(text = betterCallSaul.characterNickname)
                    }
                    )/*
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Appearance: ")
                        }
                        append(text = betterCallSaul.characterAppearance.toString())
                    }
                    )*/
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text =
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.ExtraBold, color = Color.White)) {
                            append(text = "Actor: ")
                        }
                        append(text = betterCallSaul.characterActor)
                    }
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                }
            }

        }

    }

}


@Composable
@Preview(showBackground = true)
fun SuccessCardPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SuccessCard(BetterCallSaulModel(characterId = 0, characterName = "Name", characterBirthday = "05/06/1990", characterOccupation = "Lawyer", characterImage = "${R.drawable.img}", characterStatus = "Alive", characterNickname = "Saul", characterActor = "Stock Photo"))
    }
}