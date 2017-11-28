import sbt._
import Keys._

object Common {
  val nexusServer = "192.168.1.184"
  val nexus = s"http://$nexusServer:8081/nexus/content/repositories"
  val snapshots = Some("snapshots" at nexus + "/snapshots")
  val releases = Some("Sanyi" at nexus + "/sanyi")
  val auth = Credentials("Sonatype Nexus Repository Manager", nexusServer, "sanyi", "sanyi")

  val publish = Seq(
    publishTo := { if (isSnapshot.value) snapshots else releases },
    credentials += auth
  )

  def init(project: String, isLib: Boolean = false) = {
    Seq(
      organization := "com.tiimii",
      name := project,
      scalaVersion := Deps.ScalaVersion,
      javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8"),
      scalacOptions ++= Seq("-target:jvm-1.8", "-feature", "-language:reflectiveCalls", "-deprecation", "-encoding", "UTF-8"),
      sources in (Compile, doc) := Seq.empty,
      publishArtifact in (Compile, packageDoc) := false,
    ) ++ { if (isLib) publish else Seq.empty }
  }
}
