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

# Java files
CLASSES = Format.java Console.java BaseObject.java \
	Item.java Actor.java Room.java Tbag.java

default: classes

classes: $(CLASSES:.java=.class)

manifest:
	echo Main-Class: $(MAINCLASS) >> Manifest.txt

jar: clean classes manifest
	$(JAR) $(JFLAGS) Manifest.txt $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	$(RM) *.jar
	$(RM) Manifest.txt