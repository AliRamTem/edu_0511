import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProxyChecker {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String FILE_NAME = "C:/java/ip.txt";  // сюда сохранятся айпи считаные с сайта
    public static final String FILE_NAME2 = "C:/java/ip2.txt"; // здесь лежат айпи вручную добавленные в файл как на уроке
    public static final String FILE_NAME3 = "C:/java/result.txt"; // сюда сохраняет рабочие айпи
    public static final Object lock = new Object();

    private static String proxyUrl = "https://hidemy.life/ru/proxy-list-servers";  // юбой сайт до которого можно достучаться без vpn и он содержит прокси лист

    static FileWriter writer = null;

    public static void main(String[] args) throws IOException {
        //getContent(); // получаем и записываем в файл айпи с портами
        writer = new FileWriter(FILE_NAME3, true);
        readFileAndCheck(FILE_NAME2);
        System.out.println("***********************");
    }

    private static void getContent() {
        URL url = null;
        HttpURLConnection urlConnection = null;
        StringBuilder result = new StringBuilder();
        try {
            url = new URL(proxyUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                result.append(line);
                line = reader.readLine();
            }
            FileWriter writer = new FileWriter(FILE_NAME);
            Pattern pattern2 = Pattern.compile("(\\d{1,3}).(\\d{1,3}).(\\d{1,3}).(\\d{1,3})</td><td>(\\d{1,5})");
            Matcher matcher2 = pattern2.matcher(result);
            while (matcher2.find()) {
                writer.write(matcher2.group().replaceAll("</td><td>", ":") + "\n");
            }
            writer.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();

        }
    }

    private static String checkProxy(String ip, int port) {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip, port));
            URLConnection urlConnection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            urlConnection.setConnectTimeout(3000);
            urlConnection.setReadTimeout(3000);

            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read()) != -1){
                sb.append((char)rc);
            }
            synchronized (lock) {
                writer.write(ip + ":" + port + "\n");
                writer.flush();
            }
            return "IP: "+ip+":"+port+ANSI_GREEN+" работает"+ANSI_RESET;
        } catch (Exception e) {
            return "IP: "+ip+":"+port+ANSI_RED+" не работает"+ANSI_RESET;
        }
    }

    private static void readFileAndCheck(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                String ip = line.replaceAll("\t", ":").split(":")[0];
                int port = Integer.parseInt(line.replaceAll("\t", ":").split(":")[1]);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(checkProxy(ip,port));
                    }
                });
                thread.start();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
