# Text Based Adventure Game (TBAG)
A text-based game engine written in Java. Currently a work-in-progress.

## Getting Started
From the terminal, do `make` and then run **tbag.jar**

To generate just class files, do `make classes`.

## Classes

### Game
The main game class that keeps track of game objects and will eventually the flow of the story.

### Editor
An AWT interface that will eventually be used for creating/editing scenes in the story. It currently offers a rough preview of some test objects. The interface is comprised of a room/object heirarchy on the left, an inspector on the right, and a (currently) empty resizable space in between. 

### BaseObject
The base class for all game objects. Actor, Item, and Container are extensions of BaseObject that are specialized to serve various purposes to the story.

### Room
An iterable object that can store BaseObjects (and its subclasses) within.

### Format
Used for string formatting, such as adding 'a' or 'an' to the front of a noun or fixing capitalization/punctuation in a sentence.

### Console
Responsible for printing story events and debug messages to the console. Currently prints directly to terminal, but will eventual be contained within its own stylable window.