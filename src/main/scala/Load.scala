import java.io.{BufferedInputStream, FileInputStream}
import java.util.Properties
import java.util.zip.GZIPInputStream

import scalikejdbc.{AutoSession, ConnectionPool}

import scala.collection.mutable.ListBuffer
import scala.io.Source.fromInputStream

/**
  * Created by jfernviv on 14/08/2016.
  */
import scalikejdbc._
object Load {
  def toSQLH2Database(transformedData: List[List[String]], prop: Properties) : Boolean = {
    //Get connection properties
    val driver= prop.getProperty(GeneralProperties.dbConnectionDriver)
    val connector= prop.getProperty(GeneralProperties.dbConnectionConnector)
    val user= prop.getProperty(GeneralProperties.dbConnectionUser)
    val pass= prop.getProperty(GeneralProperties.dbConnectionPass)

    // Initialize JDBC driver & connection pool
    Class.forName(driver)
    ConnectionPool.singleton(connector, user, pass)
    // Ad-hoc session provider on the REPL
    implicit val session = AutoSession

    //4) Load data to database
    // TODO Replace these queries for the create tables and insert stored inside General.properties.
    sql"""
create table if not exists members (
  id serial not null primary key,
  name varchar(64),
  created_at timestamp not null
)
""".execute.apply()
    
    // TODO Insert transformedData to tables here:
    Seq("Alice", "Bob", "Chris") foreach { name =>
      sql"insert into members (name, created_at) values (${name}, current_timestamp)".update.apply()
    }

    //TODO Execute queries stored inside General.properties:
    // for now, retrieves all data as Map value
    val entities: List[Map[String, Any]] = sql"select * from members".map(_.toMap).list.apply()
    //Close connection.
    ConnectionPool.closeAll()

    println ("All data loaded to database")
    true
  }
}
