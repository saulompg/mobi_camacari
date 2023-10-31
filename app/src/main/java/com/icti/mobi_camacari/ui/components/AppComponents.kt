package com.icti.mobi_camacari.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.icti.mobi_camacari.R
import com.icti.mobi_camacari.navigation.Screen
import com.icti.mobi_camacari.ui.theme.GrayColor
import com.icti.mobi_camacari.ui.theme.Primary
import com.icti.mobi_camacari.ui.theme.Secondary
import com.icti.mobi_camacari.ui.theme.TextColor

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(
    labelText: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = true
) {

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Primary,
            focusedLabelColor = Primary,
            focusedBorderColor = Primary
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = text,
        onValueChange = {
            text = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
        label = { Text(labelText) },
        isError = !errorStatus
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextFieldComponent(
    labelText: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = true
) {

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Primary,
            focusedLabelColor = Primary,
            focusedBorderColor = Primary
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = text,
        onValueChange = {
            text = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
        label = { Text(labelText) },
        isError = !errorStatus
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneTextFieldComponent(
    labelText: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = true
) {

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Primary,
            focusedLabelColor = Primary,
            focusedBorderColor = Primary
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = text,
        onValueChange = {
            text = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
        label = { Text(labelText) },
        isError = !errorStatus
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(
    labelText: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = true
) {

    var password by remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current

    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = Primary,
            focusedLabelColor = Primary,
            focusedBorderColor = Primary
        ),
        label = { Text(labelText) },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
        trailingIcon = {
            // altera o ícone password ao ser clicado - exibir / ocultar
            val iconImage = if(passwordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            // altera a descrição do ícone password ao ser clicado
            val description = if(passwordVisible) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            // define o botão clicável
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        singleLine = true,
        maxLines = 1,
        value = password,
        onValueChange = {
            password = it
            onTextSelected(it)
        },
        isError = !errorStatus
    )

}

@Composable
fun CheckBoxComponent(onTextSelected : (String) -> Unit, onCheckedChange : (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        var checked by remember { mutableStateOf(false) }
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = !checked
                onCheckedChange.invoke(it)
            }
        )
        ClickableTextComponent(onTextSelected = onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(onTextSelected : (String) -> Unit) {
    val initialText = stringResource(id = R.string.agree)
    val privacyPolicyText = stringResource(id = R.string.privacy_policy)
    val andText = stringResource(id = R.string.and)
    val termsOfUseText = stringResource(id = R.string.terms_and_conditions)

    val annotatedString = buildAnnotatedString {
        append("$initialText ")
        withStyle(
            style = SpanStyle(color = Primary, fontWeight = FontWeight.ExtraBold)
        ) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(" $andText ")
        withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.ExtraBold)) {
            pushStringAnnotation(tag = termsOfUseText, annotation = termsOfUseText)
            append(termsOfUseText)
        }
    }

    // verifica qual a parte do texto que foi clicada
    ClickableText(text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also {span ->
                Log.d("ClickableTermsText", "$span")
                if(span.item == termsOfUseText) {
                    onTextSelected(Screen.TermsAndConditionsScreen.route)
                } else if(span.item == privacyPolicyText) {
                    onTextSelected(Screen.PrivacyPolicyScreen.route)
                }
            }
    }
    )
}

@Composable
fun ButtonComponent(
    value: String,
    onButtonClicked: () -> Unit
) {
    Button(
        onClick = {
            onButtonClicked.invoke()
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
        ) {
            Spacer(modifier = Modifier.widthIn(20.dp))
            Text(
                text = value,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.or),
            fontSize = 18.sp,
            color = TextColor
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLog: Boolean = true, onTextSelected : (String) -> Unit) {

    val initialText = if(tryingToLog) stringResource(id = R.string.have_account) else stringResource(id = R.string.create_account)
    val loginText = if(tryingToLog) stringResource(id = R.string.go_to_sign_in) else stringResource(id = R.string.go_to_register)

    val annotatedString = buildAnnotatedString {
        append(initialText)
        append(" ")
        withStyle(
            style = SpanStyle(color = Primary, fontWeight = FontWeight.ExtraBold)
        ) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    // verifica qual a parte do texto que foi clicada
    ClickableText(
        text = annotatedString,
        onClick = {offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also {span ->
                    Log.d("ClickableLoginText", "$span")
                    if(span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
fun UnderLineTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}