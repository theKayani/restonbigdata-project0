import java.util.Collections
import scala.collection.mutable.Map
import com.hk.json.Json
import com.hk.json.JsonWriter
import java.io.File

object Commands
{
  lazy val commands: Map[String, String => Any] = {
    Map(
      ("help", (args) => {
        if(args == null || args.trim().isEmpty())
        {
          println("Arguments between '<' and '>' are required whereas '[' and ']' are optional")
          println("Available commands are:")
          println()
          println("\thelp")
          println("\tgive <language> [number]")
          println("\timport <JSON file path>")
          println("\ttest-json [JSON file path]")
          println("\texit")
        }
        else
        {
          if(commands.contains(args))
            commands(args)(null)
          else
          {
            println("Unknown command! Try again?")
            println(s"'$args'")
          }
        }
      }),
      ("give", (args) => {
        if(args == null)
        {
          println("The `give <language> [number]` command is used to retrieve numbers as text.")
          println("For example, to get 20 in english, the command would look like...")
          println("give english 20")
        }
        else
        {
          println("// TODO 'give' command")
        }
      }),
      ("import", (args) => {
        if(args == null)
        {
          println("The `import <JSON file path>` command is used to pull data from a `json` file")
          println("and insert all the rows/records extracted into the database...")
          println("The json file format should look something like...")
          println("{")
          println("\t\"[language]\": {")
          println("\t\t\"[number]\": \"[word]\"")
          println("\t},")
          println("\t...")
          println("}")
        }
        else
        {
          println("// TODO 'import' command")
        }
      }),
      ("test-json", (args) => {
        if(args == null)
        {
          println("The 'test-json [JSON file path]' command reads a json file and spits it back out to the console")
          println("If a file is not specified, it will attempt 'test.json' file at the root.")
        }
        else
        {
          var f: File = new File(args)

          if(!f.exists() || !f.isFile() || !f.canRead())
            f = new File("test.json")

          var sb = new StringBuilder()
          var writer: JsonWriter = Json.writer(System.out)
          writer.setPrettyPrint()
          writer.unsetSlashEscape()

          writer.put(Json.read(f))
          println()
        }
      })
    )
  }
}
