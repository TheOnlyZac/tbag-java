JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Format.java \
	Console.java \
	BaseObject.java \
	Actor.java \
	Room.java \
	Tbag.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class