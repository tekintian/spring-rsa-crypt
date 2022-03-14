package cn.tekin.rsacrypt.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class JsonUtil {

  private static Gson gson =
      new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();

  /**
   * @MethodName : toJson @Description : 将对象转为JSON串，此方法能够满足大部分需求
   *
   * @param src :将要被转化的对象
   * @return :转化后的JSON串
   */
  public static String toJson(Object src) {
    if (src == null) {
      return gson.toJson(JsonNull.INSTANCE);
    }
    return gson.toJson(src);
  }

  /**
   * 输出JSON
   *
   * @param data
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  public static void outJson(HashMap<String, Object> data, HttpServletResponse resp)
      throws ServletException, IOException {
    String jsonStr = JsonUtil.toJson(data);
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    resp.getWriter().write(jsonStr);
    resp.getWriter().flush();
    PrintWriter out = resp.getWriter();
    out.flush();
    out.close();
  }
}
