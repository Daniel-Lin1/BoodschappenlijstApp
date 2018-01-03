import play.sbt.PlayJava

resolvers += Resolver.url("Typesafe Ivy releases", url("https://repo.typesafe.com/typesafe/ivy-releases"))(Resolver.ivyStylePatterns)

name := """play-java-jpa"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJpa,
  cache,
  javaWs,
  "org.hibernate" % "hibernate-entitymanager" % "5.2.5.Final" exclude("dom4j", "dom4j"),
  "mysql" % "mysql-connector-java" % "6.0.5",
  "com.adrianhurt" %% "play-bootstrap" % "1.1.1-P25-B4",
"dom4j" % "dom4j" % "1.6.1" intransitive()
)

libraryDependencies += evolutions

fork in run := true

javaOptions in Test += "-Dconfig.file=conf/application.test.conf"