package com.example.assignment.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.assignment.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostItem(image:Int) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(16.dp)
    ) {


            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.Crop
            )

    }
}