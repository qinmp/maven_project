package com.util.string;

import java.beans.PropertyEditorSupport;

import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

public class StringEscapeEditor extends PropertyEditorSupport {

	private boolean escapeHTML;// 编码HTML
	private boolean escapeJavaScript;// 编码javascript
	private boolean escapeTrim;// 去空格

	public StringEscapeEditor() {
		super();
	}

	public StringEscapeEditor(boolean escapeHTML, boolean escapeJavaScript, boolean escapeTrim) {
		super();
		this.escapeHTML = escapeHTML;
		this.escapeJavaScript = escapeJavaScript;
		this.escapeTrim = escapeTrim;
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null) {
			setValue(null);
		} else {
			if (escapeHTML) {
				text = HtmlUtils.htmlEscape(text);
			}
			if (escapeJavaScript) {
				text = JavaScriptUtils.javaScriptEscape(text);
			}
			if (escapeTrim) {
				text = text.trim();
			}
			setValue(text);
		}
	}
}

