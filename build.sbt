Common.init("bus-demo")

libraryDependencies ++= Seq(
  Deps.KafkaClients, Deps.AkkaActor, Deps.PlayJson, Deps.Avro
)

enablePlugins(JavaAppPackaging)
enablePlugins(ProtobufPlugin)
