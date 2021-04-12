import java.util.Arrays
import java.nio.charset.StandardCharsets

import com.hk.json.Json
import com.hk.json.JsonObject
import com.hk.json.JsonWriter
import scala.io.Source
import java.io.File
import scala.io.StdIn
import scala.util.matching.Regex
import scala.collection.mutable.Map
import scala.collection.mutable.Stack
import scala.collection.mutable.Queue

object Main
{
  val cmdPattern: Regex = "([\\w-]+)\\s*(.*)".r

  def main(args: Array[String]): Unit = {
    // println()
    // val commands = Map[String, (String) => Any]()
    // commands.put("help", Commands.help)
    val commands = Commands.commands

    println("Hello and Welcome to the show!")
    println("Type a command below! If you don't know try the 'help' command!")
    println("Leave blank or hit 'exit' to 'close'")
    println()

    // Test commands by adding them to the queue
    var cmds = new Queue[String]()
    cmds.enqueue("help java")
    cmds.enqueue("test-json")
    cmds.enqueue("exit")
    // Commands in the queue will execute before control is passed
    // unless exit is called.

    var running = true
    while(running)
    {
      var line: String = null
      if(cmds.isEmpty)
      {
        print("cmd: ")
        line = StdIn.readLine()
      }
      else
      {
        line = cmds.dequeue()
        println(s"cmd: $line")
      }

      if(line != null && !line.trim().isEmpty() && !line.equalsIgnoreCase("exit") && !line.equalsIgnoreCase("close"))
      {
        var mtch = cmdPattern.findAllIn(line).matchData.next()
        var cmd = mtch.group(1)

        if(commands.contains(cmd))
          commands(cmd)(mtch.group(2))
        else
        {
          println()
          println(s"Command Not Found: '$cmd'")
          println("Try again... (or hit close to exit)")
        }
      }
      else
        running = false
      
      println()
    }
    println("Bye!")
    println()
  }
}