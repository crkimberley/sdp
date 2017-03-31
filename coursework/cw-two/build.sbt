name := """Coursework Two - Virtual Machine"""

version := "1.0"

scalaVersion := "2.12.1"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// Add this for error logging - provides default logger
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.22"

// Need to pull this in for reflective capabilities.
libraryDependencies <+= scalaVersion("org.scala-lang" % "scala-compiler" % _)

// This includes the instructor source directory for compilation.
unmanagedSourceDirectories in Compile += baseDirectory.value / "src/instructor/scala"