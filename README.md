This is a group project that are made for CME1252 Project Based Learning-II class at first year of computer engineering department at Dokuz Eylul University. 19-04-2019

Group Members:

    Alim ULAŞ - https://github.com/alimulas
    Ömer Batuhan TUNÇER - https://github.com/omertuncer
    

The aim of the project is to develop a game in which players  try to reach the target number in limited time.

# General Information
Game is played with two players: human player and computer. A random target number between 100-999 is determined initially. Players will try to reach/approach this target number in 30 seconds. Players use five random small numbers between 1-9, and one big random number (25, 50, 75 or 100) and 4 basic operations (* / + -) to reach this target.

Game Playing Rules/Stages:

    1. Target number is chosen randomly (100-999). 
    2. Five small numbers are chosen randomly (1-9). 
    3. One big number is chosen randomly (25/50/75/100). 
    4. 30-second countdown starts.
    5. During this time, human player makes calculations in his mind or with pen and paper. Computer tries to
       reach the target by using random operations with randomly chosen numbers.
    6. Rules for operations:
         * Players can use each number only once (given or calculated).
         * Players do not have to use all the numbers.
         * For division operation, integer division will be used. 
         * If parenthesis are not used, multiplication and division have higher priority. Operations which have the
           same priority are calculated from left to right. 
    7. When the time is up, players will announce their result numbers.
    8. The player with the closest number explains how he reached this number.
    9. If the explanation is correct, he gets the point; if it is wrong, then his opponent gets that point.
    10. The one who reaches 100 points first wins the game.

# Explanation of the Operations
If the human is the closest to the target number, he enters an infix expression. This expression must first be transformed to postfix expression, then this postfix expression must be evaluated. Stages of the transformation/evaluation must be shown on the screen step by step. If the computer player is the closest to the target number, it displays each operation used on the screen. 

# Scoring

If the difference is less than or equals to 10; point = 15 - Abs(TargetNumber - CalculatedNumber)
If the difference is greater than 10; point = 5

