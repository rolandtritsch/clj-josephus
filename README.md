JOSEPHUS PROBLEM SOLVER
=================

This program solves the Josephus Problem.

Just run ...

> mvn clojure:repl

... from the command line and change the namespace to ...

user=> (ns org.tritsch.josephus)

You can now run the algorithm by invoking solve with 
40 soldiers (plus Josephus) and assuming that you kill
every 3rd soldier ...

org.tritsch.josephus=> (solve 41 3)

... you will see that you have to be soldier number 31 
to survive.

You can also run ...

> mvn clean clojure:compile package

... to build a jar and use ...

> java -jar target/josephus-1.0.0-SNAPSHOT.jar 41 3

... to run the alogorithm.
