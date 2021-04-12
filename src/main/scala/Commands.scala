import java.util.Collections
import scala.collection.mutable.Map
import com.hk.json.Json
import com.hk.json.JsonWriter
import java.io.File

object Commands {
  lazy val commands: Map[String, String => Any] = {
    Map(
      ("help", (args) => {
        println("oh you need help now?")
      }),
      ("test-json", (args) => {
        var sb = new StringBuilder()
        var writer: JsonWriter = Json.writer(System.out)
        writer.setPrettyPrint()
        writer.unsetSlashEscape()

        writer.put(Json.read(new File("test.json")))
        println()
      })
    )
  }
}
