# A3

## Assignment 3 - grade 2

Group members:
- Anna Manole

The application is started from App.java. There the game and view objects are instantiated. These are passed into the Player controller that is responsible for the game loop.
In the model the dealer plays according to a set of rules that are created in the RulesFactory class. 
**To modify the way the game is being played, modify the RulesFactory class to create rules to suit your needs.**
Three difficult rules are attached to a dealer: 
- rules for how a game should play out; this means things like showing cards or not, potentially who gets their card first could also be implemented (gamerules package)
- rules for when a dealer should hit (hitrules package)
- rules for who wins on a draw in this implementation (winrules package).

A view interface is implemented by the two types of views that are available: one for Swedish and one for English. The view is responsible for printing the game state to the user and for getting input from the user. The view is also responsible for printing the result of the game.

The observer pattern was used to notify the Player controller when a player (dealer or human player) draws a new card. Here we have a pause after each draw. The view redraws the UI when this happens and prints out the new state of the game, with the new card.

After all the cards have finished being drawn, the whole game state is printed out, including the scores of the players and in the case of the game being over, the winner is printed out.

## Assignment 3 - grade 3

Group members:
- Anna Manole

I implemented a RuleAbstractFactory class to create different combinations of rules for the game. Total of 8 different combinations are possible (3 rule types with 2 possible choices each - 2 x 2 x 2). Only 2 of these combinations are implemented in the game, but the rest can also be creating by combining the different rules. The Game class is parameterized with the RuleAbstractFactory class, so that the rules can be changed at runtime.

The design pattern visitor was used in order to print what rules are used at the start of the game. The interface RuleVisitor visits all the different types of rules. They accept the visitor, as well as the Dealer class, that creates the rules still.

The View interface extents the RuleVisitor interface, so that the view can also print out the rules that are used in the game, by defining abstract methods in the BaseView superclass. The SwedishView and EnglishView classes implement these methods, as well as other abstract methods to suit the language needs.

Some of the arrows in the UML diagram that go from Dealer have been ommitted (associations with the different interfaces for rules).