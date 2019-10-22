package cn.run.java.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 17:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 数据载体
   */
  private Collection<T> list = new ArrayList<>();

  /**
   * 总条数
   */
  private Long total = 0L;

  /**
   * 数据载体
   */
  private T data = null;

  /**
   * 提示信息
   */
  private String msg = "执行成功";

  /**
   * 状态码
   */
  private Integer code = 0;

  /**
   * 成功返回信息
   *
   * @param msg 提示信息
   * @return {@link R}
   */
  public static <T> R<T> ok(String msg) {
    return new R<T>().setMsg(msg);
  }

  /**
   * 成功返回信息
   *
   * @param data 报文主体
   * @return {@link R}
   */
  public static <T> R<T> ok(T data) {
    return new R<T>().setData(data);
  }


  /**
   * 成功返回信息
   *
   * @param msg  提示信息
   * @param data 报文主体
   * @return {@link R}
   */
  public static <T> R<T> ok(String msg, T data) {
    return new R<T>().setMsg(msg).setData(data);
  }

  /**
   * 错误返回信息
   *
   * @param msg 提示信息
   * @return {@link R}
   */
  public static <T> R<T> error(String msg) {
    return new R<T>().setMsg(msg).setCode(500);
  }

  /**
   * 错误返回信息
   *
   * @param msg 提示信息
   * @return {@link R}
   */
  public static <T> R<T> error(String msg, Integer code) {
    return new R<T>().setMsg(msg).setCode(code);
  }

  /**
   * 成功返回信息
   *
   * @param data 报文主体
   * @return {@link R}
   */
  public static <T> R<T> list(List<T> data) {
    return new R<T>().setList(data).setTotal((long) data.size());
  }


  /**
   * 成功返回信息
   *
   * @param total 总条数
   * @param data  报文主体
   * @return {@link R}
   */
  public static <T> R<T> list(Long total, List<T> data) {
    return new R<T>().setList(data).setTotal(total);
  }

  /**
   * 成功返回信息
   *
   * @param data  报文主体
   * @param total 总条数
   * @return {@link R}
   */
  public static <T> R<T> list(List<T> data, Long total) {
    return new R<T>().setList(data).setTotal(total);
  }
}
