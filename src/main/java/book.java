import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class book {


    public static void main(String[] args) {

        SparkSession session = SparkSession.builder().master("local[2]").appName("get xml")
                .config("spark.executor.memory", "4g").config("spark.driver.allowMultipleContexts", true)
                .getOrCreate();


        Dataset<Row> df  = session.read()
                .format("com.databricks.spark.xml")
                .option("rowTag", "book")
                .load("/books-data/books.xml");

        df.select("author", "_id").
                write().format("com.databricks.spark.xml")
                .option("rootTag", "books")
                .option("rowTag", "book")
                .save("/books-data/newbooks.xml");
    }
}