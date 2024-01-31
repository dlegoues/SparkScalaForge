package org.personal.sparkscalaforge.application

import org.apache.spark.sql.SparkSession
import org.personal.sparkscalaforge.model.Model._

object Main {

    def main(args: Array[String]): Unit = {

        // // Créer une SparkSession
        val sparkSession = SparkSession.builder.appName("MonApplicationSpark").master("local[*]").getOrCreate()

        // Create SparkConf
        // val conf = new SparkConf().setAppName("local").setMaster("local")
        // val sqlContext = new SQLContext(conf)
        import sparkSession.implicits._
        import org.apache.spark.sql.functions._

        // Read csv
        val path = "data/MoviesOnStreamingPlatforms.csv"
        val csv = sparkSession.read.option("header", true).csv(path)

        // Filter
        val df = csv.filter(col("Rotten Tomatoes") <= "20")
        df.show()

        // Write result
        df.write.format("json").save("target/result.json")

        println("Hello World!")
    }
}