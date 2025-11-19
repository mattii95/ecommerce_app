package com.courrouxdigital.ecommerceapp.presentation.screens.profile.update.components

import android.annotation.SuppressLint
import android.app.Activity
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.courrouxdigital.ecommerceapp.R
import com.courrouxdigital.ecommerceapp.presentation.components.CustomButton
import com.courrouxdigital.ecommerceapp.presentation.components.CustomImage
import com.courrouxdigital.ecommerceapp.presentation.components.CustomTextField
import com.courrouxdigital.ecommerceapp.presentation.components.DialogCapturePicture
import com.courrouxdigital.ecommerceapp.presentation.screens.profile.update.ProfileUpdateViewModel
import com.courrouxdigital.ecommerceapp.presentation.ui.theme.EcommerceAppTheme
import com.courrouxdigital.ecommerceapp.presentation.utils.ImageUtils

@SuppressLint("ContextCastToActivity")
@Composable
fun ProfileUpdateContent(
    modifier: Modifier = Modifier,
    viewModel: ProfileUpdateViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    val state by viewModel.state.collectAsState()
    val user = state.userData

    val stateDialog = remember { mutableStateOf(false) }

    DialogCapturePicture(
        context = context,
        state = stateDialog,
        pickImage = {
            val file = ImageUtils.uriToFile(context, it)
            viewModel.onImageChange(it, file)
        },
        takePhoto = {
            val file = ImageUtils.uriToFile(context, it)
            viewModel.onImageChange(it, file)
        }
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primary
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.weight(1f))
            CustomImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .clickable { stateDialog.value = true },
                imageUrl = state.imageUrl,
                placeholder = R.drawable.placeholder_user,
                fallback = R.drawable.user_image
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ),
            ) {

                Column(
                    modifier = Modifier
                        .padding(30.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    // Name
                    CustomTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        value = user?.name ?: "",
                        onValueChange = { viewModel.onNameChange(it) },
                        label = "Nombre",
                        icon = Icons.Rounded.Person
                    )

                    // Lastname
                    CustomTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        value = user?.lastname ?: "",
                        onValueChange = { viewModel.onLastnameChange(it) },
                        label = "Apellido",
                        icon = Icons.Outlined.Person
                    )

                    // Phone
                    CustomTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 32.dp),
                        value = user?.phone ?: "",
                        onValueChange = { viewModel.onPhoneChange(it) },
                        label = "Telefono",
                        icon = Icons.Rounded.Phone
                    )

                    CustomButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        text = "Confirmar",
                        onClick = {
                            viewModel.update()
                        }
                    )
                }

            }


        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ProfileContentPreview() {
    EcommerceAppTheme {
        ProfileUpdateContent()
    }
}