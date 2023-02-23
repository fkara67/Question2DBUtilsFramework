package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;


public class Question2StepDef {
    private static int count = 0;

    @Given("{string} {string} {int} should match the DB record")
    public void should_match_the_db_record(String month, String staff_name, double sales_count) {
        String query = "SELECT TO_CHAR(payment_date,'Month') AS month,CONCAT(first_name,' ',last_name) AS staff_name,COUNT(*) AS sales_count \n" +
                "FROM staff s\n" +
                "JOIN payment p ON p.staff_id = s.staff_id\n" +
                "GROUP BY s.staff_id,TO_CHAR(payment_date,'Month'),EXTRACT(Month FROM payment_date)\n" +
                "ORDER BY EXTRACT(Month FROM payment_date)";

        List<Map<String, Object>> resultMapList = DBUtils.getQueryResultMap(query);
        Map<String,Object> map = resultMapList.get(count++);
        Assert.assertEquals(month, map.get("month").toString().trim());
        Assert.assertEquals(staff_name, map.get("staff_name"));
        Assert.assertEquals(map.get("sales_count"),(long)sales_count);

    }
}
