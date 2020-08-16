package com.shadow.spring.importBean;

import com.shadow.spring.importBean.beans.ImportSelectorDemo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author shadow
 * @create 2020-08-16
 * @description
 */
public class MyImportSelector implements ImportSelector {

	private String[] importSelectors = {ImportSelectorDemo.class.getName()};

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return importSelectors;
	}
}
