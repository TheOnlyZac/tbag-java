JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Console.java \
	BaseObject.java \
	Tbag.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class