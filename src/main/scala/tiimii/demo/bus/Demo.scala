package tiimii.demo.bus

import java.io.ByteArrayOutputStream

import com.google.protobuf.TextFormat
import tiimii.bus.model.Base

object Demo extends App {
  println("Hello, world")
  val b = Base.SearchRequest.newBuilder().setPageNumber(1)
  val req = b.build()
  println(req)

  val out = new ByteArrayOutputStream()
  val buffer = req.writeTo(out)
  val from = Base.SearchRequest.parseFrom(out.toByteArray)
  if (!from.hasField(Base.SearchRequest.getDescriptor.findFieldByNumber(1))) {
    println("NotSet: Query")
  }
  print("From: " + TextFormat.shortDebugString(from))
}
