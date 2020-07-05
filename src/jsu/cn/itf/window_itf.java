package jsu.cn.itf;

// TODO: Auto-generated Javadoc
/**
 * The Interface window_itf.
 *窗口基本操作接口
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public interface window_itf {

/**
 * Voluation. 
 *     初始化变量
 */
public abstract void voluation();

/**
 * Location.
 * 初始定位
 */
public abstract void location();

/**
 * Adds the component.
 * 添加组件
 */
public abstract void addComponent();

/**
 * Sets the up.
 * 设置字体
 */
public abstract void setUp();

/**
 * Window listener closing.
 * 为窗口添加窗口监听器
 */
public abstract void windowListener_Closing();
}
