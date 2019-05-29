package us.codecraft.tinyioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yihua.huang@dianping.com
 */
public class BeanFactory {

	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	// 查
	public Object getBean(String name) {
		return beanDefinitionMap.get(name).getBean();
	}

	// 增，给map中增加一个bean
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
	}

	// 删， 去掉bean
	public Object deleteBeanDefinition(String name) {
		BeanDefinition removedBean = beanDefinitionMap.remove(name);
        Object bean = removedBean.getBean();
        return bean;
	}

	// 改， 需要修改bean嘛？ 不用


}
