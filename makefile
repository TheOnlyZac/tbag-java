# Compiler and compileflags
JC = javac
CFLAGS = -g
JAR = jar
JFLAGS = cfm tbag.jar
MAINCLASS = Tbag

# Clear default targets for building .class files from .java files
.SUFFIXES: .java .class

# Set target entry for building .class from .java (format is DSTS:rule)
.java.class:
	$(JC) $(CFLAGS) $*.java

# Make class files from java files
CLASSES = Format.java Console.java BaseObject.java \
	Item.java Actor.java Room.java Game.java

default: classes

classes: $(CLASSES:.java=.class)

# Make manifest file for JAR with main-class manifest
manifest:
	echo Main-Class: $(MAINCLASS) >> Manifest.txt

# Build jar file from classes with manifest
jar: classes manifest
	$(RM) *.jar
	$(JAR) $(JFLAGS) Manifest.txt $(CLASSES:.java=.class)

editor:
	$(JC) $(CFLAGS) Editor.java

# Clean up compiled files from the directory
clean:
	$(RM) *.class
	$(RM) *.jar
	$(RM) Manifest.txt