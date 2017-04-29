name := """Coursework Three - Binary Search Trees with Actors"""

version := "1.0"

scalaVersion := "2.10.2" 

libraryDependencies ++= Seq( 
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",  
  "com.typesafe.akka" %% "akka-testkit" % "2.2.3",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "com.ning" % "async-http-client" % "1.7.19",
  "ch.qos.logback" % "logback-classic" % "1.0.7")
