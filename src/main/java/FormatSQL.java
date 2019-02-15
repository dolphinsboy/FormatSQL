import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.util.JdbcConstants;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.io.FileUtils;

import java.io.File;


public class FormatSQL {
    public static void main(String []args){
        Options options = new Options();
        options.addOption("f", true, "sql file");

        String filePath;
        try{
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse( options, args);
            if (cmd.hasOption("f")){
                filePath = cmd.getOptionValue("f");
                String sql = FileUtils.readFileToString(new File(filePath), "UTF-8");
                String result = SQLUtils.format(sql, JdbcConstants.MYSQL);
                System.out.println(result); // 缺省大写格式
            }else{
                System.out.println("Not found option file");
            }
        }catch (Exception e){
            System.err.println(e);
        }

    }
}
