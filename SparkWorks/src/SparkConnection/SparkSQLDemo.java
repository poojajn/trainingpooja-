package SparkConnection;

import static org.apache.spark.sql.functions.avg;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.max;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import com.training.commons.SparkConnection;
import com.training.sparkworks.Department;

public class SparkSQLDemo {
	public static void main(String[] args) {
		Logger.getLogger("org").setLevel(Level.ERROR);
		Logger.getLogger("akka").setLevel(Level.ERROR);
		JavaSparkContext spContext = SparkConnection.getContext();
		SparkSession spSession = SparkConnection.getSession();

		Dataset<Row> empDataFileds = spSession.read().json("./data/customer.json");

		empDataFileds.show();
		empDataFileds.printSchema();

		// data queries
		System.out.println("select Demo");
		empDataFileds.select(col("name"), col("salary")).show();

		// data queries on selection (condition)
		System.out.println("selct Demp with condtion");
		empDataFileds.filter(col("gender").equalTo("male")).show();

		System.out.println("Aggregate-group by gender");
		empDataFileds.groupBy(col("gender")).count().show();

		Dataset<Row> summaryData = empDataFileds.groupBy(col("deptid")).agg(avg(empDataFileds.col("salary")),
				max(empDataFileds.col("age")));
		summaryData.show();

		/// try with bean classes
		Department dpt1 = new Department(100, "Development");
		Department dpt2 = new Department(200, "Testing");
		List<Department> deptList = new ArrayList<>();
		deptList.add(dpt1);
		deptList.add(dpt2);

		Dataset<Row> deptDataFields = spSession.createDataFrame(deptList, Department.class);

		System.out.println("Department contents are");
		deptDataFields.show();

		System.out.println("join Employee  with Dept");
		// Dataset<Row> empDeptJoin = empDataFileds.join(deptDataFields);
		Dataset<Row> empDeptJoin = empDataFileds.join(deptDataFields, col("deptid").equalTo(col("departmentId")));

		empDeptJoin.show();

		System.out.println("join with aggregation ");
		empDataFileds.filter(col("age").gt(30)).join(deptDataFields, col("deptid").equalTo(col("departmentId")))
				.groupBy(col("deptid")).agg(avg(empDataFileds.col("salary")), max(empDataFileds.col("age"))).show();

		// load data from CSV
		// .option("header", "true")
		Dataset<Row> movieData = spSession.read().csv("./data/autoData.csv");
		movieData.show(5);

		// creating RDD with row objects
		Row row1 = RowFactory.create(1, "India", "Bangaluru");
		Row row2 = RowFactory.create(1, "USA", "Reston");
		Row row3 = RowFactory.create(3, "UK", "steevenscreek");
		List<Row> rList = new ArrayList<>();
		rList.add(row1);
		rList.add(row2);
		rList.add(row3);
		JavaRDD<Row> rowRDD = spContext.parallelize(rList);
		StructType schema = DataTypes
				.createStructType(new StructField[] { DataTypes.createStructField("id", DataTypes.IntegerType, false),

						DataTypes.createStructField("country", DataTypes.StringType, false),
						DataTypes.createStructField("city", DataTypes.StringType, false) });

		Dataset<Row> tempDataFields = spSession.createDataFrame(rowRDD, schema);
		tempDataFields.show();

		movieData.createOrReplaceTempView("autos");
		System.out.println("Temp Table Contents");
		System.out.println("showing all fields with hp greater than 200");

		//spSession.sql("select * from autos where hp>200").show();
		// to find make,maximum RPM from autos group by make
		//System.out.println("to find make,maximum RPM from autos group by make");
		//spSession.sql("select make,max(rpm) from autos group by make").show();
		//spSession.sql("select make,max(rpm) from autos group by make order by 2").show();

		// convert DataFram to JavaRDD
		JavaRDD<Row> autoRDD = movieData.rdd().toJavaRDD();
		Map<String, String> jdbcparam = new HashMap<String, String>();
		jdbcparam.put("url", "jdbc:mysql://localhost:3306/test");
		jdbcparam.put("driver", "com.mysql.jdbc.Driver");
		jdbcparam.put("dbtable", "employee");
		jdbcparam.put("user", "root");
		//jdbcparam.put("password", "root@123");
		
		Dataset<Row> sqlData = spSession.read().format("jdbc").options(jdbcparam).load();
		System.out.println("........................read data from database");
		sqlData.show();
	}
}
