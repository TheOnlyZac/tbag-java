# Compiler and compileflags
JC = javac
CFLAGS = -g
JAR = jar
JFLAGS = cfm tbag.jar

# Clear default targets for building .class files from .java files
.SUFFIXES: .java .class

# Set target entry for building .class from .java (format is DSTS:rule)
.java.class:
	$(JC) $(CFLAGS) $*.java

# Make class files from java files
CLASSES = Format.java Console.java BaseObject.java \
	Item.java Actor.java Scene.java Game.java Editor.java

default: game

classes: $(CLASSES:.java=.class)

# Build jar file from classes with manifest

editor: classes
	$(RM) Manifest.txt
	echo Main-Class: Editor >> Manifest.txt
	$(JAR) $(JFLAGS) Manifest.txt *.class

game: classes
	$(RM) Manifest.txt
	echo Main-Class: Game >> Manifest.txt
	$(JAR) $(JFLAGS) Manifest.txt *.class

# Clean up compiled files from the directory
clean:
	$(RM) *.class
	$(RM) *.jar
	$(RM) Manifest.txt