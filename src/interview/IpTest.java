package interview;

public class IpTest {

    public static void main(String[] args) {
        String ip = "192.168.23.106";
        int intIp = stringIpToIntIp(ip);
        System.out.println(intIp);
        System.out.println(intIpToStringIp(intIp));
    }

    /**
     * string类型ip转int类型ip
     */
    public static int stringIpToIntIp(String ip) {
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            throw new IllegalArgumentException("请传入正确的ipv4地址");
        }
        StringBuilder str = new StringBuilder();
        for (String s : ips) {
            int i = Integer.parseInt(s);
            if (i > 255 || i < 0) {
                throw new IllegalArgumentException("请传入正确的ipv4地址");
            }
            String bs = Integer.toBinaryString(i);
            str.append(String.format("%8s", bs).replace(" ", "0"));
        }

        //二进制字符串转10进制,因为Integer.parseInt对负数转的问题,所以自己手写了转化的方法
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            String a = str.substring(i, i + 1);
            n = n << 1;
            if (a.equals("1")) {
                n = n | 1;
            }
        }
        return n;
    }

    /**
     * int类型ip转string类型ip
     */
    public static String intIpToStringIp(int intIp) {
        String str = Integer.toBinaryString(intIp);
        StringBuilder strIp = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int sIp = Integer.parseInt(str.substring(i * 8, (i + 1) * 8), 2);
            strIp.append(sIp).append(".");
        }
        return strIp.substring(0, strIp.length() - 1);
    }

}

