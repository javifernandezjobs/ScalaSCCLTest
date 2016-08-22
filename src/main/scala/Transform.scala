import java.io.{BufferedInputStream, FileInputStream}
import java.util.zip.GZIPInputStream

import scala.collection.mutable.ListBuffer
import scala.io.Source.fromInputStream

/**
  * Created by jfernviv on 14/08/2016.
  */
object Transform {
  def toValidSQLValues(extractedData: List[Seq[String]]) : List[List[String]] = {
    val result= new ListBuffer[List[String]]()
    //Store each line in the result
    for (line <- extractedData) {
      val validLine= new ListBuffer[String]()
      //Check that each field have the expected format, otherwise apply expected format
      if(line(RawFieldsPos.vendor_id).isEmpty){
        validLine += "N/A"
      }else{
        validLine += line(RawFieldsPos.vendor_id)
      }
      result += validLine.toList
    }
    println ("Transformation to SQL values done")

    //Return result converted to list, every item is a line.
    result.toList
  }
}
