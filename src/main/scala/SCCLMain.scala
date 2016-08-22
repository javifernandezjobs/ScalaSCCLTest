/**
  * Created by jfernviv on 11/08/2016.
  */
import java.io.FileInputStream
import java.util.Properties

import scalikejdbc._
object SCCLMain {

  def main(args: Array[String]): Unit = {
    //1) Load property file
    val prop = new Properties()
    prop.load(new FileInputStream(ProperiesFileName.general))

    //2) Extract sources (csv.gz)
    val extractedData = Extract.CSVGZ(prop.getProperty(GeneralProperties.csvSourcePath))

    //3) Transform sources
    val transformedData= Transform.toValidSQLValues(extractedData)

    //4) Load data to H2 database and execute queries:
    Load.toSQLH2Database(transformedData, prop)

/*
    // defines entity object and extractor
    import org.joda.time._

    case class Member(id: Long, name: Option[String], createdAt: DateTime)

    object Member extends SQLSyntaxSupport[Member] {
      override val tableName = "members"

      def apply(rs: WrappedResultSet) = new Member(
        rs.long("id"), rs.stringOpt("name"), rs.jodaDateTime("created_at"))
    }

    // find all members
    val members: List[Member] = sql"select * from members".map(rs => Member(rs)).list.apply()

    // use paste mode (:paste) on the Scala REPL
    val m = Member.syntax("m")
    val name = "Alice"
    val alice: Option[Member] = withSQL {
      select.from(Member as m).where.eq(m.name, name)
    }.map(rs => Member(rs)).single.apply()*/



  }
}
