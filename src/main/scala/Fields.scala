/**
  * Created by jfernviv on 13/08/2016.
  */
object ProperiesFileName {
  val general = "General.properties"
}

object GeneralProperties {
  val csvSourcePath = "CSV_SOURCE_PATH"
  val dbConnectionDriver = "DB_CONNECTION_DRIVER"
  val dbConnectionConnector = "DB_CONNECTION_CONNECTOR"
  val dbConnectionUser = "DB_CONNECTION_USER"
  val dbConnectionPass = "DB_CONNECTION_PASS"
}

object RawFieldsPos {
  val vendor_id= 0
  val country_description= 1
  val country_code= 2
  val name= 3
  val dob= 4
  val gender= 5
}

object PropertyNames {
  val createRawTable = "CREATE_RAW_TABLE"
  val createCountryTable = "CREATE_COUNTRY_TABLE"
  val createVendorTable = "CREATE_VENDOR_TABLE"
  val alterTableVendor = "ALTER_TABLE_VENDOR"
  val queryGetFirst10 = "QUERY_GET_FIRST_10"
  val queryUniqueNames = "QUERY_UNIQUE_NAMES"
  val queryDecadeDob = "QUERY_DECADE_DOB"
}
