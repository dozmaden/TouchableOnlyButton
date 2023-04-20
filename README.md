# TouchableOnlyButton Issue

I have a Compose button, which is supposed to be only clicked by a genuine touch interaction (a not by a connected hardware keyboard activation, such as Tap -> Enter). 
Suppose that after a user taps this button an AlertDialog appears.

I check whether it was a genuine touch press by collecting pressedState of InteractionSource and checking it in onClick(). 
It works fine and shows AlertDialog.
However, it is impossible to test this. 

A click made by Jetpack Compose test framework registers 2 PressInteractions (Press and Release), but regardless pressedState never changes and AlertDialog doesn't appear.
Why does this different behaviour occur?
