package jp.co.loft.backoffice.api.common.message;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * MessageKeysクラスを作成するクラス。<br>
 * メッセージプロパティファイルからMessageKeysを作成する。<br>
 * 
 * Javaアプリケーションとして実行する。<br>
 * 
 * @author 7NM T. Hayakawa
 * @version 0.1.0
 * @since 0.1.0
 */
public class MessageKeysGen {

    /** メッセージプロパティファイル。 */
    private static final String MESSAGES_PROPERTIES = "src/main/resources/messages_en.properties";

    /**
     * MessageKeysクラス作成。<br>
     * Javaアプリケーションとして起動する。<br>
     * 
     * @param args
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(MESSAGES_PROPERTIES);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        Class<?> targetClazz = MessageKeys.class;
        File output = new File("src/main/java/" + targetClazz.getName().replaceAll(Pattern.quote("."),
                                                                                   "/")
                + ".java");
        System.out.println("write " + output.getAbsolutePath());
        PrintWriter pw = new PrintWriter(FileUtils.openOutputStream(output));

        try {
            pw.println("package " + targetClazz.getPackage().getName() + ";");
            pw.println("/**");
            pw.println(" * Message Id(MessageKeysGenクラスの実行による自動生成クラス)");
            pw.println(" */");
            pw.println("public class " + targetClazz.getSimpleName() + " {");

            String line;
            while ((line = br.readLine()) != null) {
                String[] vals = line.split("=",
                                           2);
                if (vals.length > 1) {
                    String key = vals[0].trim();
                    String value = vals[1].trim();
                    pw.println("    /** " + key + "=" + value + " */");
                    pw.println("    public static final String " + key.toUpperCase().replaceAll(Pattern.quote("."),
                                                                                                "_").replaceAll(Pattern.quote("-"),
                                                                                                                "_")
                            + " = \"" + key + "\";");
                }
            }
            pw.println("}");
            pw.flush();
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(pw);
        }
    }

}
