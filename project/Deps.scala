import sbt._
import Keys._

object Deps {
  val ScalaVersion = "2.12.4"
  val AkkaVersion = "2.5.6"
  val PlayVersion = "2.6.6"

  val KafkaClients = "org.apache.kafka" % "kafka-clients" % "1.0.0"
  val KafkaStreams =  "org.apache.kafka" % "kafka-streams" % "1.0.0"
  val AkkaActor = "com.typesafe.akka" %% "akka-actor" % AkkaVersion
  val PlayJson = "com.typesafe.play" %% "play-json" % PlayVersion
  val Avro = "org.apache.avro"  %  "avro"  %  "1.8.2"
}
