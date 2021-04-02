package us.codecraft.webmagic;

import us.codecraft.webmagic.utils.HttpConstant;

import java.util.*;

/**
 * Object contains setting for crawler.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @see us.codecraft.webmagic.processor.PageProcessor
 * @since 0.1.0
 */
public class Site {

    private String domain;

    private String userAgent;

    private Map<String, String> defaultCookies = new LinkedHashMap<String, String>();

    private Map<String, Map<String, String>> cookies = new HashMap<String, Map<String, String>>();

    private String charset;

    private int sleepTime = 5000;

    private int retryTimes = 0;

    private int cycleRetryTimes = 0;

    private int retrySleepTime = 1000;

    private int timeOut = 5000;

    private static final Set<Integer> DEFAULT_STATUS_CODE_SET = new HashSet<Integer>();

    private Set<Integer> acceptStatCode = DEFAULT_STATUS_CODE_SET;

    private Map<String, String> headers = new HashMap<String, String>();

    private boolean useGzip = true;

    private boolean disableCookieManagement = false;

    static {
        DEFAULT_STATUS_CODE_SET.add(HttpConstant.StatusCode.CODE_200);
    }

    /**
     * new a Site
     *
     * @return new site
     */
    public static Site me() {
        return new Site();
    }

    /**
     * Add a cookie with domain {@link #getDomain()}
     *
     * @param name name
     * @param value value
     * @return this
     */
    public Site addCookie(String name, String value) {
        defaultCookies.put(name, value);
        return this;
    }

    /**
     * Add a cookie with specific domain.
     *
     * @param domain domain
     * @param name name
     * @param value value
     * @return this
     */
    public Site addCookie(String domain, String name, String value) {
        if (!cookies.containsKey(domain)){
            cookies.put(domain,new HashMap<String, String>());
        }
        cookies.get(domain).put(name, value);
        return this;
    }

    /**
     * set user agent
     *
     * @param userAgent userAgent
     * @return this
     */
    public Site setUserAgent(String userAgent) {
        this.u