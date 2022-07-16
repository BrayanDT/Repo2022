package Common;

import java.io.File;

public class Config
{
    public static String URL_QA ="http://automationpractice.com/index.php";
    public static String URL_DEV ="http://automationpractice.com/index.php";
    public static String URL_AMZ ="https://www.amazon.com.mx/";
    public static String URL_DRAG_AND_DROP = "https://jqueryui.com/droppable/";
    public static String URL_FILE_UPLOAD = ARCHIVOS_DIR() + "upload_file.html";

    public static String user = "test.0@test.com";
    public static String password = "test1234";

    public static String ARCHIVOS_DIR()
    {
        return System.getProperty("user.dir")
                + File.separator
                + "Files"
                + File.separator;
    }

}
