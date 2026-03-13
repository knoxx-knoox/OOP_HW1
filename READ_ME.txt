To test the program we need
-data.txt
-dice_roll.txt
-players.txt
.
So to check diffrent inputs pick a set from one of the case folders case 0 is for default inputs which are already in use.
In each folder after name the condition checked is written
case(index)-(condition) --> folder naming format
So what we give and what we expect;
0-default variant that is already used, expecting the game to and as dice rolls end.
1-dice input wrong,game should never start and should end similar to case 0 but it does not throws a exception just console message since some wrong inputs wont broke the game yet.
2-wrong size given as input, we expect the game to run smoothly since we dont read size we skip it and when we need the size of them we just check size and get the value from there.
3-game that should end by last one standing, the case where we force last one standing condition.
4-long game that takes alot of turns, to check what happens if we have more dice rolls then board size and check what could happen in a really long game.