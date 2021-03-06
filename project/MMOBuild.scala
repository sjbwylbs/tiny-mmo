import sbt._
import sbt.Keys._

object MMOBuild extends Build {

  lazy val mmo = Project(
    id = "mmo",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "mmo",
      organization := "com.github.mumoshu.mmo",
      version := "0.1-SNAPSHOT",
        scalaVersion := "2.10.2",
      resolvers ++= Seq(
        "Sonatype OSS Snapthots" at "https://oss.sonatype.org/content/repositories/snapshots/"
      ),
      libraryDependencies ++= Seq(
        "com.typesafe.akka" %% "akka-actor" % "2.2.1",
        "com.typesafe.akka" %% "akka-zeromq" % "2.2.1",
        "com.typesafe.akka" %% "akka-agent" % "2.2.1",
        "com.typesafe.akka" %% "akka-slf4j" % "2.2.1",
        "org.scala-lang" % "scala-reflect" % "2.10.2",
        "org.apache.thrift" % "libthrift" % "0.9.0",
        "org.slf4j" % "slf4j-log4j12" % "1.6.6",
        "com.github.tmingos" % "casbah_2.10" % "2.5.0-SNAPSHOT",
        "commons-codec" % "commons-codec" % "1.7",
        "org.scala-stm" %% "scala-stm" % "0.7",
        "com.typesafe.akka" %% "akka-testkit" % "2.2.1" % "test",
        "org.specs2" %% "specs2" % "2.2" % "test",
        "org.mockito" % "mockito-all" % "1.9.0" % "test",
        "org.hamcrest" % "hamcrest-all" % "1.3" % "test"
      ),
      javaSource in Compile <<= (sourceDirectory in Compile)(_ / "thrift/gen-java")
    )
  )
}
