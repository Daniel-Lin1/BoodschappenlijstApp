name := """play-java-jpa"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  javaJpa,
  cache,
  javaWs,
  "org.hibernate" % "hibernate-core" % "5.2.12.Final",
  "mysql" % "mysql-connector-java" % "6.0.5"
)

libraryDependencies ++= Seq(
  "com.adrianhurt" %% "play-bootstrap" % "1.2-P26-B4"
)

libraryDependencies += "com.h2database" % "h2" % "1.4.192"
libraryDependencies += guice

javaOptions in Test += "-Dconfig.file=conf/application.test.conf"