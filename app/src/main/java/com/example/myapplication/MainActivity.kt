package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                Box(modifier = Modifier.fillMaxSize()) {
                    // Image
                    Image(
                        painter = painterResource(id = R.drawable.spices), //locates image source
                        contentDescription = null, //description of image.      // (Loading Images - everything you need to know - Jetpack Compose #7, 2024)
                        modifier = Modifier.fillMaxSize(), //Makes the image cover the screen
                        contentScale = ContentScale.Crop //Scales the image to fit the full screen
                    )


// variable which collects data from the text field
                    var timeOfDay by remember {
                        mutableStateOf("")
                    }

                    //meal stores the responses from the if statements
                    var meal by remember {
                        mutableStateOf("Good day Hera")
                    } //(Part 4 - Add functionality to buttons.mp4, 2025)

//Function which runs the if statements to compare the input of the
// user (timeOfDay) to the strings in the if statements
                    fun mealPlan(): String { //W3Schools, 1999
                        if (timeOfDay.lowercase() == "morning") {
                            return "Bacon, eggs and toast with a cup of coffee"
                        }
                        if (timeOfDay.lowercase() == "mid-morning") {
                            return "Yogurt with fruits inside"
                        }
                        if (timeOfDay.lowercase() == "afternoon") {
                            return "A ham and cheese sandwich with  glass of apple juice"
                        }
                        if (timeOfDay.lowercase() == "mid-afternoon") {
                            return "A packet of chips"
                        }
                        if (timeOfDay.lowercase() == "dinner") {
                            return "Rice, beetroot, green salad with soup and steak"
                        }
                        else { //If nothing or the wrong input is entered
                            return "Invalid input. Please enter: morning/mid-morning/afternoon/mid-afternoon/dinner" //this message will be displayed
                        }

                    }


Box (modifier = Modifier
    .fillMaxSize()
    .border( //Focuses on the border of the display
        shape = RoundedCornerShape(9.dp), //Gives rounded corners
        width = 5.dp, //width
        color = Color.White// and color to thr border
    )
    .background(Color.Black.copy(alpha = 0.2f)), //Gives a layer of black with low opacity on top of the image
    contentAlignment = Alignment.Center, //Centers the box
//(Microsoft Copilot, 2023 )
    ) {

    Text(
        text = "Welcome to", // Part of the heading with
        color = Color.White, //color,
        fontSize = 70.sp, // a big font size,
        fontFamily = FontFamily.Cursive, //cursive writing
        modifier = Modifier.offset(y = (-350).dp)
    ) // and a higher placement

    Text(
        text = "Plate Up", //The name of the app with
        color = Color.White, //color,
        fontSize = 150.sp,// a big font size,
        fontFamily = FontFamily.Cursive, //cursive text
        modifier = Modifier.offset(y = (-200).dp)
    ) //and a bit less height than the first part of the heading


    Column(
        modifier = Modifier
            .background(Color.Black.copy(alpha = 0.7f)) //Gives color to the column box in the middle of the screen
            .border(
                shape = RoundedCornerShape(9.dp), //rounds the corners of the border
                width = 5.dp, //gives width and
                color = Color.White // and color to the border
            ),
        horizontalAlignment = Alignment.CenterHorizontally,//centers the column horizontally
        verticalArrangement = Arrangement.Center//and vertically on the screen
        ) {

        //A text just asking the user for the time of day
        Text(
            text = "What's the time of Day",
            color = Color.White, //Gives color
            fontSize = 50.sp, //a bigger size
            fontFamily = FontFamily.Cursive //and a cursive style to the text

        )

        //An input field for the user's time of day
        TextField(
            textStyle = TextStyle(fontSize = 30.sp), //Gives the font a bigger size
            modifier = Modifier
                .offset(y = (10).dp), //and moves then input field a little lower


            value = timeOfDay, //The time of day entered in the input field is stored in the  timeOfDay variable
            onValueChange = { timeInput ->
                timeOfDay = timeInput
                    //(Part 5 - TextField.mp4, 2025)
            }
        )

        Row(
            modifier = Modifier.offset(y = (50).dp), //Moves the row block a little lower

        ) {

            //Button used to submit the time of day input
            Button(
                colors = ButtonDefaults.buttonColors(Color.Blue), //Colors the button,
                shape = RectangleShape, //gives the button a rectangular shape,
                modifier = Modifier
                    .width(150.dp) //increases the width of thr button
                    .alpha(0.7f) //decreases opacity
                    .padding(2.dp), //and creates space around the button

                onClick = {
                    meal = mealPlan()
                }) //When clicked, the button will run the mealPlan function, and run the Time of day entered through the if statements
            {

                //The text on the button containing:
                Text(
                    color = Color.Black, //a black color,
                    fontSize = 35.sp, //a bigger font size,
                    fontFamily = FontFamily.Cursive, //cursive font style,
                    fontWeight = FontWeight.Bold, //bold text
                    modifier = Modifier.alpha(1f), //and a high opacity
                    text = "Submit"
                )
            }

            //A button which resets the input and the results given. The styling here is the same as the first button
            Button(
                colors = ButtonDefaults.buttonColors(Color.Blue),
                shape = RectangleShape,
                modifier = Modifier
                    .width(150.dp)
                    .alpha(0.7f)
                    .padding(2.dp),
                onClick = {
                    timeOfDay = "" //when clicked the button will clear the input field
                    meal = "Good day Hera" //and take the meal variable back to its original state
                }) {
                Text( //The styling on this button is the same as the first button
                    color = Color.Black,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    text = "Reset"
                ) //(Button Composable.mp4)
            }
        }

        Box(contentAlignment = Alignment.Center
            ) {
            Text(
                text = meal, //This text displays the meal suggestions according to the time of day entered, with
                color = Color.White, //white text
                fontSize = 50.sp, //a bigger text
                fontFamily = FontFamily.Cursive, //cursive writing
                modifier = Modifier.offset(y = (180).dp, x = (10).dp)//and is lowered
            )
        }


    }
}

                    //Test Logs:
                    /*
                    * Test 1: Tested to see of the image added would display on the emulator - the image did display properly
                    * Test 2: Created the timeOfDay variable and used hard coded input to test the if statements - later added the else statement for error handling
                    * Test 3: Added a TextField and button, removed the hard coded input from the timeOfDay variable and tested if the input in the TextField will be read by the if statements
                    * Test 4: Made the first button a submit button and used it to submit the input from the TextField to the timeOfDay variable
                    * Test 5: Made a new variable (meal) which stores the results from the if statements based on the users input
                    * Test 6: Made a Text composable which displays the results stored in the meal variable
                    * Test 7: Made the reset button which needs to clear the TextField of any text and revert the meal variable to its original state
                    * */







                }

        }
    }
}
