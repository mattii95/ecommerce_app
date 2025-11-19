package com.courrouxdigital.ecommerceapp.presentation.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.error
import coil3.request.fallback
import coil3.request.placeholder
import com.courrouxdigital.ecommerceapp.R

@Composable
fun CustomImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    placeholder: Int = R.drawable.no_image,
    error: Int = R.drawable.no_image,
    fallback: Int = R.drawable.no_image,
    contentDescription: String? = null,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .placeholder(placeholder)
            .error(error)
            .fallback(fallback)
            .build(),
        modifier = modifier,
        contentScale = ContentScale.Crop,
        contentDescription = contentDescription
    )
}
