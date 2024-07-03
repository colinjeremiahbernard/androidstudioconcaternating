package com.start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.start.ui.theme.NomeclatureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NomeclatureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val firstNames = arrayOf(
                        "James", "Joseph", "Art", "Len", "Don", "Sima",
                        "Mitsuo", "Leo", "Sage", "Kris", "Minna", "Abe", "Kyle",
                        "Graciela", "Cammi", "Mat", "Mel", "Glad", "Yuki"
                    )
                    val lastNames = arrayOf(
                        "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis",
                        "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas",
                        "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
                        "Martinez"
                    )

                    // Create full names by concatenating first and last names
                    val fullNames = createFullNames(firstNames, lastNames)

                    DisplayFullNames(
                        fullNames,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Function to create full names by concatenating first and last names
fun createFullNames(firstNames: Array<String>, lastNames: Array<String>): Array<String> {
    val minSize = minOf(firstNames.size, lastNames.size)
    return Array(minSize) { index ->
        "${firstNames[index]} ${lastNames[index]}"
    }
}

@Composable
fun DisplayFullNames(names: Array<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        for (name in names) {
            Text(
                text = name,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FullNamesPreview() {
    NomeclatureTheme {
        val firstNames = arrayOf(
            "James", "Joseph", "Art", "Len", "Don", "Sima", "Mitsuo",
            "Leo", "Sage", "Kris", "Minna", "Abe", "Kyle", "Graciela",
            "Cammi", "Mat", "Mel", "Glad", "Yuki"
        )
        val lastNames = arrayOf(
            "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis",
            "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas",
            "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
            "Martinez"
        )

        val fullNames = createFullNames(firstNames, lastNames)

        DisplayFullNames(fullNames)
    }
}
