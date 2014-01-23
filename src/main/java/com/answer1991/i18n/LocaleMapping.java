package com.answer1991.i18n;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class LocaleMapping implements Map<Locale, String> {
	private Map<Locale, String> innerMap;
	private String defaultValue;

	public LocaleMapping() {
	}
	
	@Override
	public int size() {
		return innerMap.size();
	}

	@Override
	public boolean isEmpty() {
		return innerMap.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return innerMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return innerMap.containsKey(value);
	}

	@Override
	public String get(Object key) {
		if(containsKey(key)) {
			return innerMap.get(key);
		}
		else {
			return defaultValue;
		}
	}

	@Override
	public String put(Locale key, String value) {
		return innerMap.put(key, value);
	}

	@Override
	public String remove(Object key) {
		return innerMap.remove(key);
	}

	@Override
	public void putAll(Map<? extends Locale, ? extends String> m) {
		innerMap.putAll(m);
	}

	@Override
	public void clear() {
		innerMap.clear();
	}

	@Override
	public Set<Locale> keySet() {
		return innerMap.keySet();
	}

	@Override
	public Collection<String> values() {
		return innerMap.values();
	}

	@Override
	public Set<java.util.Map.Entry<Locale, String>> entrySet() {
		return innerMap.entrySet();
	}

	public Map<Locale, String> getInnerMap() {
		return innerMap;
	}

	public void setInnerMap(Map<Locale, String> innerMap) {
		this.innerMap = innerMap;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
