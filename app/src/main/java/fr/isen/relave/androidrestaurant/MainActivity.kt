package fr.isen.relave.androidrestaurant

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.isen.relave.androidrestaurant.ui.theme.AndroidERestaurantTheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.text.font.Font
import androidx.compose.material3.Divider
import androidx.compose.foundation.clickable
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        HeaderTitle()
                        MainNav{
                            category -> selectCategory(category)
                        }
                    }
                }
            }
        }
    }

    fun showToast(category: String){
        Toast.makeText(
            this,
            "Catégorie: $category",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun selectCategory(category: String){
        showToast(category)

        val intent = Intent(this, CategoryActivity::class.java).apply {
            putExtra("category", category)
        }

        this.startActivity(intent)
    }
}

@Composable
fun DividerNav(modifier: Modifier = Modifier){
    Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp, modifier = Modifier.width(200.dp))
}

@Composable
fun NavText(category: String, selectCategory: (String) -> Unit) {
    Text(
        text = category,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 35.sp,
        fontFamily = FontFamily.Serif,
        modifier = Modifier.clickable {
            selectCategory("$category")
        }
    )
}

@Composable
fun MainNav(selectCategory: (String) -> Unit){
    Column (
        modifier = Modifier.padding(top = 45.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavText("Entrées", selectCategory)
        Spacer(modifier = Modifier.height(20.dp))
        DividerNav()
        Spacer(modifier = Modifier.height(20.dp))

        NavText("Plats", selectCategory)
        Spacer(modifier = Modifier.height(20.dp))
        DividerNav()
        Spacer(modifier = Modifier.height(20.dp))

        NavText("Desserts", selectCategory)
    }
}

@Composable
fun HeaderTitle(modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = modifier.padding(
                top = 20.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 20.dp
            )
        ) {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Bienvenue\nchez",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.End
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "DroidRestaurant",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.magicspark)),
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = null,
                modifier = Modifier
            )
        }
    }
}