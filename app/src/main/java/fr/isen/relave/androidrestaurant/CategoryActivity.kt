package fr.isen.relave.androidrestaurant

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.relave.androidrestaurant.ui.theme.AndroidERestaurantTheme
import androidx.compose.foundation.lazy.items

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val category = intent.getStringExtra("category")

        val food_list: Array<String> = when (category) {
            "Entrées" -> resources.getStringArray(R.array.entrees)
            "Plats" -> resources.getStringArray(R.array.plats)
            "Desserts" -> resources.getStringArray(R.array.desserts)
            else -> {
                println("Categorie indisponible")
                emptyArray()
            }
        }

        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        HeaderTitleCategory("$category")

                        FoodCards(food_list){
                                food_name -> selectFood(food_name)
                        }
                    }
                }
            }
        }
    }

    fun selectFood(food_name: String){
        val intent = Intent(this, FoodActivity::class.java).apply {
            putExtra("food_name", food_name)
        }

        this.startActivity(intent)
    }
}

@Composable
fun FoodCards(food_list: Array<String>, selectFood: (String) -> Unit) {
    LazyColumn {
        items(food_list) { food_name ->
            Button(onClick = { selectFood(food_name) },
                modifier = Modifier.padding(
                    top = 20.dp,
                )
            ) {
                Text(
                    text = "$food_name",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun HeaderTitleCategory(category: String) {
    Column(
        modifier = Modifier.padding(
            top = 25.dp,
            bottom = 30.dp
        )
    ) {
        Text(
            text = "$category",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.End
        )
    }
}