# rock-paper-scissors
* This is a simple command-line based version of the game rock-paper-scissors. 
* Possibility to play against the computer, or leave the computer to play against itself.
* The computer has got a random engine and a smarter engine based on http://arstechnica.com/science/2014/05/win-at-rock-paper-scissors-by-knowing-thy-opponent/.
* For each game, specify the number of rounds (1 to 10, or 0 to quit) and the type of game: Human VS Computer, or Computer VS Computer.
* It currently supports 3 moves (rock / paper or scissors), but this can be extended very easily to any number of moves by adding new enum values to Move.

# Usage
* To compile with maven: mvn install
* To run JUnit tests with maven: mvn -Dmaven.test.skip=false install
* To start: java -classpath target/rockpaperscissors-1.0.jar com.coach.rockpaperscissors.RockPaperScissors


# Planned improvements:
* Add a graphical user interface, web-based (program to be translated into javascript) or desktop/swing
* Allow more than 2 players
* Allow the player to choose the available moves directly (3-4 moves or more...)
