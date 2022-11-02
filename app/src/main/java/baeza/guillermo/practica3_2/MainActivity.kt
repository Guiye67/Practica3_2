package baeza.guillermo.practica3_2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import baeza.guillermo.practica3_2.ui.theme.Practica3_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica3_2Theme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyImagenTwitter()
                    MyImagen()
                    Separador()
                    MyPerfil()
                }
            }
        }
    }
}

@Composable
fun Separador() {
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview
@Composable
fun MyImagenTwitter(){
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Button(
            onClick = {  },
            modifier = Modifier
                .clip(CircleShape),
            contentPadding = PaddingValues(
                start = 0.dp,
                top = 0.dp,
                end = 0.dp,
                bottom = 0.dp
            )
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.pluma
                ),
                contentDescription = "Escribir",
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

@Composable
fun MyImagen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.paisaje
            ),
            contentDescription = "Paisaje"
        )
    }
}

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun MyPerfil(){
    var nombre by remember { mutableStateOf("Nombre") }
    var descripcion by remember { mutableStateOf("Descripcion") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 40.dp)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.persona
            ),
            contentDescription = "Icono",
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Column(modifier = Modifier
            .width(170.dp)
        ) {
            Text(
                text = nombre,
                fontSize = 15.sp
            )

            Text(
                text = descripcion,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Icon",
            tint = Color.Red,
            modifier = Modifier.size(20.dp),
        )
        Text(text = "62")
    }

    Separador()

    var name by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }
    val maxChar = 50
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                if(it.length <= maxChar){
                    name = it
                }
            },
            label = { Text(text = "Nombre")},
            placeholder = {Text(text = "Introduce tu nombre")},
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Text(
            text = "${name.length} / $maxChar",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 40.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(
            value = desc,
            onValueChange = {
                if(it.length <= maxChar){
                    desc = it
                }
            },
            label = { Text(text = "Descripción")},
            placeholder = {Text(text = "Introduce la descripción")},
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Text(
            text = "${desc.length} / $maxChar",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 40.dp)
        )

        Separador()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 40.dp),
            horizontalAlignment = Alignment.End
        ) {
            Button(
                onClick = {
                    nombre = name
                    descripcion = desc
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp)
            ) {
                Text(
                    text = "Actualizar",
                    color = Color.White
                )
            }
        }
    }
}
