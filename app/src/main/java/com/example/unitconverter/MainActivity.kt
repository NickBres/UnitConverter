package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter(){

    var inputValue by remember {
        mutableStateOf("0")
    }
    var firstUnit by remember {
        mutableStateOf("Select")
    }
    var secondUnit by remember {
        mutableStateOf("Select")
    }
    var menuOne by remember { // shows the first dropdown menu
        mutableStateOf(false)
    }
    var menuTwo by remember {
        mutableStateOf(false)
    }
    var firstMultiplier by remember {
        mutableStateOf(1.0)
    }
    var secondMultiplier by remember {
        mutableStateOf(1.0)
    }




    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontFamily = FontFamily.Monospace
            ),
            modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(64.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {inputValue = it},
            label = { Text(text = "Enter Value") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            )
        Spacer(modifier = Modifier.height(32.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box{

                Button(onClick = { menuOne = !menuOne }) {
                    Text(text = firstUnit)
                    Icon(Icons.Default.ArrowDropDown,"")
                }
                DropdownMenu(expanded = menuOne, onDismissRequest = {  menuOne = !menuOne }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            menuOne = !menuOne
                            firstUnit = "Centimeters"
                            firstMultiplier = 1.0
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            menuOne = !menuOne
                            firstUnit = "Meters"
                            firstMultiplier = 100.0
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            menuOne = !menuOne
                            firstUnit = "Feet"
                            firstMultiplier = 30.48
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Inches") },
                        onClick = {
                            menuOne = !menuOne
                            firstUnit = "Inches"
                            firstMultiplier = 2.54
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "To")
            Spacer(modifier = Modifier.width(8.dp))
            Box{
                Button(onClick = { menuTwo = !menuTwo }) {
                    Text(text = secondUnit)
                    Icon(Icons.Default.ArrowDropDown,"")
                }
                DropdownMenu(expanded = menuTwo, onDismissRequest = {  menuTwo = !menuTwo }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            menuTwo = !menuTwo
                            secondUnit = "Centimeters"
                            secondMultiplier = 1.0
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            menuTwo = !menuTwo
                            secondUnit = "Meters"
                            secondMultiplier = 0.01
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            menuTwo = !menuTwo
                            secondUnit = "Feet"
                            secondMultiplier = 0.0328084
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Inches") },
                        onClick = {
                            menuTwo = !menuTwo
                            secondUnit = "Inches"
                            secondMultiplier = 0.393701
                        }
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(32.dp))
        Text("Result: ${inputValue.toDouble() * firstMultiplier * secondMultiplier}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}