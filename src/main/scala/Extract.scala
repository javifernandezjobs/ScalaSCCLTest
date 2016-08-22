import java.util.zip.GZIPInputStream

import io.Source.fromInputStream
import java.io.BufferedInputStream
import java.io.FileInputStream

import scala.collection.mutable.ListBuffer
/**
  * Created by jfernviv on 14/08/2016.
  */
object Extract {
  def CSVGZ(filePathName: String) : List[Seq[String]] = {
    val result= new ListBuffer[Seq[String]]()
    //Load file into a buffer
    val bufferedSource = fromInputStream (new GZIPInputStream (new BufferedInputStream (new FileInputStream (filePathName) ) ) )
    //Store each line in the result
    for (line <- bufferedSource.getLines) {
      result += line.split (",").map (_.trim)
//      println (s"${cols (0)}|${cols (1)}|${cols (2)}|${cols (3)}")
    }
    bufferedSource.close
    println ("CSV Sources extracted")
    //Return result converted to list, every item is a line.
    result.toList
  }
}
