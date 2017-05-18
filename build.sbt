name := """lazy-json-deserialization-test"""

version := "1.0-SNAPSHOT"


scalaVersion := "2.11.9"


libraryDependencies += "com.typesafe.play" % "play_2.11" % "2.5.14"
libraryDependencies += "org.scalacheck" % "scalacheck_2.11" % "1.13.5"


enablePlugins(JmhPlugin)
