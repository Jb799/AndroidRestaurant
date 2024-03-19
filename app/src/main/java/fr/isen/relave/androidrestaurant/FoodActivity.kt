package fr.isen.relave.androidrestaurant

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.relave.androidrestaurant.ui.theme.AndroidERestaurantTheme

class FoodActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val food_name = intent.getStringExtra("food_name")

        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        HeaderTitleFood("$food_name")
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderTitleFood(food_name: String) {
    Column(
        modifier = Modifier.padding(
            top = 25.dp,
            bottom = 30.dp
        )
    ) {
        Text(
            text = "$food_name",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.End
        )
    }
}