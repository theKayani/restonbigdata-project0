import java.util.Arrays
import java.nio.charset.StandardCharsets

import com.hk.json.Json
import com.hk.json.JsonObject
import com.hk.json.JsonWriter
import scala.io.Source
import java.io.File

object Main
{
  def main(args: Array[String]): Unit = {

    var sb = new StringBuilder()
    var writer: JsonWriter = Json.writer(System.out)
    writer.setPrettyPrint();

    writer.put(Json.read(new File("test.json")))

    println()
  }
}