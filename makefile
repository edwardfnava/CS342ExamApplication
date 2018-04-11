JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Exam.java \
        Question.java \
        Answer.java \
        MCQuestion.java \
				MCSAQuestion.java\
				MCMAQuestion.java\
				SAQuestion.java\
				MCAnswer.java\
				MCSAAnswer.java\
				MCMAAnswer.java\
				SAAnswer.java\
				ScannerFactory.java\
				ExamTaker.java\
				ExamTester.java

default:	classes

classes:	$(CLASSES:.java=.class)

clean:
	$(RM) *.class
