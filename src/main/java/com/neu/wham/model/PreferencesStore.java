package com.neu.wham.model;

import java.util.ArrayList;

public class PreferencesStore {
	private ArrayList<String> formats, categories, subcategories;
	
	public PreferencesStore() {
		formats = new ArrayList<String>();
		categories = new ArrayList<String>();
		subcategories = new ArrayList<String>();
	}
	
	public String[] getFormats() {
		String[] tmp = new String[formats.size()];
		tmp = formats.toArray(tmp);
		return tmp;
	}
	
	public String[] getCategories() {
		String[] tmp = new String[categories.size()];
		tmp = categories.toArray(tmp);
		return tmp;
	}
	
	public String[] getSubcategories() {
		String[] tmp = new String[subcategories.size()];
		tmp = subcategories.toArray(tmp);
		return tmp;
	}
	
	public void addFormat(String newFormat) { 
		formats.add(newFormat);
	}
	
	public void addCategory(String newCategory) {
		categories.add(newCategory);
	}
	
	public void addSubcategory(String newSubcategory) {
		subcategories.add(newSubcategory);
	}
}
