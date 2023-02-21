package net.heidylazaro.conceptosbasicosdecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.heidylazaro.conceptosbasicosdecompose.ui.theme.ConceptosBasicosDeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConceptosBasicosDeComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    //CuadranteComposeGreeting()
//                    LearnTogetherGreting(titulo = getString(net.heidylazaro.conceptosbasicosdecompose.R.string.titulo_learn_together),
//                        primerparrafo = getString(net.heidylazaro.conceptosbasicosdecompose.R.string.primer_parrafo_learn_together),
//                        segundoparrafo = getString(net.heidylazaro.conceptosbasicosdecompose.R.string.segundo_parrafo_learn_together))
                    TaskGreetingWithImage(frase1 = getString(net.heidylazaro.conceptosbasicosdecompose.R.string.task_complete),
                        frase2 = getString(net.heidylazaro.conceptosbasicosdecompose.R.string.nice_work))
                }
            }
        }
    }
}

@Composable
fun CuadranteComposeGreeting() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            CuadranteComposeIndividualGreeting(
                titulo = stringResource(id = net.heidylazaro.conceptosbasicosdecompose.R.string.text_composable),
                descripcion = stringResource(id = net.heidylazaro.conceptosbasicosdecompose.R.string.text_composable_contenido),
                fondo = Color.Green,
                modifier = Modifier.weight(1f)
                //Modifier = Modifier.background(androidx.compose.ui.graphics.Color.Green)
            )
            CuadranteComposeIndividualGreeting(
                titulo = stringResource(id = net.heidylazaro.conceptosbasicosdecompose.R.string.image_composable),
                descripcion = stringResource(id = net.heidylazaro.conceptosbasicosdecompose.R.string.image_composable_contenido),
                fondo = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            CuadranteComposeIndividualGreeting(
                titulo = stringResource(id = net.heidylazaro.conceptosbasicosdecompose.R.string.row_composable),
                descripcion = stringResource(id = net.heidylazaro.conceptosbasicosdecompose.R.string.row_composable_contenido),
                fondo = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            CuadranteComposeIndividualGreeting(
                titulo = stringResource(id = net.heidylazaro.conceptosbasicosdecompose.R.string.column_composable),
                descripcion = stringResource(id = net.heidylazaro.conceptosbasicosdecompose.R.string.column_composable_contenido),
                fondo = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CuadranteComposeIndividualGreeting(titulo: String, descripcion: String,
                                       fondo: androidx.compose.ui.graphics.Color, modifier: Modifier = Modifier){
    Column(modifier = modifier
        .background(fondo)
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {
        Text(
            text = titulo,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = descripcion,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun LearnTogetherGreting(titulo: String, primerparrafo : String, segundoparrafo: String){
    val image = painterResource(net.heidylazaro.conceptosbasicosdecompose.R.drawable.bg_compose_background)
    Box(){
        Column() {
            Image(
                painter = image,
                contentDescription = null,
            )
            Text(
                text = "$titulo",
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp,
                    bottom = 16.dp, top = 16.dp)
            )
            Text(
                text = "$primerparrafo",
                modifier = Modifier.padding(end = 16.dp, start = 16.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = "$segundoparrafo",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp,
                    bottom = 16.dp, top = 16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}


@Composable
fun TaskGreetingWithText(frase1: String, frase2: String) {
    Text(
        text = "$frase1",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )
    Text(
        text = "$frase2",
        fontSize = 16.sp
    )
}

@Composable
fun TaskGreetingWithImage(frase1: String, frase2: String) {
    val image = painterResource(net.heidylazaro.conceptosbasicosdecompose.R.drawable.ic_task_completed)
    Box() {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
            )
            TaskGreetingWithText(frase1 = frase1, frase2 = frase2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConceptosBasicosDeComposeTheme() {
        //Greeting("Android")
        //CuadranteComposeGreeting()
//        LearnTogetherGreting(titulo = "Andoid Studio", primerparrafo = "Consiste en una plataforma de desarrollo movil",
//            segundoparrafo = "que da soporte a dispositivos con el sistema operativo androdid")
        TaskGreetingWithImage(frase1 = "Hola", frase2 = "Buen trabajo")

    }
}