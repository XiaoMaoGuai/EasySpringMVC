package com.xiaomaoguai.lib.core.i18n;

import java.util.ResourceBundle;

/*
 * @Description :
 * @FileName: ResourceBundleProvider.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午2:14:20
 * @Version:1.0.0
 */
/**
 * 资源集提供者，可以提供ResourceBundle集，也可以提供ResourceLocations
 * 
 */
public interface ResourceBundleProvider {

	/**
	 * 提供资源集
	 */
	ResourceBundle[] getResourceBundles();

	/**
	 * 提供资源名称集
	 */
	String[] getResourceLocations();
}