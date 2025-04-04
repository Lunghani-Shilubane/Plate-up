# Plate up

## Waht is Plate up
Plate up is a food suggestion app.
The point of the app is to give food suggestions to make meal planning so much easier, no more need to take countless hours deciding on what to eat. All that is made easy through this app.
The app uses a users input of the time of the day and stores that input in a varibale called "timeOfDa"y. That time of day is then taken through a series of if statements to find one that matches with the user's input. Once a match is found, that result gets stored in a variable called "meal". The result stored within the "meal" variable is then displayed on the screen for the user to see. Keep in mind that the ""meal varible is a state variable, meaning that it is awaiting changes submitted from the users input.
If a user does submit an unplanned input, the "timeOfDay" variable will take in that input, run it through the different if statement, and with no luck there, it will reach the else statement which will display an error to the user and also what should be in the input of the user.

In short: When the user types either morning, mid-morning, afternoon, mid-afternoon or dinner, there will be a meal plan displayed, different meal plans for different times of the day

## How Github and Github Actions were used

### Github:

The project was pushed to a Github repository using the git in the command line

### Github Actions:

