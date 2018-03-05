import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class importToHive {
    public static void main(String[] args) {

        SparkSession session = SparkSession.builder().master("local[2]").appName("XML file import to Hive")
                .config("spark.executor.memory", "4g").config("spark.driver.allowMultipleContexts", true)
                .getOrCreate();


        session.sql("CREATE TABLE myxml1 USING com.databricks.spark.xml OPTIONS (path \"/data/xml-files\", rowTag \"gmd:MD_Metadata\")");

    }
}
